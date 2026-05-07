package FilesPackage;

import java.sql.*;

public class ViewMarks {

    public static void viewMarks() 
    {

        try 
        {

            Connection con =
            DBConnection.getConnection();

            Statement stmt =
            con.createStatement();

            ResultSet rs =
            stmt.executeQuery("select * from Marks");

            System.out.println(
            "ROLLNO\tTAMIL\tENGLISH\tMATHS\tSCIENCE\tSOCIAL");

            while(rs.next()) {

                System.out.println(

                rs.getInt("rollno") + "\t"+ rs.getInt("tamil") + "\t" +rs.getInt("english") + "\t" +rs.getInt("maths") + "\t" +
               rs.getInt("science") + "\t" +rs.getInt("social"));
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