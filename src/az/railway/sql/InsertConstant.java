package az.railway.sql;


public class InsertConstant {
    public static  final String INSERT_CLASS = "INSERT INTO CLASS (ID, CLASS_NAME) VALUES (CLASS_SEQ.nextval, ?)";
    public static  final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER (ID, NAME, SURNAME, DOB, PIN, PHONE,E_MAIL, USER_NAME,PASSWORD) VALUES (CUSTOMER_SEQ.nextval, ?, ?, ?, ?, ?, ?,?,?)";
    public static final String INSERT_POSITION = "INSERT INTO POSITION (ID, POSITION_NAME) VALUES (POSITION_SEQ.nextval,?)";
    public static final String INSERT_ROLE = "INSERT INTO ROLE (ID, ROLE_NAME) VALUES (ROLE_SEQ.nextval,?)";
    public static final String INSERT_ROUTE_TYPE = "INSERT INTO ROUTE_TYPE (ID, TYPE_NAME) VALUES (ROUTE_TYPE_SEQ.nextval,?)";
    public static final String INSERT_STATION = "INSERT INTO STATION  (ID, STATION_NAME) VALUES (STATION_SEQ.nextval,?)";
    public static final String INSERT_TRAIN = "INSERT INTO TRAIN (ID, TRAIN_NUMBER,DIRECTION_ID) VALUES (TRAIN_SEQ.nextval,?,?)";
    public static final String INSERT_USER = "INSERT INTO \"USER\" (ID, NAME, SURNAME, DOB, PIN, PHONE,E_MAIL, USER_NAME,PASSWORD) VALUES (USER_SEQ.nextval, ?, ?, ?, ?, ?, ?,?,?)";
    public static final String INSERT_TICKET = "INSERT INTO TICKET (ID,QR,CUSTOMER_ID,ROUTE_CLASS_ID,PLACE_ID,TIME) VALUES (TICKET_SEQ.nextval,?,?,?,?,?)";
    public static final String INSERT_PAYMENT = "INSERT INTO Payment (ID, TICKET_COUNT, TICKET_ID, AMOUNT) VALUES (PAYMENT_SEQ.nextval, ?, ?, ?)";
    public static final String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEE (ID, NAME, SURNAME, DOB, PIN, PHONE, ADDRESS, POSITION_ID) VALUES (EMPLOYEE_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";
    public static  final String INSERT_TRAIN_TIME_STATION = "INSERT INTO TRAIN_TIME_STATION (ID, STATION_ID, TRAIN_ID, TIME) VALUES (TRAIN_TIME_STATION_SEQ.nextval, ?, ?, ?)";
    public static final String INSERT_USER_ROLE = "INSERT INTO USER_ROLE (ID, ROLE_ID, USER_ID) VALUES (USER_ROLE_SEQ.nextval, ?, ?)";
    public static final String INSERT_PLACE = "INSERT INTO PLACE (ID, PLACE_NAME,ROW_ID) VALUES (PLACE_SEQ.nextval,?,?)";
    public static final String INSERT_ROUTE = "INSERT INTO ROUTE (ID, BEGIN_STATION_ID,END_STATION_ID,ROUTE_TYPE_ID,DIRECTION_ID) VALUES (ROUTE_SEQ.nextval,?,?,?,?)";
    public static final String INSERT_ROW = "INSERT INTO \"ROW\" (ID, ROW_NAME, WAGON_ID) VALUES (ROW_SEQ.nextval, ?, ?)";
    public static final String INSERT_TRAIN_EMPLOYEE = "INSERT INTO TRAIN_EMPLOYEE (ID,TRAIN_ID,EMPLOYEE_ID) VALUES (TRAIN_EMPLOYEE_SEQ.nextval,?,?)";
    public static final String INSERT_WAGON = "INSERT INTO WAGON (ID, WAGON_NAME,CLASS_ID ) VALUES (WAGON_SEQ.nextval,?,?)";
    public static final String INSERT_ROUTE_CLASS = "INSERT INTO ROUTE_CLASS (ID,ROUTE_ID,CLASS_ID,ROUTE_PRICE) VALUES (ROUTE_CLASS_SEQ.nextval,?,?,?)";
}
