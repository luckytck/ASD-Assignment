
import DeliveryMan.DeliveryMan;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Program {

    private static <T> List<T> initializeList(String fileName) { //Return a List from .dat file
        List<T> list = new ArrayList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(fileName));
            list = (ArrayList) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
//            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot read from file");
//            JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
//            JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    private static <T> void updateList(List<T> list, String fileName) { //Store a List into .dat file
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(fileName));
            ooStream.writeObject(list);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
//            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            System.out.println("Cannot save to file");
//            JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
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
            System.out.println("4. Customer    : Place Order");
            System.out.println("5. HR Executive: Update Delivery Man Status");
            System.out.print("Please choose your option (-1 to exit): ");
            try {
                option[0] = scanner.nextInt();
                scanner.nextLine();
                if (option[0] != 1 && option[0] != 2 && option[0] != 3 && option[0] != 4 && option[0] != 5 && option[0] != -1) {
                    System.out.println("Invalid Option!!! Please try again~");
                    loop[0] = true;
                } else if (option[0] == -1) {
                    System.out.println("Thank you for using this system~");
                    System.exit(0);
                } else if (option[0] == 1) { //Tan Cheong Kiat - HR Executive: Update Delivery Man Information
                    List<DeliveryMan> deliveryManList = initializeList("deliveryMan.dat");
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
                        if (count == 0) {
                            System.out.println("No delivery man found in database.");
                        } else {
                            System.out.print("Please choose the delivery man you want to update (-1 to exit): ");
                            try {
                                option[1] = scanner.nextInt();
                                scanner.nextLine();
                                if ((option[1] <= 0 || option[1] > count) && option[1] != -1) {
                                    System.out.println("Invalid Option!!! Please choose an option from the list~");
                                    loop[1] = true;
                                } else if (option[1] == -1) {
                                    System.out.println("Thank you for using this system~");
                                    System.exit(0);
                                } else {
                                    String name, contactNumber, email, homeAddress, identityCardNo;
                                    char gender;
                                    double basicSalary = 0;
                                    System.out.println("Please enter the new details: ");
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
                                    while (basicSalary <= 0) {
                                        System.out.print("Basic Salary (RM): ");
                                        while (!scanner.hasNextDouble()) {
                                            System.out.println("Invalid Value!!! Please enter numeric value only~");
                                            System.out.print("Basic Salary (RM): ");
                                            scanner.next();
                                        }
                                        basicSalary = scanner.nextDouble();
                                        if (basicSalary <= 0) {
                                            System.out.println("Basic Salary must greater than 0!!! Please try again~");
                                        }
                                    }
                                    System.out.print("Confirm to update this delivery man? (Y/N): ");
                                    char confirmation = scanner.next().toUpperCase().charAt(0);
                                    if (confirmation == 'Y') {
                                        DeliveryMan deliveryMan = new DeliveryMan(name, String.valueOf(gender), contactNumber, email, homeAddress, identityCardNo, basicSalary);
                                        deliveryManList.get(option[1] - 1).setName(name);
                                        deliveryManList.get(option[1] - 1).setGender(String.valueOf(gender));
                                        deliveryManList.get(option[1] - 1).setContactNumber(contactNumber);
                                        deliveryManList.get(option[1] - 1).setEmail(email);
                                        deliveryManList.get(option[1] - 1).setHomeAddress(homeAddress);
                                        deliveryManList.get(option[1] - 1).setIdentityCardNo(identityCardNo);
                                        deliveryManList.get(option[1] - 1).setBasicSalary(basicSalary);
                                        updateList(deliveryManList, "deliveryMan.dat");
                                        System.out.println("Updated Successfully!!!");
                                    } else {
                                        System.out.println("Update Cancelled.");
                                    }
                                    System.out.print("Do you want to update another delivery man information? (Y/N): ");
                                    char continueUpdate = scanner.next().toUpperCase().charAt(0);
                                    if (continueUpdate == 'Y') {
                                        loop[1] = true;
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid Option!!! Please enter numeric value only~");
                                scanner.nextLine();
                                loop[1] = true;
                            }
                        }
                    } while (loop[1]);
                } else if (option[0] == 2) { //Wong Li Yi - Delivery Man: Update Delivery Man Working Status

                } else if (option[0] == 3) { //Tan Qi Han - Affiliate: Add Menu

                } else if (option[0] == 4) { //Wo Shiou Chein - Customer: Place Order

                } else if (option[0] == 5) { //Tan Cheong Kiat - HR Executive: Update Delivery Man Status
                    List<DeliveryMan> deliveryManList = initializeList("deliveryMan.dat");
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
                        if (count == 0) {
                            System.out.println("No delivery man found in database.");
                        } else {
                            System.out.print("Please choose the delivery man to update status (-1 to exit): ");
                            try {
                                option[1] = scanner.nextInt();
                                scanner.nextLine();
                                if ((option[1] <= 0 || option[1] > count) && option[1] != -1) {
                                    System.out.println("Invalid Option!!! Please choose an option from the list~");
                                    loop[1] = true;
                                } else if (option[1] == -1) {
                                    System.out.println("Thank you for using this system.");
                                    System.exit(0);
                                } else {
                                    do {
                                        loop[2] = false;
                                        System.out.println("S t a t u s   L i s t");
                                        System.out.println("=====================");
                                        System.out.println("1. Resigned");
                                        System.out.println("2. Retired");
                                        System.out.println("3. Other");
                                        System.out.print("Please choose a status you want to update to this delivery man (-1 to cancel): ");
                                        try {
                                            option[2] = scanner.nextInt();
                                            scanner.nextLine();
                                            if (option[2] != 1 && option[2] != 2 && option[2] != 3 && option[2] != -1) {
                                                System.out.println("Invalid Option!!! Please choose an option from the list~");
                                                loop[2] = true;
                                            } else if (option[2] == -1) {
                                                System.out.println("Update Cancelled.");
                                                System.out.println("Thank you for using this system.");
                                                System.exit(0);
                                            } else {
                                                String status;
                                                switch (option[2]) {
                                                    case 1:
                                                        status = "Resigned";
                                                        break;
                                                    case 2:
                                                        status = "Retired";
                                                        break;
                                                    default:
                                                        System.out.print("Please enter the new status: ");
                                                        status = scanner.nextLine();
                                                }
                                                deliveryManList.get(option[1] - 1).setStatus(status);
                                                updateList(deliveryManList, "deliveryMan.dat");
                                                System.out.println("Status Updated!!!");
                                                System.out.print("Do you want to update another delivery man status? (Y/N): ");
                                                char continueUpdate = scanner.next().toUpperCase().charAt(0);
                                                if (continueUpdate == 'Y') {
                                                    loop[1] = true;
                                                }
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Invalid Option!!! Please enter numeric value only~");
                                            scanner.nextLine();
                                            loop[2] = true;
                                        }

                                    } while (loop[2]);
                                }

                            } catch (Exception e) {
                                System.out.println("Invalid Option!!! Please enter numeric value only~");
                                scanner.nextLine();
                                loop[1] = true;
                            }
                        }
                    } while (loop[1]);

                }
            } catch (Exception e) {
                System.out.println("Invalid Option!!! Please enter numeric value only~");
                scanner.nextLine();
                loop[0] = true;
            }
        } while (loop[0]);

    }

}
