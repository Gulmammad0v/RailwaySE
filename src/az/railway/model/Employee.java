package az.railway.model;


import java.util.Date;

public class Employee extends Railway {
    private String name;
    private String surname;
    private Date Dob;
    private String pin;
    private String phone;
    private String address;
    private Position position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date dob) {
        Dob = dob;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return getId() + "." + getName() + " -- " + getSurname() + " -- " + getDob() + " -- " + getPin() + " -- " + getPhone() + " -- " + getAddress() + " -- " + getPosition().getPositionName();
    }
}
