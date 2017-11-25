package Affiliate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Registration extends javax.swing.JFrame {

    private List<Affiliate> affiliatelist = new ArrayList<>();
    private Pattern pattern;
    private Matcher matcher;

    public Registration() {
        initComponents();
        jtfAffiliateNo.setText("" + Affiliate.getnextnumber());
        jtfAffiliateNo.grabFocus();

    }

    private boolean phonevalidator(String ContactNo) {
        boolean valid = true;
pattern=Pattern.compile("\\d{2,3}-\\d{7,8}");
        matcher = pattern.matcher(ContactNo);

        if (matcher.matches()== false) {
                
            valid=false;
            JOptionPane.showMessageDialog(null, "Invalid contact number.\nExample:\n03-12341234\n012-1234567\n011-12345678");
        }

        return valid;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblTitle = new javax.swing.JLabel();
        jlblRestaurant_Name = new javax.swing.JLabel();
        jtfAffiliateNo = new javax.swing.JTextField();
        jlblAffiliateNo = new javax.swing.JLabel();
        jtfRestaurant_Name = new javax.swing.JTextField();
        jlblOwner_Name = new javax.swing.JLabel();
        jtfOwner_Name = new javax.swing.JTextField();
        jlblOwner_ContactNo = new javax.swing.JLabel();
        jtfOwner_ContactNo = new javax.swing.JTextField();
        jlblRestaurant_ContactNo = new javax.swing.JLabel();
        jtfRestaurant_Contact = new javax.swing.JTextField();
        jlblLocation = new javax.swing.JLabel();
        jtfLocation = new javax.swing.JTextField();
        jbtnRegister = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        jlblTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jlblTitle.setText("Register as an Affiliate");

        jlblRestaurant_Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblRestaurant_Name.setText("Restaurant Name :");

        jtfAffiliateNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfAffiliateNo.setEnabled(false);

        jlblAffiliateNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblAffiliateNo.setText("Affiliate No. :");

        jtfRestaurant_Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jlblOwner_Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblOwner_Name.setText("Owner's Name :");

        jtfOwner_Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jlblOwner_ContactNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblOwner_ContactNo.setText("Onwer's Contact :");

        jtfOwner_ContactNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jlblRestaurant_ContactNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblRestaurant_ContactNo.setText("Restaurant's Contact :");

        jtfRestaurant_Contact.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jlblLocation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblLocation.setText("Location :");

        jtfLocation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jbtnRegister.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtnRegister.setText("Register");
        jbtnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRegisterActionPerformed(evt);
            }
        });

        jbtnCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtnCancel.setText("Cancel");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jlblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlblRestaurant_Name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jlblRestaurant_ContactNo)
                                        .addComponent(jlblOwner_ContactNo)
                                        .addComponent(jlblLocation))
                                    .addGap(13, 13, 13)))
                            .addComponent(jlblOwner_Name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblAffiliateNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfAffiliateNo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfRestaurant_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfOwner_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfOwner_ContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfRestaurant_Contact, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtnCancel)
                .addGap(93, 93, 93)
                .addComponent(jbtnRegister)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblTitle)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblAffiliateNo)
                    .addComponent(jtfAffiliateNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfRestaurant_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblRestaurant_Name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblOwner_Name)
                    .addComponent(jtfOwner_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblOwner_ContactNo)
                    .addComponent(jtfOwner_ContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblRestaurant_ContactNo)
                    .addComponent(jtfRestaurant_Contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblLocation)
                    .addComponent(jtfLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnRegister)
                    .addComponent(jbtnCancel))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jlblRestaurant_Name.getAccessibleContext().setAccessibleName("");
        jlblRestaurant_Name.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegisterActionPerformed
        String Restaurant_Name = jtfRestaurant_Name.getText();
        String Owner_Name = jtfOwner_Name.getText();
        String Owner_ContactNo = jtfOwner_ContactNo.getText();
        String Restaurant_ContactNo = jtfRestaurant_Contact.getText();
        String Location = jtfLocation.getText();
        String output = "";
        if (Restaurant_Name.equals("") || Owner_Name.equals("") || Owner_ContactNo.equals("") || Restaurant_ContactNo.equals("") || Location.equals("")) {
            JOptionPane.showMessageDialog(null, "Cannot have empty text field.");
        } else {

            if(phonevalidator(Restaurant_ContactNo)&&phonevalidator(Owner_ContactNo)){
                int option = JOptionPane.showConfirmDialog(null, "Are you sure to register as an Affiliate?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                Affiliate affiliate = new Affiliate(Restaurant_Name, Owner_Name, Restaurant_ContactNo, Location, Owner_ContactNo);
                affiliatelist.add(affiliate);

                jtfAffiliateNo.setText("" + Affiliate.getnextnumber());
                jtfRestaurant_Name.setText("");
                jtfOwner_Name.setText("");
                jtfOwner_ContactNo.setText("");
                jtfRestaurant_Contact.setText("");
                jtfLocation.setText("");
                jtfRestaurant_Name.grabFocus();
                JOptionPane.showMessageDialog(null, "Your Are an Affiliate of Fastest Deliveryman now.");

                for (int i = 0; i < affiliatelist.size(); ++i) {
                    output += String.format("%d", i + 1) + affiliatelist.get(i).tostring();

                }
                System.out.println(output);                
         try {
      ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("Affiliate.dat"));
      ooStream.writeObject(affiliatelist);
      //ooStream.close();
      ooStream.close();
    } catch (FileNotFoundException ex) {
        System.out.println("File not found");
    } catch (IOException ex) {
        System.out.println("Cannot save to file");
      
    }       
            }
           

            }

        }

    }//GEN-LAST:event_jbtnRegisterActionPerformed

    private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
       
            this.dispose();
      


    }//GEN-LAST:event_jbtnCancelActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnRegister;
    private javax.swing.JLabel jlblAffiliateNo;
    private javax.swing.JLabel jlblLocation;
    private javax.swing.JLabel jlblOwner_ContactNo;
    private javax.swing.JLabel jlblOwner_Name;
    private javax.swing.JLabel jlblRestaurant_ContactNo;
    private javax.swing.JLabel jlblRestaurant_Name;
    private javax.swing.JLabel jlblTitle;
    private javax.swing.JTextField jtfAffiliateNo;
    private javax.swing.JTextField jtfLocation;
    private javax.swing.JTextField jtfOwner_ContactNo;
    private javax.swing.JTextField jtfOwner_Name;
    private javax.swing.JTextField jtfRestaurant_Contact;
    private javax.swing.JTextField jtfRestaurant_Name;
    // End of variables declaration//GEN-END:variables
}
