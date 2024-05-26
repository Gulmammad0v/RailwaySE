package az.railway.sql;


public class SelectConstant {
    public static final String GET_CLASS_LIST = "Select * from Class WHERE ACTIVE=1";
    public static final String GET_CLASS_BY_ID = "Select * from Class WHERE ACTIVE=1 AND ID=?";
    public static final String SEARCH_CLASS_DATA = "SELECT * FROM CLASS WHERE ACTIVE=1 AND (LOWER(CLASS_NAME) LIKE LOWER(?))";
    public static final String GET_CUSTOMER_LIST = "Select * from Customer WHERE ACTIVE=1";
    public static final String GET_CUSTOMER_BY_ID = "Select * from Customer WHERE ACTIVE=1 AND ID=?";
    public static final String SEARCH_CUSTOMER_DATA = "SELECT *\n" +
            "FROM CUSTOMER\n" +
            "WHERE ACTIVE = 1\n" +
            "  AND (LOWER(NAME) LIKE LOWER(?) OR LOWER(SURNAME) LIKE LOWER(?))";
    public static final String GET_DIRECTION_LIST = "Select * from DIRECTION WHERE ACTIVE=1";
    public static final String GET_EMPLOYEE_LIST = "SELECT E.ID            employee_id,\n" +
            "       E.NAME          employee_name,\n" +
            "       E.SURNAME       employee_surname,\n" +
            "       E.DOB           employee_dob,\n" +
            "       E.PIN           employee_pin,\n" +
            "       E.PHONE         employee_phone,\n" +
            "       E.ADDRESS       employee_address,\n" +
            "       P.POSITION_NAME position_name\n" +
            "from EMPLOYEE E\n" +
            "         inner join POSITION P\n" +
            "                    on E.POSITION_ID = P.ID\n" +
            "WHERE E.ACTIVE = 1";
    public static final String GET_EMPLOYEE_BY_ID = "SELECT E.ID            employee_id,\n" +
            "       E.NAME          employee_name,\n" +
            "       E.SURNAME       employee_surname,\n" +
            "       E.DOB           employee_dob,\n" +
            "       E.PIN           employee_pin,\n" +
            "       E.PHONE         employee_phone,\n" +
            "       E.ADDRESS       employee_address,\n" +
            "       P.POSITION_NAME position_name\n" +
            "from EMPLOYEE E\n" +
            "         inner join POSITION P\n" +
            "                    on E.POSITION_ID = P.ID\n" +
            "WHERE E.ACTIVE = 1 AND E.ID = ?";
    public static final String GET_PLACE_LIST = "SELECT P.ID          PLACE_ID,\n" +
            "       P.PLACE_NAME  PLACE_NAME,\n" +
            "       R.ROW_NAME    ROW_NAME,\n" +
            "       W.WAGON_NAME  WAGON_NAME,\n" +
            "       C2.CLASS_NAME CLASS_NAME\n" +
            "FROM PLACE P\n" +
            "         INNER JOIN \"ROW\" R on R.ID = P.ROW_ID\n" +
            "         INNER JOIN WAGON W on W.ID = R.WAGON_ID\n" +
            "         INNER JOIN CLASS C2 on C2.ID = W.CLASS_ID\n" +
            "WHERE P.ACTIVE = 1";
    public static final String GET_PLACE_BY_ID = "SELECT P.ID          PLACE_ID,\n" +
            "       P.PLACE_NAME  PLACE_NAME,\n" +
            "       R.ROW_NAME    ROW_NAME,\n" +
            "       W.WAGON_NAME  WAGON_NAME,\n" +
            "       C2.CLASS_NAME CLASS_NAME\n" +
            "FROM PLACE P\n" +
            "         INNER JOIN \"ROW\" R on R.ID = P.ROW_ID\n" +
            "         INNER JOIN WAGON W on W.ID = R.WAGON_ID\n" +
            "         INNER JOIN CLASS C2 on C2.ID = W.CLASS_ID\n" +
            "WHERE P.ACTIVE = 1 AND P.ID=?";
    public static final String GET_WAGON_LIST = "SELECT W.ID WAGON_ID, W.WAGON_NAME WAGON_NAME, C2.CLASS_NAME CLASS_NAME\n" +
            "FROM WAGON W\n" +
            "         INNER JOIN CLASS C2 ON W.CLASS_ID = C2.ID\n" +
            "WHERE W.ACTIVE = 1";
    public static final String GET_WAGON_BY_ID = "SELECT W.ID WAGON_ID, W.WAGON_NAME WAGON_NAME, C2.CLASS_NAME CLASS_NAME\n" +
            "FROM WAGON W\n" +
            "         INNER JOIN CLASS C2 ON W.CLASS_ID = C2.ID\n" +
            "WHERE W.ACTIVE = 1 AND W.ID=?";
    public static final String GET_POSITION_LIST = "Select * from Position WHERE ACTIVE=1";
    public static final String GET_POSITION_BY_ID = "Select * from Position WHERE ACTIVE=1 AND ID=?";
    public static final String SEARCH_POSITION_DATA = "SELECT * FROM POSITION WHERE ACTIVE=1 AND(LOWER(POSITION_NAME) LIKE LOWER(?))";
    public static final String GET_ROLE_LIST = "Select * from ROLE WHERE ACTIVE=1";
    public static final String GET_ROLE_BY_ID = "Select * from ROLE WHERE ACTIVE=1 AND ID=?";
    public static final String SEARCH_ROLE_DATA = "SELECT * FROM ROLE WHERE ACTIVE=1 AND LOWER(ROLE_NAME) LIKE LOWER(?)";
    public static final String GET_ROUTE_LIST = "SELECT R.ID ROUTE_ID, S.STATION_NAME BEGIN_STATION, S2.STATION_NAME END_STATION, RT.TYPE_NAME ROUTE_TYPE_NAME,D.DIRECTION_NAME DIRECTION_NAME\n" +
            "FROM ROUTE R\n" +
            "         INNER JOIN STATION S on S.ID = R.BEGIN_STATION_ID\n" +
            "         INNER JOIN STATION S2 on S2.ID = R.END_STATION_ID\n" +
            "         INNER JOIN ROUTE_TYPE RT on RT.ID = R.ROUTE_TYPE_ID\n" +
            "         INNER JOIN RAILWAY.DIRECTION D on D.ID = R.DIRECTION_ID\n" +
            "WHERE R.ACTIVE = 1\n" +
            "ORDER BY R.ID";
    public static final String GET_ROUTE_TYPE_LIST = "Select * from ROUTE_TYPE WHERE ACTIVE=1";
    public static final String GET_ROUTE_TYPE_BY_ID = "Select * from ROUTE_TYPE WHERE ACTIVE=1 AND ID=?";
    public static final String SEARCH_ROUTE_TYPE_DATA = "SELECT * FROM ROUTE_TYPE WHERE ACTIVE=1 AND LOWER(TYPE_NAME) LIKE LOWER(?)";
    public static final String GET_STATION_LIST = "Select * from STATION WHERE ACTIVE=1";
    public static final String GET_STATION_BY_ID = "Select * from STATION WHERE ACTIVE=1 AND ID=?";
    public static final String SEARCH_STATION_DATA = "SELECT * FROM STATION WHERE ACTIVE=1 AND(LOWER(STATION_NAME) LIKE LOWER(?))";
    public static final String GET_ROW_LIST = "SELECT R.ID ROW_ID, R.ROW_NAME ROW_NAME, W.WAGON_NAME WAGON_NAME,C2.CLASS_NAME CLASS_NAME\n" +
            "FROM \"ROW\" R\n" +
            "         INNER JOIN WAGON W on W.ID = R.WAGON_ID\n" +
            "         inner join CLASS C2 on C2.ID = W.CLASS_ID\n" +
            "WHERE R.ACTIVE = 1 ORDER BY R.ID";
    public static final String GET_ROW_BY_ID = "SELECT R.ID ROW_ID, R.ROW_NAME ROW_NAME, W.WAGON_NAME WAGON_NAME,C2.CLASS_NAME CLASS_NAME\n" +
            "FROM \"ROW\" R\n" +
            "         INNER JOIN WAGON W on W.ID = R.WAGON_ID\n" +
            "         inner join CLASS C2 on C2.ID = W.CLASS_ID\n" +
            "WHERE R.ACTIVE = 1 AND R.ID=? ORDER BY R.ID";
    public static final String GET_TRAIN_LIST = "Select T.ID TRAIN_ID, T.TRAIN_NUMBER TRAIN_NUMBER, D.DIRECTION_NAME DIRECTION_NAME\n" +
            "from TRAIN T\n" +
            "         INNER JOIN RAILWAY.DIRECTION D on D.ID = T.DIRECTION_ID\n" +
            "WHERE T.ACTIVE = 1";
    public static final String GET_TRAIN_BY_ID = "Select T.ID TRAIN_ID, T.TRAIN_NUMBER TRAIN_NUMBER, D.DIRECTION_NAME DIRECTION_NAME\n" +
            "from TRAIN T\n" +
            "         INNER JOIN RAILWAY.DIRECTION D on D.ID = T.DIRECTION_ID\n" +
            "WHERE T.ACTIVE = 1 AND T.ID=?";
    public static final String SEARCH_TRAIN_DATA = "SELECT T.ID TICKET_ID,T.TRAIN_NUMBER TRAIN_NUMBER ,D.DIRECTION_NAME DIRECTION_NAME\n" +
            "FROM TRAIN T\n" +
            "         INNER JOIN DIRECTION D ON T.DIRECTION_ID = D.ID\n" +
            "WHERE ACTIVE = 1\n" +
            "  AND ((TRAIN_NUMBER = ?) OR LOWER(DIRECTION_NAME) LIKE LOWER(?))";
    public static final String GET_USER_LIST = "SELECT * FROM \"USER\" WHERE ACTIVE=1";
    public static final String GET_USER_BY_ID = "SELECT * FROM \"USER\" WHERE ACTIVE=1 AND ID=?";
    public static final String SEARCH_USER_DATA = "SELECT * FROM \"USER\" WHERE ACTIVE=1 AND (LOWER(NAME) LIKE LOWER(?) OR LOWER(SURNAME) LIKE LOWER(?))";
    public static final String GET_USER_ROLE_LIST = "SELECT UR.ID USER_ROLE_ID, U.NAME NAME, U.SURNAME SURNAME,U.USER_NAME USER_NAME,U.PASSWORD PASSWORD , R.ROLE_NAME ROLE_NAME\n" +
            "FROM USER_ROLE UR\n" +
            "         INNER JOIN \"USER\" U on UR.USER_ID = U.ID\n" +
            "         INNER JOIN ROLE R ON UR.ROLE_ID = R.ID\n" +
            "WHERE UR.ACTIVE = 1";
    public static final String GET_TRAIN_TIME_STATION_LIST = "SELECT TTS.ID TRAIN_TIME_STATION_ID, T.TRAIN_NUMBER TRAIN_NUMBER, TTS.TIME TIME, S.STATION_NAME STATION_NAME,D.DIRECTION_NAME DIRECTION_NAME\n" +
            "FROM TRAIN_TIME_STATION TTS\n" +
            "         INNER JOIN STATION S on S.ID = TTS.STATION_ID\n" +
            "         INNER JOIN TRAIN T on TTS.TRAIN_ID = T.ID\n" +
            "         INNER JOIN RAILWAY.DIRECTION D on D.ID = T.DIRECTION_ID\n" +
            "WHERE TTS.ACTIVE = 1\n" +
            "ORDER BY TTS.ID";
    public static final String GET_TRAIN_TIME_STATION_LIST_BY_ID = "SELECT TTS.ID TRAIN_TIME_STATION_ID, T.TRAIN_NUMBER TRAIN_NUMBER, TTS.TIME TIME, S.STATION_NAME STATION_NAME,D.DIRECTION_NAME DIRECTION_NAME\n" +
            "FROM TRAIN_TIME_STATION TTS\n" +
            "         INNER JOIN STATION S on S.ID = TTS.STATION_ID\n" +
            "         INNER JOIN TRAIN T on TTS.TRAIN_ID = T.ID\n" +
            "         INNER JOIN RAILWAY.DIRECTION D on D.ID = T.DIRECTION_ID\n" +
            "WHERE TTS.ACTIVE = 1\n" +
            "ORDER BY TTS.ID AND TTS.ID=? ORDER BY TTS.ID";
    public static final String GET_TRAIN_EMPLOYEE_LIST = "SELECT TE.ID           TRAIN_EMPLOYEE_ID,\n" +
            "       T.TRAIN_NUMBER  TRAIN_NUMBER,\n" +
            "       E.NAME          EMPLOYEE_NAME,\n" +
            "       E.SURNAME       EMPLOYEE_SURNAME,\n" +
            "       P.POSITION_NAME POSITION_NAME\n" +
            "FROM TRAIN_EMPLOYEE TE\n" +
            "         INNER JOIN TRAIN T on T.ID = TE.TRAIN_ID\n" +
            "         INNER JOIN EMPLOYEE E on E.ID = TE.EMPLOYEE_ID\n" +
            "         INNER JOIN POSITION P on P.ID = E.POSITION_ID\n" +
            "WHERE TE.ACTIVE = 1";
    public static final String GET_ROUTE_CLASS_LIST = "SELECT RC.ID            ROUTE_CLASS_ID,\n" +
            "       S.STATION_NAME   BEGIN_STATION,\n" +
            "       S2.STATION_NAME  END_STATION,\n" +
            "       C2.CLASS_NAME    CLASS_NAME,\n" +
            "       RC.ROUTE_PRICE   ROUTE_PRICE,\n" +
            "       D.DIRECTION_NAME DIRECTION_NAME,\n" +
            "       RT.TYPE_NAME     ROUTE_TYPE\n" +
            "FROM ROUTE_CLASS RC\n" +
            "         INNER JOIN ROUTE R on R.ID = RC.ROUTE_ID\n" +
            "         INNER JOIN STATION S on S.ID = R.BEGIN_STATION_ID\n" +
            "         INNER JOIN STATION S2 on S2.ID = R.END_STATION_ID\n" +
            "         INNER JOIN ROUTE_TYPE RT on RT.ID = R.ROUTE_TYPE_ID\n" +
            "         INNER JOIN RAILWAY.DIRECTION D on D.ID = R.DIRECTION_ID\n" +
            "         INNER JOIN RAILWAY.CLASS C2 on RC.CLASS_ID = C2.ID\n" +
            "WHERE RC.ACTIVE = 1";
    public static final String GET_ROUTE_CLASS_BY_ID = "SELECT RC.ID            ROUTE_CLASS_ID,\n" +
            "       S.STATION_NAME   BEGIN_STATION,\n" +
            "       S2.STATION_NAME  END_STATION,\n" +
            "       C2.CLASS_NAME    CLASS_NAME,\n" +
            "       RC.ROUTE_PRICE   ROUTE_PRICE,\n" +
            "       D.DIRECTION_NAME DIRECTION_NAME,\n" +
            "       RT.TYPE_NAME     ROUTE_TYPE\n" +
            "FROM ROUTE_CLASS RC\n" +
            "         INNER JOIN ROUTE R on R.ID = RC.ROUTE_ID\n" +
            "         INNER JOIN STATION S on S.ID = R.BEGIN_STATION_ID\n" +
            "         INNER JOIN STATION S2 on S2.ID = R.END_STATION_ID\n" +
            "         INNER JOIN ROUTE_TYPE RT on RT.ID = R.ROUTE_TYPE_ID\n" +
            "         INNER JOIN RAILWAY.DIRECTION D on D.ID = R.DIRECTION_ID\n" +
            "         INNER JOIN RAILWAY.CLASS C2 on RC.CLASS_ID = C2.ID\n" +
            "    WHERE RC.ACTIVE = 1 AND RC.ID=?";
    public static final String GET_TICKET_LIST = "SELECT T.ID            TICKET_ID,\n" +
            "       T.QR            TICKET_QR,\n" +
            "       C2.NAME         CUSTOMER_NAME,\n" +
            "       C2.SURNAME      CUSTOMER_SURNAME,\n" +
            "       S.STATION_NAME  BEGIN_STATION,\n" +
            "       S1.STATION_NAME END_STATION,\n" +
            "       P.PLACE_NAME    PLACE_NAME,\n" +
            "       R2.ROW_NAME     ROW_NAME,\n" +
            "       W.WAGON_NAME    WAGON_NAME,\n" +
            "       C.CLASS_NAME    CLASS_NAME,\n" +
            "       RC.ROUTE_PRICE  ROUTE_PRICE,\n" +
            "       T.TIME          TIME\n" +
            "FROM TICKET T\n" +
            "         INNER JOIN CUSTOMER C2 on C2.ID = T.CUSTOMER_ID\n" +
            "         INNER JOIN ROUTE_CLASS RC on T.ROUTE_CLASS_ID = RC.ID\n" +
            "         INNER JOIN ROUTE R on RC.ROUTE_ID = R.ID\n" +
            "         INNER JOIN STATION S on R.BEGIN_STATION_ID = S.ID\n" +
            "         INNER JOIN STATION S1 on R.END_STATION_ID = S1.ID\n" +
            "         INNER JOIN CLASS C on RC.CLASS_ID = C.ID\n" +
            "         INNER JOIN PLACE P ON T.PLACE_ID = P.ID\n" +
            "         INNER JOIN \"ROW\" R2 ON P.ROW_ID = R2.ID\n" +
            "         INNER JOIN WAGON W ON R2.WAGON_ID = W.ID\n" +
            "WHERE T.ACTIVE = 1";
    public static final String GET_TICKET_BY_ID = "SELECT T.ID            TICKET_ID,\n" +
            "       T.QR            TICKET_QR,\n" +
            "       C2.NAME         CUSTOMER_NAME,\n" +
            "       C2.SURNAME      CUSTOMER_SURNAME,\n" +
            "       S.STATION_NAME  BEGIN_STATION,\n" +
            "       S1.STATION_NAME END_STATION,\n" +
            "       P.PLACE_NAME    PLACE_NAME,\n" +
            "       R2.ROW_NAME     ROW_NAME,\n" +
            "       W.WAGON_NAME    WAGON_NAME,\n" +
            "       C.CLASS_NAME    CLASS_NAME,\n" +
            "       RC.ROUTE_PRICE  ROUTE_PRICE,\n" +
            "       T.TIME          TIME\n" +
            "FROM TICKET T\n" +
            "         INNER JOIN CUSTOMER C2 on C2.ID = T.CUSTOMER_ID\n" +
            "         INNER JOIN ROUTE_CLASS RC on T.ROUTE_CLASS_ID = RC.ID\n" +
            "         INNER JOIN ROUTE R on RC.ROUTE_ID = R.ID\n" +
            "         INNER JOIN STATION S on R.BEGIN_STATION_ID = S.ID\n" +
            "         INNER JOIN STATION S1 on R.END_STATION_ID = S1.ID\n" +
            "         INNER JOIN CLASS C on RC.CLASS_ID = C.ID\n" +
            "         INNER JOIN PLACE P ON T.PLACE_ID = P.ID\n" +
            "         INNER JOIN \"ROW\" R2 ON P.ROW_ID = R2.ID\n" +
            "         INNER JOIN WAGON W ON R2.WAGON_ID = W.ID\n" +
            "WHERE T.ACTIVE = 1 AND T.ID = ?";
    public static final String GET_PAYMENT_LIST = "SELECT P.ID            PAYMENT_ID,\n" +
            "       C2.NAME         CUSTOMER_NAME,\n" +
            "       C2.SURNAME      CUSTOMER_SURNAME,\n" +
            "       S.STATION_NAME  BEGIN_STATION,\n" +
            "       S1.STATION_NAME END_STATION,\n" +
            "       P2.PLACE_NAME   PLACE_NAME,\n" +
            "       R2.ROW_NAME     ROW_NAME,\n" +
            "       W.WAGON_NAME    WAGON_NAME,\n" +
            "       C.CLASS_NAME    CLASS_NAME,\n" +
            "       RC.ROUTE_PRICE  ROUTE_PRICE,\n" +
            "       P.TICKET_COUNT  TICKET_COUNT,\n" +
            "       P.AMOUNT        AMOUNT,\n" +
            "       P.PAY_DATE      PAY_DATE\n" +
            "FROM PAYMENT P\n" +
            "         INNER JOIN RAILWAY.TICKET T on T.ID = P.TICKET_ID\n" +
            "         INNER JOIN CUSTOMER C2 on C2.ID = T.CUSTOMER_ID\n" +
            "         INNER JOIN ROUTE_CLASS RC on T.ROUTE_CLASS_ID = RC.ID\n" +
            "         INNER JOIN ROUTE R on RC.ROUTE_ID = R.ID\n" +
            "         INNER JOIN STATION S on R.BEGIN_STATION_ID = S.ID\n" +
            "         INNER JOIN STATION S1 on R.END_STATION_ID = S1.ID\n" +
            "         INNER JOIN CLASS C on RC.CLASS_ID = C.ID\n" +
            "         INNER JOIN PLACE P2 ON T.PLACE_ID = P2.ID\n" +
            "         INNER JOIN \"ROW\" R2 ON P2.ROW_ID = R2.ID\n" +
            "         INNER JOIN WAGON W ON R2.WAGON_ID = W.ID\n" +
            "WHERE T.ACTIVE = 1";
}
