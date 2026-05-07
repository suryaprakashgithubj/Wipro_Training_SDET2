package FilesPackage;

import java.sql.*;
import java.util.Scanner;

public class AddMarks {

    public static void addMarks() 
    {

        try 
        {
            Scanner sc = new Scanner(System.in);

            System.out.print("Roll No: ");
            int rollno = sc.nextInt();

            Connection con =
            DBConnection.getConnection();

            Statement stmt =
            con.createStatement();
            
            String checkSql =
            "select * from Marks where rollno=" + rollno;

            ResultSet rs =
            stmt.executeQuery(checkSql);

            if(rs.next()) 
            {
                System.out.println(
                "Marks already added for this student");
            }
            else 
            {

                System.out.print("Tamil: ");
                int tamil = sc.nextInt();

                System.out.print("English: ");
                int english = sc.nextInt();

                System.out.print("Maths: ");
                int maths = sc.nextInt();

                System.out.print("Science: ");
                int science = sc.nextInt();

                System.out.print("Social: ");
                int social = sc.nextInt();

                String sql =
                "insert into Marks values(" +

                rollno + "," +

                tamil + "," +

                english + "," +

                maths + "," +

                science + "," +

                social + ")";

                int rows =
                stmt.executeUpdate(sql);

                System.out.println(
                rows + " marks inserted");
            }

            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
    }
}