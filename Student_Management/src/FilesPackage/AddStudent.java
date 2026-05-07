package FilesPackage;

import java.sql.*;
import java.util.Scanner;

public class AddStudent 
{

    public static void addStudent()
    {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Roll No: ");
            int rollno = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            String sql =
            "insert into Students values(" +
            rollno + ",'" + name + "'," + age + ",'" + email + "')";

            int rows = stmt.executeUpdate(sql);

            System.out.println(rows + " student inserted");

            stmt.close();
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}