package ConnectMySQL;

import java.sql.*;
import java.util.ArrayList;

public class ConnectMySQL{

    private final String connString;
    private final String username;
    private final String password;

    public ConnectMySQL(String connection, String username, String password)
    {
        this.username = username;
        this.password = password;
        this.connString = connection;
    }

    public ResultSet runQuery(String query){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> Result = new ArrayList<String>();

        try{
            conn = DriverManager.getConnection(connString, username, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    public String getLastColumn(String table, String column, String orderColumn){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = DriverManager.getConnection(connString, username, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM "+ table +" ORDER BY "+ orderColumn +" DESC ");
            System.out.println(rs);

            while(rs.next()){
                //Retrieve
                String clmn = rs.getString(column);
                return clmn;
            }
            return "";

        }
        catch(Exception e){
            System.err.println(e);
            return "";
        }
        finally {
                try{
                conn.close();
                }
                catch (Exception e){
                    System.err.println(e.getMessage());
                }
        }

    }
    public void Insert(String SQLQuery)  throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = DriverManager.getConnection(connString, username, password);
            stmt = conn.prepareStatement(SQLQuery);
            stmt.execute();
            System.out.println("Query successful");
        }

        catch (SQLException e)
        {
            System.err.println(e);
        }

        finally
        {
            if (conn != null){
                conn.close();
            }
        }
    }

}

