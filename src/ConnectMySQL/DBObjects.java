package ConnectMySQL;

public class DBObjects {
    private final static ConnectMySQL schoolConnection = new ConnectMySQL("jdbc:mysql://localhost:3306/KrewBanking", "root", "root");

    public static ConnectMySQL getSchoolConnection(){
        return DBObjects.schoolConnection;
    }
}
