
package ClockInAndClockOff;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClockInAndOff extends javax.swing.JFrame {
    private Calendar clockIn, clockOff;
   
    public ClockInAndOff() {
        initComponents();
        jtfName.setText("Tan Qi Han");
        jtfID.setText("12345");
        
        this.clockIn = new GregorianCalendar();
        jbtnClockOff.setEnabled(false);
    }
    
    public void setClockOffTime(){
        this.clockOff = clockOff;
    }
    
    public static String getClockTime(Calendar time) {
         return String.format("%02d:%02d:%02d", time.get(Calendar.HOUR_OF_DAY),
         time.get(Calendar.MINUTE), time.get(Calendar.SECOND));
  }
    
    public long getHour() throws ParseException{
        String startTime = jtfClockIn.getText();
        String endTime = jtfClockOff.getText();
        
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date startDate = format.parse(startTime);
        Date endDate = format.parse(endTime);
        return (((endDate.getTime()-startDate.getTime()) /(60*60*1000)) % 24);
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbtnClockIn = new javax.swing.JButton();
        jbtnClockOff = new javax.swing.JButton();
        jtfID = new javax.swing.JTextField();
        jtfName = new javax.swing.JTextField();
        jtfClockIn = new javax.swing.JTextField();
        jtfClockOff = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfDailyWorkingHour = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clock In & Clock Off System");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Clock In & Clock Off System");

        jLabel2.setText("ID :");

        jLabel3.setText("Name :");

        jLabel4.setText("Clock In Time :");

        jLabel5.setText("Clock Off Time :");

        jbtnClockIn.setText("Clock In");
        jbtnClockIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClockInActionPerformed(evt);
            }
        });

        jbtnClockOff.setText("Clock Off");
        jbtnClockOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClockOffActionPerformed(evt);
            }
        });

        jtfID.setEditable(false);

        jtfName.setEditable(false);

        jtfClockIn.setEditable(false);

        jtfClockOff.setEditable(false);

        jLabel6.setText("Daily Working Hour :");

        jtfDailyWorkingHour.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfName)
                                    .addComponent(jtfClockIn)
                                    .addComponent(jtfClockOff)
                                    .addComponent(jtfDailyWorkingHour)
                                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jbtnClockIn)
                        .addGap(42, 42, 42)
                        .addComponent(jbtnClockOff)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfClockIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfClockOff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfDailyWorkingHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnClockIn)
                    .addComponent(jbtnClockOff))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnClockInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClockInActionPerformed
        String clockInTime = getClockTime(clockIn);
        jtfClockIn.setText(clockInTime);
        
         if(jtfClockIn.getText().isEmpty()){
            jbtnClockOff.setEnabled(false);
            
        }else if(!jtfClockIn.getText().isEmpty()){
            jbtnClockOff.setEnabled(true);
            jbtnClockIn.setEnabled(false);
        }
    }//GEN-LAST:event_jbtnClockInActionPerformed

    private void jbtnClockOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClockOffActionPerformed
        try {
            jtfClockOff.setText(getClockTime(new GregorianCalendar()));
            
            if(jtfClockIn.getText().isEmpty()){
                jbtnClockOff.setEnabled(false);
                
            }else if(!jtfClockIn.getText().isEmpty()){
                jbtnClockOff.setEnabled(true);
                jbtnClockIn.setEnabled(false);
            }
            
            jtfDailyWorkingHour.setText(Long.toString(getHour()));
        } catch (ParseException ex) {
            Logger.getLogger(ClockInAndOff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnClockOffActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClockInAndOff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClockInAndOff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClockInAndOff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClockInAndOff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClockInAndOff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbtnClockIn;
    private javax.swing.JButton jbtnClockOff;
    private javax.swing.JTextField jtfClockIn;
    private javax.swing.JTextField jtfClockOff;
    private javax.swing.JTextField jtfDailyWorkingHour;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfName;
    // End of variables declaration//GEN-END:variables
}