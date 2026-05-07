package FilesPackage;

import java.sql.*;
import java.util.Scanner;

public class UpdateMarks 
{

    public static void updateMarks() 
    {

        try {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Roll No: ");
            int rollno = sc.nextInt();

            System.out.print("Enter Tamil Mark: ");
            int tamil = sc.nextInt();

            System.out.print("Enter English Mark: ");
            int english = sc.nextInt();

            System.out.print("Enter Maths Mark: ");
            int maths = sc.nextInt();

            System.out.print("Enter Science Mark: ");
            int science = sc.nextInt();

            System.out.print("Enter Social Mark: ");
            int social = sc.nextInt();

            Connection con = DBConnection.getConnection();

            Statement stmt =con.createStatement();

            String sql = "update Marks set " +"tamil=" + tamil + "," +"english=" + english + "," +
            "maths=" + maths + "," +"science=" + science + "," +"social=" + social +" where rollno=" + rollno;

            int rows =stmt.executeUpdate(sql);

            if(rows > 0) 
            {

                System.out.println(
                "Marks Updated Successfully");
            }
            else 
            {

                System.out.println(
                "Student Not Found");
            }

            stmt.close();
            con.close();
        }
        catch(Exception e) 
        {

            System.out.println(e);
        }
    }
}