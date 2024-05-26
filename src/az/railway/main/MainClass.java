package az.railway.main;

import az.railway.dao.impl.*;
import az.railway.dao.interf.*;
import az.railway.model.*;
import az.railway.service.impl.*;
import az.railway.service.interf.*;
import az.railway.utility.Utility;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RouteClassDao routeClassDao = new RouteClassDaoImpl();
        RouteClassService routeClassService = new RouteClassServiceImpl(routeClassDao);
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            System.out.println("1.Customer\n2.User");
            int choiceUser = sc.nextInt();
            sc.nextLine();
            switch (choiceUser) {
                case 1: {
                    System.out.println("1.Log in\n2.Sign up");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.print("Please enter your username: ");
                            String username = sc.nextLine();
                            System.out.print("Please enter your password: ");
                            String password = sc.nextLine();
                            Customer mainCustomer = Utility.logIn(username, password);
                            if (mainCustomer != null) {
                                System.out.print("          Welcome Railway " + mainCustomer.getName() + " " + mainCustomer.getSurname() + "\n");
                                System.out.println("What do you want to do?\n1.Buy a ticket\n2.View the train timetable\n3.View journeys and ticket prices\n4.View previously purchased tickets\n5.Exit");
                                int choiceCustomer = sc.nextInt();
                                sc.nextLine();
                                switch (choiceCustomer) {
                                    case 1:
                                        StationDao stationDao = new StationDaoImpl();
                                        StationService stationService = new StationServiceImpl(stationDao);
                                        Payment payment = new Payment();
                                        Ticket ticket = new Ticket();
                                        Boolean isFlag = false;
                                        List<Station> stationList = stationService.getStationList();
                                        stationList.forEach(System.out::println);
                                        System.out.print("From Where: ");
                                        Long beginStationId = sc.nextLong();
                                        sc.nextLine();
                                        System.out.print("To Where: ");
                                        Long endStationId = sc.nextLong();
                                        sc.nextLine();
                                        String routeName = Utility.choiceRoute(beginStationId, endStationId);
                                        if (routeName == null || beginStationId == endStationId) {
                                            System.err.println("Sorry, no such trip is available");
                                            return;
                                        }
                                        List<RouteClass> routeClassList = Utility.choiceClassOfRoute(routeName);
                                        routeClassList.forEach(System.out::println);
                                        System.out.println("Please select class of route by id: ");
                                        Long routeId = sc.nextLong();
                                        sc.nextLine();
                                        for (RouteClass routeClass : routeClassList) {
                                            if (routeId == routeClass.getId()) {
                                                isFlag = true;
                                            }
                                        }
                                        if (!isFlag) {
                                            throw new IllegalArgumentException("Enter correct id");
                                        }
                                        RouteClass routeClassName = routeClassService.getRouteClassById(routeId);
                                        List<TrainTimeStation> trainTimeStationList = Utility.choiceTimeOfRoute(routeClassName);
                                        trainTimeStationList.forEach(System.out::println);
                                        System.out.println("Please select time of route by train number: ");
                                        int trainNumber = sc.nextInt();
                                        sc.nextLine();
                                        List<TrainTimeStation> trainTimeStationList1 = Utility.selectTimeOfRoute(trainTimeStationList, trainNumber);
                                        if (trainTimeStationList1.isEmpty()) {
                                            throw new IllegalArgumentException("Enter correct train number");
                                        }
                                        String time = "";
                                        for (TrainTimeStation trainTimeStation : trainTimeStationList1) {
                                            String beginTime = trainTimeStation.getTime();
                                            for (TrainTimeStation trainTimeStation1 : trainTimeStationList1) {
                                                String endTime = trainTimeStation1.getTime();
                                                time = beginTime + " - " + endTime;
                                            }
                                            break;
                                        }
                                        List<Wagon> wagonList = Utility.selectWagonOfRoute(routeClassName);
                                        wagonList.forEach(System.out::println);
                                        System.out.println("Please select Wagon by Id: ");
                                        Long wagonId = sc.nextLong();
                                        sc.nextLine();
                                        Boolean isWagon = Utility.checkWagonId(wagonList, wagonId);
                                        if (!isWagon) {
                                            throw new IllegalArgumentException("Enter correct wagon id");
                                        }
                                        WagonDao wagonDao = new WagonDaoImpl();
                                        WagonService wagonService = new WagonServiceImpl(wagonDao);
                                        Wagon selectedWagon = wagonService.getWagonById(wagonId);
                                        List<Row> rowList = Utility.selectRowOfWagon(selectedWagon);
                                        rowList.forEach(System.out::println);
                                        System.out.println("Please select Row by Id: ");
                                        Long rowId = sc.nextLong();
                                        sc.nextLine();
                                        Boolean isRow = Utility.checkRowId(rowList, rowId);
                                        if (!isRow) {
                                            throw new IllegalArgumentException("Enter correct row id");
                                        }
                                        RowDao rowDao = new RowDaoImpl();
                                        RowService rowService = new RowServiceImpl(rowDao);
                                        Row selectedRow = rowService.getRowById(rowId);
                                        List<Place> placeList = Utility.selectPlaceOfRow(selectedRow);
                                        placeList.forEach(System.out::println);
                                        System.out.println("Please select Place by Id: ");
                                        Long placeId = sc.nextLong();
                                        sc.nextLine();
                                        Boolean isPlace = Utility.checkPlaceId(placeList, placeId);
                                        if (!isPlace) {
                                            throw new IllegalArgumentException("Enter correct Place id");
                                        }
                                        PlaceDao placeDao = new PlaceDaoImpl();
                                        PlaceService placeService = new PlaceServiceImpl(placeDao);
                                        Place selectedPlace = placeService.getPlaceById(placeId);
                                        long randomQr = Utility.setRandomQr();
                                        ticket.setQr(randomQr);
                                        ticket.setCustomer(mainCustomer);
                                        ticket.setRouteClass(routeClassName);
                                        ticket.setPlace(selectedPlace);
                                        ticket.setTime(time);
                                        System.out.println("How many tickets do you want to buy?");
                                        long ticketCount = sc.nextLong();
                                        sc.nextLine();
                                        float amount = ticket.getRouteClass().getRoutePrice() * ticketCount;
                                        System.out.println("Please make payment! The amount you have to pay: " + amount + " AZN");
                                        float paymentPrice = sc.nextFloat();
                                        if (paymentPrice == amount) {
                                            PaymentDao paymentDao = new PaymentDaoImpl();
                                            PaymentService paymentService = new PaymentServiceImpl(paymentDao);
                                            payment.setTicketCount(ticketCount);
                                            payment.setAmount(amount);
                                            TicketDao ticketDao = new TicketDaoImpl();
                                            TicketService ticketService = new TicketServiceImpl(ticketDao);
                                            ticketService.addTicket(ticket);
                                            List<Ticket> ticketList = ticketService.getTicketList();
                                            for (Ticket ticketPayment : ticketList) {
                                                if (ticketPayment.getQr() == randomQr) {
                                                    payment.setTicket(ticketPayment);
                                                }
                                            }
                                            paymentService.addPayment(payment);
                                            System.out.println("The payment was successfully");
                                            System.out.println("The ticket buying successfully");
                                        } else {
                                            System.err.println("Payment failed!");
                                            System.exit(1);
                                        }
                                        break;
                                    case 2:
                                        TrainTimeStationDao trainTimeStationDao = new TrainTimeStationDaoImpl();
                                        TrainTimeStationService trainTimeStationService = new TrainTimeStationServiceImpl(trainTimeStationDao);
                                        List<TrainTimeStation> trainTimeStationList2 = trainTimeStationService.getTrainTimeStationList();
                                        trainTimeStationList2.forEach(System.out::println);
                                        break;
                                    case 3:
                                        List<RouteClass> routeaClassList = routeClassService.getRouteClassList();
                                        routeaClassList.forEach(System.out::println);
                                        break;
                                    case 4: {
                                        TicketDao ticketDao1 = new TicketDaoImpl();
                                        TicketService ticketService1 = new TicketServiceImpl(ticketDao1);
                                        List<Ticket> listTickets = ticketService1.getTicketList();
                                        Boolean isTicket = false;
                                        for (Ticket ticket1 : listTickets) {
                                            if (ticket1.getCustomer().getName().equals(mainCustomer.getName()) & ticket1.getCustomer().getSurname().equals(mainCustomer.getSurname())) {
                                                isTicket = true;
                                                System.out.println(ticket1.getQr() + " -- " + ticket1.getCustomer().getName() + " " + ticket1.getCustomer().getSurname() +
                                                        " -- " + ticket1.getRouteClass().getBeginStation().getStationName() + "-" + ticket1.getRouteClass().getEndStation().getStationName() + " Time:  " + ticket1.getTime() + " -- "
                                                        + ticket1.getRouteClass().getaClass().getClassName() + " Vaqon : " + ticket1.getPlace().getWagon().getWagonName() + " Sira: " +
                                                        ticket1.getPlace().getRow().getRowName() + " Yer: " + ticket1.getPlace().getPlaceName() + " -- " + ticket1.getRouteClass().getRoutePrice() + " AZN ");
                                            }
                                        }
                                        if (!isTicket) {
                                            throw new IllegalArgumentException("Sorry, you haven't bought a ticket yet");
                                        }
                                    }
                                    break;
                                    case 5:
                                        System.out.println("Thank you for using Railway!");
                                        main(args);
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                }
                            } else {
                                throw new IllegalArgumentException("Invalid login or password");
                            }
                            break;
                        case 2: {
                            CustomerDao customerDao = new CustomerDaoImpl();
                            CustomerService customerService = new CustomerServiceImpl(customerDao);
                            Customer customer = new Customer();
                            System.out.println("Enter your name: ");
                            customer.setName(sc.nextLine());
                            System.out.println("Enter your surname: ");
                            customer.setSurname(sc.nextLine());
                            System.out.println("Enter your Dob: ");
                            customer.setDob(df.parse(sc.nextLine()));
                            System.out.println("Enter your pin: ");
                            customer.setPin(sc.nextLine());
                            System.out.println("Enter your phone: ");
                            customer.setPhone(sc.nextLine());
                            System.out.println("Enter your email: ");
                            customer.setEmail(sc.nextLine());
                            System.out.println("Enter your username: ");
                            customer.setUserName(sc.nextLine());
                            System.out.println("Enter your password: ");
                            customer.setPassword(sc.nextLine());
                            customerService.addCustomer(customer);
                            System.out.println("Customer added successfully");
                            break;
                        }
                        default:
                            throw new IllegalArgumentException("Invalid choice");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Please enter your username: ");
                    String username = sc.nextLine();
                    System.out.print("Please enter your password: ");
                    String password = sc.nextLine();
                    UserRole userRole = Utility.logInUser(username, password);
                    if (userRole != null) {
                        System.out.print("          Welcome " + userRole.getRole().getRoleName() + " " + userRole.getUser().getName() + " " + userRole.getUser().getSurname() + "\n");
                        if (userRole.getRole().getRoleName().equals("Admin")) {
                            System.out.println("What do you want to do?\n1.Add new Employee\n2.Delete Employee\n3.Update TrainTimeStation\n4.Exit\n");
                            int choice = sc.nextInt();
                            sc.nextLine();
                            switch (choice) {
                                case 1: {
                                    Employee employee = new Employee();
                                    System.out.println("Enter employee's name: ");
                                    employee.setName(sc.nextLine());
                                    System.out.println("Enter employee's surname: ");
                                    employee.setSurname(sc.nextLine());
                                    System.out.println("Enter employee's dob: ");
                                    employee.setDob(df.parse(sc.nextLine()));
                                    System.out.println("Enter employee's pin: ");
                                    employee.setPin(sc.nextLine());
                                    System.out.println("Enter employee's phone number: ");
                                    employee.setPhone(sc.nextLine());
                                    System.out.println("Enter employee's address: ");
                                    employee.setAddress(sc.nextLine());
                                    PositionDao positionDao = new PositionDaoImpl();
                                    PositionService positionService = new PositionServiceImpl(positionDao);
                                    List<Position> positionList = positionService.getPositionList();
                                    positionList.forEach(System.out::println);
                                    System.out.println("Enter position id: ");
                                    Long positionId = sc.nextLong();
                                    Position position = positionService.getPositionById(positionId);
                                    if (position != null) {
                                        EmployeeDao employeeDao = new EmployeeDaoImpl();
                                        EmployeeService employeeService = new EmployeeServiceImpl(employeeDao);
                                        employee.setPosition(position);
                                        employeeService.addEmployee(employee);
                                        System.out.println("Employee added successfully");
                                    } else {
                                        System.err.println("Position not found Enter correct position id");
                                    }
                                    break;
                                }
                                case 2: {
                                    EmployeeDao employeeDao = new EmployeeDaoImpl();
                                    EmployeeService employeeService = new EmployeeServiceImpl(employeeDao);
                                    List<Employee> employeeList = employeeService.getEmployeeList();
                                    employeeList.forEach(System.out::println);
                                    System.out.println("Please enter the id of the employee you want to delete");
                                    long deleteEmployeeId = sc.nextLong();
                                    Employee employee = employeeService.getEmployeeById(deleteEmployeeId);
                                    if (employee != null) {
                                        employeeService.deleteEmployee(deleteEmployeeId);
                                        System.out.println("Employee deleted successfully");
                                    } else {
                                        System.err.println("Employee not found Enter correct id");
                                    }
                                    break;
                                }
                                case 3: {
                                    TrainTimeStationDao trainTimeStationDao = new TrainTimeStationDaoImpl();
                                    TrainTimeStationService trainTimeStationService = new TrainTimeStationServiceImpl(trainTimeStationDao);
                                    List<TrainTimeStation> trainTimeStationList = trainTimeStationService.getTrainTimeStationList();
                                    for (TrainTimeStation trainTimeStation : trainTimeStationList) {
                                        System.out.println(trainTimeStation.getId() + "." + trainTimeStation.getTrain().getTrainNumber() + " -> " + trainTimeStation.getTime() + " -> " + trainTimeStation.getStation().getStationName());
                                    }
                                    System.out.println("Please enter the id of the trainTimeStation you want to update");
                                    long updateTrainTimeStationId = sc.nextLong();
                                    TrainTimeStation trainTimeStation = trainTimeStationService.getTrainTimeStationById(updateTrainTimeStationId);
                                    StationDao stationDao = new StationDaoImpl();
                                    StationService stationService = new StationServiceImpl(stationDao);
                                    if (trainTimeStation != null) {
                                        List<Station> stationList = stationService.getStationList();
                                        stationList.forEach(System.out::println);
                                        System.out.print("Please enter new Station Id: ");
                                        Long stationId = sc.nextLong();
                                        Station station = stationService.getStationById(stationId);
                                        if (station != null) {
                                            TrainDao trainDao = new TrainDaoImpl();
                                            TrainService trainService = new TrainServiceImpl(trainDao);
                                            trainTimeStation.setStation(station);
                                            List<Train> trainList = trainService.getTrainList();
                                            trainList.forEach(System.out::println);
                                            System.out.print("Please enter new Train Id: ");
                                            Long trainId = sc.nextLong();
                                            sc.nextLine();
                                            Train train = trainService.getTrainById(trainId);
                                            if (train != null) {
                                                trainTimeStation.setTrain(train);
                                                System.out.println("Please enter new Time: ");
                                                String time = sc.nextLine();
                                                trainTimeStation.setTime(time);
                                                trainTimeStationService.updateTrainTimeStation(trainTimeStation);
                                                System.out.println("Update successfully");

                                            } else {
                                                System.err.println("Train not found Enter correct id");
                                            }
                                        } else {
                                            System.err.println("Station not found Enter correct id");
                                        }
                                    } else {
                                        System.err.println("TrainTimeStation not found Enter correct id");
                                    }
                                    break;
                                }
                                case 4:
                                    System.exit(1);
                                    break;
                                default: {
                                    System.out.println("Invalid choice");
                                }
                            }
                        } else if (userRole.getRole().getRoleName().equals("Direktor")) {
                            System.out.println("What do you want to do?\n1.Create User\n2.Delete User\n3.Exit");
                            int choice = sc.nextInt();
                            sc.nextLine();
                            switch (choice) {
                                case 1: {
                                    UserDao userDao = new UserDaoImpl();
                                    UserService userService = new UserServiceImpl(userDao);
                                    User user = new User();
                                    System.out.println("Enter user's name: ");
                                    user.setName(sc.nextLine());
                                    System.out.println("Enter user's surname: ");
                                    user.setSurname(sc.nextLine());
                                    System.out.println("Enter user's dob: ");
                                    user.setDob(df.parse(sc.nextLine()));
                                    System.out.println("Enter user's pin: ");
                                    user.setPin(sc.nextLine());
                                    System.out.println("Enter user's phone number: ");
                                    user.setPhone(sc.nextLine());
                                    System.out.println("Enter user's email: ");
                                    user.setEmail(sc.nextLine());
                                    System.out.println("Enter username: ");
                                    user.setUserName(sc.nextLine());
                                    System.out.println("Enter password: ");
                                    user.setPassword(sc.nextLine());
                                    System.out.println("Please enter the id of the role you want to add user");
                                    long addRoleId = sc.nextLong();
                                    RoleDao roleDao = new RoleDaoImpl();
                                    RoleService roleService = new RoleServiceImpl(roleDao);
                                    Role role = roleService.getRoleById(addRoleId);
                                    if (role != null) {
                                        UserRoleDao userRoleDao = new UserRoleDaoImpl();
                                        UserRoleService userRoleService = new UserRoleServiceImpl(userRoleDao);
                                        UserRole addUserRole = new UserRole();
                                        addUserRole.setUser(user);
                                        addUserRole.setRole(role);
                                        userService.addUser(user);
                                        userRoleService.addUserRole(addUserRole);
                                        System.out.println("User created successfully");
                                    } else {
                                        System.err.println("Role not found Enter correct id");
                                        return;
                                    }
                                }
                                break;
                                case 2: {
                                    UserDao userDao = new UserDaoImpl();
                                    UserService userService = new UserServiceImpl(userDao);
                                    List<User> userList = userService.getUserList();
                                    userList.forEach(System.out::println);
                                    System.out.println("Please enter the id of the user you want to delete");
                                    long deleteUserId = sc.nextLong();
                                    User user = userService.getUserById(deleteUserId);
                                    if (user != null) {
                                        userService.deleteUser(deleteUserId);
                                        System.out.println("User deleted successfully");
                                    } else {
                                        System.err.println("User not found Enter correct id");
                                    }
                                    break;
                                }
                                case 3: {
                                    System.exit(1);
                                    break;
                                }
                                default:
                                    throw new IllegalArgumentException("Invalid choice");
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid username or password");
                    }
                    break;
                }
                default:
                    throw new IllegalArgumentException("Invalid choice");
            }
        } catch (InputMismatchException ex) {
            System.err.println("Enter correctly!");
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.err.println("Enter correctly!");
        } catch (Exception ex) {
            System.err.println("Something went wrong");
        }
    }
}