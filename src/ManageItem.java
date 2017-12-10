import ADTs.LinkedList;
import ADTs.ListInterface;
import Classes.Affiliate;
import Classes.MenuItem;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import java.util.Scanner;

public class ManageItem {

    public static ListInterface<Affiliate> getAffiliateList() {
        ListInterface<Affiliate> affiliate = new LinkedList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("Affiliate.dat"));
            affiliate = (ListInterface) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }

        return affiliate;
    }

    public static boolean updateAffiliateDat(ListInterface<Affiliate> A) {
        boolean successful = false;
        try {

            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("Affiliate.dat"));
            ooStream.writeObject(A);
            ooStream.close();
            successful = true;
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot save to file");

        }
        return successful;
    }

    public static boolean printItem(int index, String menu) {
        ListInterface<Affiliate> affiliateList = getAffiliateList();
        boolean empty = true;
        if (menu.equals("food")) {
            if (affiliateList.getEntry(index).getFood().isEmpty()) {
                System.out.println("No item in this menu.");

            } else {
                 printdoubleline();
                 System.out.println("Food Menu");
                String output = "================================================================================================\n";
                for (int i = 1; i <= affiliateList.getEntry(index).getFood().getNumberOfEntries(); ++i) {
                    output += (i) + ". " + affiliateList.getEntry(index).getFood().getEntry(i) + "\n";
                }
                System.out.println(output);
              
                empty = false;
            }

        } else if (menu.equals("beverage")) {
            if (affiliateList.getEntry(index).getBeverage().isEmpty()) {
                System.out.println("No item in this menu.");

            } else {
                 printdoubleline();
                 System.out.println("Beverage Menu");
                String output = "================================================================================================\n";
                for (int i = 1; i <= affiliateList.getEntry(index).getBeverage().getNumberOfEntries(); ++i) {
                    output += (i) + ". " + affiliateList.getEntry(index).getBeverage().getEntry(i) + "\n";
                }
                System.out.println(output);
               
                empty = false;
            }

        }
        return empty;
    }

    public static int deleteMenuitem(int index, String menu) {
        ListInterface<Affiliate> affiliateList = getAffiliateList();
        Scanner scanner = new Scanner(System.in);

        if (printItem(index, menu) == false) {
            boolean valid = false;
            do {
                System.out.print("Enter the index of item that you want to delete (-1 to back):");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (menu.equals("food")) {
                    if (choice> affiliateList.getEntry(index).getFood().getNumberOfEntries() || choice == 0 || choice < -1) {
                        System.out.println("The number entered does not exist.");
                        valid = false;
                    } else if (choice == -1) {
                        valid = true;
                    } else {
                        char answer;
                        System.out.print("Are you confirm to delete this item?(Y=Yes):");
                        answer = scanner.nextLine().charAt(0);

                        if (Character.toUpperCase(answer) == 'Y') {
                            affiliateList.getEntry(index).getFood().remove(choice);
                            if (updateAffiliateDat(affiliateList)) {
                                printItem(index, menu);
                                System.out.println("Menu has been updated.");
                            } else {
                                System.out.println("Menu update failed.");
                            }
                        }else{
                            System.out.println("You had reject to delete it.");
                        }
                        valid = true;
                    }
                } else {
                    if (choice> affiliateList.getEntry(index).getBeverage().getNumberOfEntries() || choice == 0 || choice < -1) {
                        System.out.println("The number entered does not exist.");
                        valid = false;
                    } else if (choice == -1) {
                        valid = true;
                    } else {
                        char answer;
                        System.out.print("Are you confirm to delete this item?(Y=Yes):");
                        answer = scanner.nextLine().charAt(0);

                        if (Character.toUpperCase(answer) == 'Y') {
                            affiliateList.getEntry(index).getBeverage().remove(choice);
                            if (updateAffiliateDat(affiliateList)) {
                                printItem(index, menu);
                                System.out.println("Menu has been updated.");
                            } else {
                                System.out.println("Menu update failed.");
                            }
                        }else{
                            System.out.println("You had reject to delete it.");
                        }
                        valid = true;
                    }

                }
            } while (valid == false);
        }
        return -1;
    }
    public static int FoodorBeverage(){
        Scanner scanner=new Scanner(System.in);
        int choice;
        printdoubleline();
        System.out.println("Menu List");
        System.out.println("=========================================================================================");
                                System.out.println("1.Food");
                                System.out.println("2.Beverage");
                                System.out.print("which menu's item you want to modify? (-1 to back):");
                                choice= scanner.nextInt();
        return choice;
    }
    
    public static int changeItemStatus(int index,String menu){
         ListInterface<Affiliate> affiliateList = getAffiliateList();       
        Scanner scanner = new Scanner(System.in);
     if (printItem(index, menu) == false) {
            boolean valid = false;
            do {
                System.out.print("Enter the index of item that you want to change status (-1 to back):");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (menu.equals("food")) {
                    if (choice > affiliateList.getEntry(index).getFood().getNumberOfEntries() || choice == 0 || choice < -1) {
                        System.out.println("The number entered does not exist.");
                        valid = false;
                    } else if (choice == -1) {
                        valid = true;
                    } else {
                        char answer;
                        System.out.print("Are you confirm to change the status?(Y=Yes):");
                        answer = scanner.nextLine().charAt(0);

                        if (Character.toUpperCase(answer) == 'Y') {                           
                            if(affiliateList.getEntry(index).getFood().getEntry(choice).getStatus().equals("Available")){
                                affiliateList.getEntry(index).getFood().getEntry(choice).setStatus("Not Available");
                            }else{
                            affiliateList.getEntry(index).getFood().getEntry(choice).setStatus("Available");
                            }
                           
                            if (updateAffiliateDat(affiliateList)) {
                                printItem(index, menu);
                                System.out.println("Item's status has been updated.");
                            } else {
                                System.out.println("Item's status update failed.");
                            }
                        }else{
                            System.out.println("You had reject to change it.");
                        }
                        valid = true;
                    }
                } else {
                    if (choice  > affiliateList.getEntry(index).getBeverage().getNumberOfEntries() || choice == 0 || choice < -1) {
                        System.out.println("The number entered does not exist.");
                        valid = false;
                    } else if (choice == -1) {
                        valid = true;
                    } else {
                        char answer;
                        System.out.print("Are you confirm to change the status?(Y=Yes):");
                        answer = scanner.nextLine().charAt(0);

                        if (Character.toUpperCase(answer) == 'Y') {
                             if(affiliateList.getEntry(index).getBeverage().getEntry(choice).getStatus().equals("Available")){
                                affiliateList.getEntry(index).getBeverage().getEntry(choice).setStatus("Not Available");
                            }else{
                            affiliateList.getEntry(index).getBeverage().getEntry(choice).setStatus("Available");
                            }
                            
                            if (updateAffiliateDat(affiliateList)) {
                                printItem(index, menu);
                                System.out.println("Item's status has been updated.");
                            } else {
                                System.out.println("Item's status update failed.");
                            }
                        }else{
                            System.out.println("You had reject to change it.");
                        }
                        valid = true;
                    }

                }
            } while (valid == false);
        }       
        return -1;
    }

    public static void printdoubleline(){
        System.out.println("\n");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] valid = new boolean[3];
        int[] choice = new int[4];
        ListInterface<Affiliate> affiliateList = getAffiliateList();
        do {
            printdoubleline();
            System.out.println("********************************************************************************************");
            String output = "";
            for (int a = 1; a <= affiliateList.getNumberOfEntries(); ++a) {
                output += (a) + ". " + affiliateList.getEntry(a).toString() + "\n";
            }
            System.out.println(output);
            System.out.print("Choose an affiliate act as login (-1 to exit):");
            choice[0] = scanner.nextInt();
            scanner.nextLine();
            if (choice[0] > affiliateList.getNumberOfEntries()) {
                System.out.println("The number entered does not exist.");
                valid[0] = false;
            } else if (choice[0] == -1) {
                valid[0] = true;
                choice[1] = 0;
            } else {
                do {
                    printdoubleline();
                    System.out.println("Hello," + affiliateList.getEntry(choice[0]).getName());
                    System.out.println("---------------------------------------------------------------------------------------------");
                    
                    System.out.println("1.Delete item");
                    System.out.println("2.Update status");
                    System.out.print("Enter the number to use the function (-1 to back):");
                    choice[1] = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice[1]) {
                        case 1:
                            do {                               
                                choice[2] = FoodorBeverage();
                                //scanner.nextLine();
                                switch (choice[2]) {
                                    case 1:
                                        choice[3] = deleteMenuitem(choice[0] , "food");
                                        valid[2] = true;
                                        break;
                                    case 2:
                                        choice[3] = deleteMenuitem(choice[0] , "beverage");
                                        valid[2] = true;
                                        break;
                                    case -1:
                                        choice[3] = 0;
                                        valid[2] = true;
                                        break;
                                    default:
                                         System.out.println("Invalid Input");
                                        valid[2] = false;
                                        break;
                                }
                            } while (valid[2] == false || choice[3] == -1);
                            valid[1] = true;
                            break;
                        case 2:
                           do {                               
                                choice[2] = FoodorBeverage();
                              //  scanner.nextLine();
                                switch (choice[2]) {
                                    case 1:
                                       choice[3]=changeItemStatus(choice[0],"food");
                                        valid[2] = true;
                                        break;
                                    case 2:
                                       choice[3]=changeItemStatus(choice[0],"beverage");
                                        valid[2] = true;
                                        break;
                                    case -1:
                                        choice[3] = 0;
                                        valid[2] = true;
                                        break;
                                    default:
                                        System.out.println("Invalid Input");
                                        valid[2] = false;
                                        break;
                                }
                            } while (valid[2] == false || choice[3] == -1);                           
                            valid[1] = true;
                            break;
                        case -1:
                            valid[1] = true;
                            choice[2] = 0;
                            break;
                        default:
                            valid[1] = false;
                            System.out.println("please enter a valid input.");
                            break;

                    }
                } while (valid[1] == false || choice[2] == -1);

                valid[0] = true;
            }

        } while (valid[0] == false || choice[1] == -1);
        System.out.println("********************************************************************************************");
    }

}
