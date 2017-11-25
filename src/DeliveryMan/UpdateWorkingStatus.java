
package DeliveryMan;

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

public class UpdateWorkingStatus{

    

    public UpdateWorkingStatus() {
        
    }

    
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
    
    
   public static void main(String args[]){
                    List<DeliveryMan> deliveryManList = initializeList("deliveryMan.dat");
                    String strDm;
                    Scanner scanner = new Scanner(System.in);

                    int selection = 0;
                    do{
                            System.out.println("Update Delivery Man Working Status");
                            System.out.println("=======================");        
                            strDm = "Name: " + deliveryManList.get(0).getName() + "\n" + "Contact No: " +deliveryManList.get(0).getContactNumber() 
                             + "\n" + "Working Status: " + deliveryManList.get(0).getWorkingStatus();
                            System.out.println(strDm);
                            System.out.println("======================="); 
                            System.out.println("1. Available");
                            System.out.println("2. Break");
                            System.out.println("3. Delivering");
                            System.out.println("4. Offline");
                            System.out.println("Enter selection (-1 to exit): ");

                            try{
                                selection = scanner.nextInt();
                                if ((selection <1 || selection >4) && selection != -1){
                                    System.out.println("\nInvalid Option!!! Please choose an option from the list~");
                                }
                                else if(selection == 1){
                                        deliveryManList.get(0).setWorkingStatus("Available");
                                        updateList(deliveryManList, "deliveryMan.dat");
                                        System.out.println("Working status has been updated to Available");
                                }else if(selection == 2){
                                        deliveryManList.get(0).setWorkingStatus("Break");
                                        updateList(deliveryManList, "deliveryMan.dat");
                                        System.out.println("Working status has been updated to Break");
                                }else if(selection == 3){
                                        deliveryManList.get(0).setWorkingStatus("Delivering");
                                        updateList(deliveryManList, "deliveryMan.dat");
                                        System.out.println("Working status has been updated to Delivering");
                                }else if(selection == 4){
                                        deliveryManList.get(0).setWorkingStatus("Offline");
                                        updateList(deliveryManList, "deliveryMan.dat");
                                        System.out.println("Working status has been updated to Offline");
                                }else if(selection == -1)
                                    System.exit(0);
                            }catch(Exception e){
                                System.out.println("Invalid Option!!");
                            }
                    }while((selection <1 || selection >4) && selection != -1);

   }
       
   }
   

    

