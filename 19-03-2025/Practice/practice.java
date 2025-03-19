package event;

import java.sql.*;
import java.util.Scanner;

public class event1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("WELCOME TO THE EVENT MANAGEMENT SYSTEM");
        System.out.println("1. Register New User");
        System.out.println("2. Edit Existing User");
        System.out.println("3. Delete User");
        System.out.println("Enter your choice:");
        int ans = s.nextInt();
        s.nextLine(); 

        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root")) {
            
            if (ans == 1) {
                
                System.out.println("Enter your register number:");
                int regno = s.nextInt();
                s.nextLine(); 

                System.out.println("Enter your collegename:");
                String cname = s.nextLine();

                System.out.println("Enter your eventname:");
                String ename = s.nextLine();

                System.out.println("Enter your partname:");
                String partname = s.nextLine();

                System.out.println("Enter your emailid:");
                String mail = s.nextLine();

                System.out.println("Enter your teamname (Optional, press Enter if none):");
                String teamname = s.nextLine();
                if (teamname.isEmpty()) {
                    teamname = null;
                }

                String checkQuery = "SELECT COUNT(*) FROM users WHERE regno = ?";
                try (PreparedStatement checkStmt = con.prepareStatement(checkQuery)) {
                    checkStmt.setInt(1, regno);
                    ResultSet rs = checkStmt.executeQuery();
                    if (rs.next() && rs.getInt(1) > 0) {
                        System.out.println("Error: Register number already exists! Please use a different register number.");
                        return;
                    }
                }

                String query = "INSERT INTO users (regno, collegename, eventname, partname, emailid, teamname) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setInt(1, regno);
                    pst.setString(2, cname);
                    pst.setString(3, ename);
                    pst.setString(4, partname);
                    pst.setString(5, mail);
                    pst.setString(6, teamname);

                    int change = pst.executeUpdate();
                    if (change > 0) {
                        System.out.println("You have successfully registered.");
                    } else {
                        System.out.println("Something went wrong. Please try again.");
                    }
                }

            } else if (ans == 2) {
             
                System.out.println("Enter your register number:");
                int regno = s.nextInt();
                s.nextLine(); 

                String query1 = "SELECT * FROM users WHERE regno = ?";
                try (PreparedStatement pst1 = con.prepareStatement(query1)) {
                    pst1.setInt(1, regno);
                    ResultSet rs = pst1.executeQuery();

                    if (rs.next()) {
                        System.out.println("Hello User! What would you like to update?");
                        System.out.println("1. Email");
                        System.out.println("2. Collegename");
                        System.out.println("3. Eventname");
                        System.out.println("4. Partname");
                        System.out.println("5. Teamname");
                        System.out.println("6. Exit without changes");
                        int ans1 = s.nextInt();
                        s.nextLine();

                        String updateQuery = "";
                        String newValue = "";
                        if (ans1 == 1) {
                            System.out.println("Enter your new emailid:");
                            newValue = s.nextLine();
                            updateQuery = "UPDATE users SET emailid = ? WHERE regno = ?";
                        } else if (ans1 == 2) {
                            System.out.println("Enter your new collegename:");
                            newValue = s.nextLine();
                            updateQuery = "UPDATE users SET collegename = ? WHERE regno = ?";
                        } else if (ans1 == 3) {
                            System.out.println("Enter your new eventname:");
                            newValue = s.nextLine();
                            updateQuery = "UPDATE users SET eventname = ? WHERE regno = ?";
                        } else if (ans1 == 4) {
                            System.out.println("Enter your new partname:");
                            newValue = s.nextLine();
                            updateQuery = "UPDATE users SET partname = ? WHERE regno = ?";
                        } else if (ans1 == 5) {
                            System.out.println("Enter your new teamname (Optional, press Enter if none):");
                            newValue = s.nextLine();
                            if (newValue.isEmpty()) {
                                newValue = null;
                            }
                            updateQuery = "UPDATE users SET teamname = ? WHERE regno = ?";
                        } else {
                            System.out.println("No changes were made.");
                            return;
                        }

                        try (PreparedStatement pst2 = con.prepareStatement(updateQuery)) {
                            pst2.setString(1, newValue);
                            pst2.setInt(2, regno);
                            int change1 = pst2.executeUpdate();
                            if (change1 > 0) {
                                System.out.println("Updated successfully.");
                            } else {
                                System.out.println("Error while updating. Please try again.");
                            }
                        }
                    } else {
                        System.out.println("User not found! Please register first.");
                    }
                }
            } else if (ans == 3) {
              
                System.out.println("Enter your register number:");
                int regno = s.nextInt();
                s.nextLine(); 

                String query7 = "SELECT * FROM users WHERE regno = ?";
                try (PreparedStatement pst3 = con.prepareStatement(query7)) {
                    pst3.setInt(1, regno);
                    ResultSet rs3 = pst3.executeQuery();

                    if (rs3.next()) {
                        String query8 = "DELETE FROM users WHERE regno = ?";
                        try (PreparedStatement pst4 = con.prepareStatement(query8)) {
                            pst4.setInt(1, regno);
                            int change6 = pst4.executeUpdate();
                            if (change6 > 0) {
                                System.out.println("The user has been successfully deleted.");
                            } else {
                                System.out.println("Error occurred while deleting the user.");
                            }
                        }
                    } else {
                        System.out.println("User not found! Cannot delete.");
                    }
                }
            } else {
                System.out.println("Invalid choice! Please try again.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


