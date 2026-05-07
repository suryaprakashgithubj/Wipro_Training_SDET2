package FilesPackage;

import java.sql.*;

public class ViewStudents 
{

    public static void viewStudents() 
    {

        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Students");

            System.out.println("ROLLNO\tNAME\tAGE\tEMAIL");

            while(rs.next()) {
                System.out.println(
                    rs.getInt("rollno") + "\t" +rs.getString("name") + "\t" +
                    rs.getInt("age") + "\t" +rs.getString("email")
                );
            }

            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}