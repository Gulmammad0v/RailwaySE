package az.railway.sql;

public class UpdateConstant {
    public static final String UPDATE_CLASS = "UPDATE CLASS SET CLASS_NAME=? WHERE ID=?";
    public static final String DELETE_CLASS = "UPDATE CLASS SET ACTIVE=0 WHERE ID=?";
    public static final String UPDATE_CUSTOMER = "UPDATE CUSTOMER SET USER_NAME=?,PASSWORD=?,NAME=?,SURNAME=?,DOB=?,PIN=?,PHONE=?,E_MAIL=? WHERE ID=?";
    public static final String DELETE_CUSTOMER = "UPDATE CUSTOMER SET ACTIVE=0 WHERE ID=?";
    public static final String UPDATE_POSITION = "UPDATE POSITION SET POSITION_NAME=? WHERE ID=?";
    public static final String DELETE_POSITION = "UPDATE POSITION SET ACTIVE=0 WHERE ID=?";
    public static final String UPDATE_ROLE = "UPDATE ROLE SET ROLE_NAME=? WHERE ID=?";
    public static final String DELETE_ROLE = "UPDATE ROLE SET ACTIVE=0 WHERE ID=?";
    public static final String UPDATE_ROUTE_TYPE = "UPDATE ROUTE_TYPE SET TYPE_NAME=? WHERE ID=?";
    public static final String DELETE_ROUTE_TYPE = "UPDATE ROUTE_TYPE SET ACTIVE=0 WHERE ID=?";
    public static final String UPDATE_STATION = "UPDATE STATION SET STATION_NAME=? WHERE ID=?";
    public static final String DELETE_STATION = "UPDATE STATION SET ACTIVE=0 WHERE ID=?";
    public static final String UPDATE_TRAIN = "UPDATE TRAIN SET TRAIN_NUMBER=? , DIRECTION_ID = ? WHERE ID=?";
    public static final String DELETE_TRAIN = "UPDATE TRAIN SET ACTIVE=0 WHERE ID=?";
    public static final String UPDATE_USER = "UPDATE \"USER\" SET NAME=?,SURNAME=?,DOB=?,PIN=?,PHONE=?,E_MAIL=?,USER_NAME=?,PASSWORD=? WHERE ID=?";
    public static final String DELETE_USER = "UPDATE \"USER\" SET ACTIVE=0 WHERE ID=?";
    public static final String UPDATE_EMPLOYEE = "UPDATE EMPLOYEE SET NAME=?,SURNAME =?,DOB =?,PIN=?,PHONE=?,ADDRESS = ?,POSITION_ID=? WHERE ID = ?";
    public static final String DELETE_EMPLOYEE = "UPDATE EMPLOYEE SET ACTIVE=0 WHERE ID = ?";
    public static final String UPDATE_TRAIN_TIME_STATION = "UPDATE TRAIN_TIME_STATION SET STATION_ID=?,TRAIN_ID=?,TIME = ? WHERE ID=?";
    public static final String DELETE_TRAIN_TIME_STATION = "UPDATE TRAIN_TIME_STATION SET ACTIVE=0 WHERE ID=?";
}
