package FilesPackage;

import java.sql.*;
import java.util.Scanner;

public class DeleteStudent 
{

    public static void deleteStudent() 
    {

        try {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Roll No to Delete: ");

            int rollno = sc.nextInt();

            Connection con =
            DBConnection.getConnection();

            Statement stmt =
            con.createStatement();
            String marksSql =
            "delete from Marks where rollno=" + rollno;

            stmt.executeUpdate(marksSql);

            String studentSql =
            "delete from Students where rollno=" + rollno;

            int rows =
            stmt.executeUpdate(studentSql);

            if(rows > 0) {

                System.out.println(
                "Student deleted successfully");
            }
            else {

                System.out.println(
                "Student not found");
            }

            stmt.close();
            con.close();
        }
        catch(Exception e) {

            System.out.println(e);
        }
    }
}