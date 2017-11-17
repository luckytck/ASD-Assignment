
import DeliveryMan.DeliveryMan;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Program {

    private static List<DeliveryMan> deliveryManList = new ArrayList<>();

    private static void initializeList() {
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("deliveryMan.dat"));
            deliveryManList = (ArrayList) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option[] = new int[5];
        boolean loop[] = new boolean[5];
        do {
            loop[0] = false;
            System.out.println("M E N U   L I S T");
            System.out.println("=================");
            System.out.println("SPRINT 2:");
            System.out.println("1. HR Executive: Update Delivery Man Information");
            System.out.println("2. Delivery Man: Update Delivery Man Working Status");
            System.out.println("3. Affiliate   : Add Menu");
            System.out.println("4. Customer    : ");
            System.out.print("Please choose your option (-1 to exit): ");
            option[0] = scanner.nextInt();
            scanner.nextLine();
            if (option[0] != 1 && option[0] != 2 && option[0] != 3 && option[0] != 4 && option[0] != -1) {
                System.out.println("Invalid Option!!! Please try again~");
                loop[0] = true;
            } else if (option[0] == -1) {
                System.out.println("Thank you for using this system~");
                System.exit(0);
            } else if (option[0] == 1) {
                initializeList();
                int count;
                do {
                    loop[1] = false;
                    count = 0;
                    System.out.println("D e l i v e r y   M a n   L i s t");
                    System.out.println("=================================");
                    String result = String.format("%-3s %-4s  %-20s   %-6s    %-12s   %-20s   %-14s   %-12s   %-10s\n", "NO.", "ID", "NAME", "GENDER", "CONTACT NO.", "EMAIL", "IC NO.", "BASIC_SALARY", "STATUS");
                    for (int i = 0; i < deliveryManList.size(); i++) {
                        if (deliveryManList.get(i) != null) {
                            result += String.format("%-3s %s", i + 1 + ".", deliveryManList.get(i));
                            count++;
                        }
                    }
                    System.out.println(result);
                    System.out.print("Please choose the delivery man you want to update: ");
                    option[1] = scanner.nextInt();
                    scanner.nextLine();
                    if (option[1] <= 0 || option[1] > count) {
                        System.out.println("Invalid Option!!! Please try again~");
                        loop[1] = true;
                    } else {
                        String name, contactNumber, email, homeAddress, identityCardNo;
                        char gender;
                        double basicSalary;
                        do {
                            loop[2] = false;
                            System.out.println("Please enter the updated details: ");
                            System.out.print("Name: ");
                            name = scanner.nextLine().trim();
                            System.out.print("Gender (M/F): ");
                            while (!scanner.hasNext("[mfMF]{1}")) {
                                System.out.println("Invalid Gender!!! Please try again~");
                                System.out.print("Gender (M/F): ");
                                scanner.next();
                            }
                            gender = scanner.next().toUpperCase().charAt(0);
                            scanner.nextLine();
                            System.out.print("Contact No. (01#-########): ");
                            while (!scanner.hasNext("01[0-9]{1}-[0-9]{7,8}")) {
                                System.out.println("Invalid Contact No.!!! Please try again~");
                                System.out.print("Contact No. (01#-########): ");
                                scanner.nextLine();
                            }
                            contactNumber = scanner.nextLine().trim();
                            System.out.print("Email Address: ");
                            while (!scanner.hasNext("([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})")) {
                                System.out.println("Invalid Email Address!!! Please try again~");
                                System.out.print("Email Address: ");
                                scanner.nextLine();
                            }
                            email = scanner.nextLine().trim();
                            System.out.print("Home Address: ");
                            homeAddress = scanner.nextLine().trim();
                            System.out.print("Identity Card No. (######-##-####): ");
                            while (!scanner.hasNext("[0-9]{6}-[0-9]{2}-[0-9]{4}")) {
                                System.out.println("Invalid IC No.!!! Please try again~");
                                System.out.print("Identity Card No. (######-##-####): ");
                                scanner.nextLine();
                            }
                            identityCardNo = scanner.nextLine().trim();
                            System.out.print("Basic Salary (RM): ");
                            while (!scanner.hasNextDouble()) {
                                System.out.println("Invalid Value!!! Please enter numeric value only~");
                                System.out.print("Basic Salary (RM): ");
                                scanner.next();
                            }
                            basicSalary = scanner.nextDouble();
                        } while (loop[2]);
                    }
                } while (loop[1]);
            } else if (option[0] == 2) { //Wong Li Yi

            } else if (option[0] == 3) { //Tan Qi Han

            } else if (option[0] == 4) { //Wo Shiou Chein

            }

        } while (loop[0]);

    }

}
