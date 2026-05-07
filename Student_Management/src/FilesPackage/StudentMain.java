package FilesPackage;

import java.sql.*;
import java.util.Scanner;

public class StudentMain 
{

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        try 
        {

            Connection con = DBConnection.getConnection();

            Statement stmt = con.createStatement();

            String loginSql =
            "select * from Login where username='" +
            username + "' and password='" +
            password + "'";

            ResultSet rs = stmt.executeQuery(loginSql);

            if(rs.next()) 
            {

                System.out.println("Login Successful");

                int choice;

                do 
                {

                    System.out.println("\nSTUDENT MENU");
                    System.out.println("1. Add Student");
                    System.out.println("2. View Students");
                    System.out.println("3. Add Marks");
                    System.out.println("4. Update Marks");
                    System.out.println("5. View Marks");
                    System.out.println("6. Delete Student");
                    System.out.println("7. Exit");

                    System.out.print("Enter Choice: ");

                    choice = sc.nextInt();

                    switch(choice) 
                    {

                        case 1:
                            AddStudent.addStudent();
                            break;

                        case 2:
                            ViewStudents.viewStudents();
                            break;

                        case 3:
                            AddMarks.addMarks();
                            break;

                        case 4:
                            UpdateMarks.updateMarks();
                            break;

                        case 5:
                            ViewMarks.viewMarks();
                            break;

                        case 6:
                            DeleteStudent.deleteStudent();
                            break;

                        case 7:
                            System.out.println("Thank You");
                            break;

                        default:
                            System.out.println("Invalid Choice");
                    }

                }while(choice != 7);
            }
            else 
            {

                System.out.println(
                "Invalid Username or Password");
            }

            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e) 
        {

            System.out.println(e);
        }

        sc.close();
    }
}