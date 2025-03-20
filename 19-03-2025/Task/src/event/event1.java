package event;

import java.sql.*;
import java.util.Scanner;

public class event1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO THE EVENT MANAGEMENT SYSTEM");
        System.out.println("1. Register New User");
        System.out.println("2. Edit Existing User");
        System.out.println("3. Delete User");
        System.out.println("Enter your choice:");

        int ans = sc.nextInt();
        sc.nextLine(); 

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
            Statement st = con.createStatement();

            if (ans == 1) {
                System.out.println("Enter your register number:");
                int regno = sc.nextInt();
                sc.nextLine(); 

                System.out.println("Enter your collegename:");
                String cname = sc.nextLine();

                System.out.println("Enter your eventname:");
                String ename = sc.nextLine();

                System.out.println("Enter your partname:");
                String partname = sc.nextLine();

                System.out.println("Enter your emailid:");
                String mail = sc.nextLine();

                System.out.println("Enter your teamname (Optional, press Enter if none):");
                String teamname = sc.nextLine();
                if (teamname.isEmpty()) {
                    teamname = null;
                }

                String checkQuery = "SELECT COUNT(*) FROM users WHERE regno = " + regno;
                ResultSet rs = st.executeQuery(checkQuery);
                if (rs.next() && rs.getInt(1) > 0) {
                    System.out.println("Error: Register number already exists! Please use a different register number.");
                    return;
                }

                String query = "INSERT INTO users (regno, collegename, eventname, partname, emailid, teamname) " +
                        "VALUES ('" + regno + "', '" + cname + "', '" + ename + "', '" + partname + "', '" + mail + "', " +
                        (teamname != null ? "'" + teamname + "'" : "NULL") + ")";

                int change = st.executeUpdate(query);
                if (change > 0) {
                    System.out.println("You have successfully registered.");
                } else {
                    System.out.println("Something went wrong. Please try again.");
                }

            } else if (ans == 2) {
                System.out.println("Enter your register number:");
                int regno = sc.nextInt();
                sc.nextLine(); 

                String query1 = "SELECT * FROM users WHERE regno = " + regno;
                ResultSet rs = st.executeQuery(query1);

                if (rs.next()) {
                    System.out.println("Hello User! What would you like to update?");
                    System.out.println("1. Email");
                    System.out.println("2. Collegename");
                    System.out.println("3. Eventname");
                    System.out.println("4. Partname");
                    System.out.println("5. Teamname");
                    System.out.println("6. Exit without changes");
                    int ans1 = sc.nextInt();
                    sc.nextLine(); 

                    String updateQuery = "";
                    String newValue = "";

                    if (ans1 == 1) {
                        System.out.println("Enter your new emailid:");
                        newValue = sc.nextLine();
                        updateQuery = "UPDATE users SET emailid = '" + newValue + "' WHERE regno = " + regno;
                    } else if (ans1 == 2) {
                        System.out.println("Enter your new collegename:");
                        newValue = sc.nextLine();
                        updateQuery = "UPDATE users SET collegename = '" + newValue + "' WHERE regno = " + regno;
                    } else if (ans1 == 3) {
                        System.out.println("Enter your new eventname:");
                        newValue = sc.nextLine();
                        updateQuery = "UPDATE users SET eventname = '" + newValue + "' WHERE regno = " + regno;
                    } else if (ans1 == 4) {
                        System.out.println("Enter your new partname:");
                        newValue = sc.nextLine();
                        updateQuery = "UPDATE users SET partname = '" + newValue + "' WHERE regno = " + regno;
                    } else if (ans1 == 5) {
                        System.out.println("Enter your new teamname (Optional, press Enter if none):");
                        newValue = sc.nextLine();
                        if (newValue.isEmpty()) {
                            newValue = null;
                        }
                        updateQuery = "UPDATE users SET teamname = " + (newValue != null ? "'" + newValue + "'" : "NULL") +
                                " WHERE regno = " + regno;
                    } else {
                        System.out.println("No changes were made.");
                        return;
                    }

                    int change1 = st.executeUpdate(updateQuery);
                    if (change1 > 0) {
                        System.out.println("Updated successfully.");
                    } else {
                        System.out.println("Error while updating. Please try again.");
                    }

                } else {
                    System.out.println("User not found! Please register first.");
                }

            } else if (ans == 3) {
                System.out.println("Enter your register number:");
                int regno = sc.nextInt();
                sc.nextLine(); 
                String query7 = "SELECT * FROM users WHERE regno = " + regno;
                ResultSet rs3 = st.executeQuery(query7);

                if (rs3.next()) {
                    String query8 = "DELETE FROM users WHERE regno = " + regno;
                    int change6 = st.executeUpdate(query8);
                    if (change6 > 0) {
                        System.out.println("The user has been successfully deleted.");
                    } else {
                        System.out.println("Error occurred while deleting the user.");
                    }
                } else {
                    System.out.println("User not found! Cannot delete.");
                }
            } else {
                System.out.println("Invalid choice! Please try again.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


