import java.sql.*;
public class Connection1 {
    static Connection connect1;
    Statement st;
    public Connection1(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1","root","Password@123");
            st =connect1.createStatement();
        }
        catch(Exception e){
            System.out.println("Database Error"+e);
        }
    }
}
