/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frame;

import Class.Employee;
import Class.File;
import Class.Input.*;
import Class.Input;
import Class.UserAccount;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 63909
 */
public class EmployeeListPage extends javax.swing.JFrame {

    //private final UserAccount userInfo;

    /**
     * Creates new form EmployeesListPage
     * @param userInfo
     */
    
    File employeeFile = null;
    ArrayList<String[]> employeeList = null;
    DefaultTableModel employeeTableModel;
    UserAccount userInfo;  
  
    public EmployeeListPage(UserAccount userInfo) { 
        initComponents();
        
        this.userInfo = userInfo;
        
        jLabelInputError.setVisible(false);
        
        jLabelUsername.setText(this.userInfo.getUsername());
        
        jTextFieldPagIBIGID.getDocument().addDocumentListener(new ValidationListener(jTextFieldPagIBIGID, jLabelInputError, "PagIBIG ID", 12));
        jTextFieldPhilHealthID.getDocument().addDocumentListener(new ValidationListener(jTextFieldPhilHealthID, jLabelInputError, "PhilHealth ID", 12 ));
        jTextFieldSSSID.getDocument().addDocumentListener(new ValidationListener(jTextFieldSSSID, jLabelInputError, "SSS ID", 10));
        jTextFieldTINID.getDocument().addDocumentListener(new ValidationListener(jTextFieldTINID, jLabelInputError, "TIN ID", 12));     
        
        employeeList = new ArrayList<>();          
        
        employeeFile = new File();
        employeeList = employeeFile.readFile("src/MotorPH Employee Data - Employee Details.csv");     
        
        tableModel(employeeList);       
    
    }
    
    private void tableModel(ArrayList<String[]> employeeList) {
        employeeTableModel = new DefaultTableModel(0, 0){
            @Override
            public boolean isCellEditable(int i, int j) {
                return false;
            }
        }; 
        
        for (int i = 0; i < employeeList.size(); i++) {
            
            if (i == 0) {
                String[] tableHeader = {employeeList.get(i)[0],
                                        employeeList.get(i)[1],
                                        employeeList.get(i)[2],
                                        employeeList.get(i)[6],
                                        employeeList.get(i)[7],
                                        employeeList.get(i)[8],
                                        employeeList.get(i)[9]};
                employeeTableModel.setColumnIdentifiers(tableHeader);
                continue;
            }
            
            String[] employeeRow = {employeeList.get(i)[0],
                                    employeeList.get(i)[1],
                                    employeeList.get(i)[2],
                                    employeeList.get(i)[6],
                                    employeeList.get(i)[7],
                                    employeeList.get(i)[8],
                                    employeeList.get(i)[9]};
                                                
            employeeTableModel.addRow(employeeRow);
        }
                
        jTableEmployee.setModel(employeeTableModel);  
    }
    
    private void clearComponents() {
        jTextFieldEmployeeID.setText("");
        jTextFieldFirstName.setText("");
        jTextFieldLastName.setText("");
        jTextFieldPagIBIGID.setText("");
        jTextFieldPhilHealthID.setText("");
        jTextFieldSSSID.setText("");
        jTextFieldTINID.setText("");
        jLabelInputError.setVisible(false);
    }
    
    private boolean isSelectRecord() {
        if((jTableEmployee.getSelectedRowCount() != 1) || jTextFieldEmployeeID.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Please Select one Employee Record");
            return true;            
        }
        return false;
    }

    private EmployeeListPage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmployee = new javax.swing.JTable();
        jLabelEmployeeID = new javax.swing.JLabel();
        jLabelLastName = new javax.swing.JLabel();
        jLabelFirstName = new javax.swing.JLabel();
        jLabelSSSID = new javax.swing.JLabel();
        jLabelPhilHealthID = new javax.swing.JLabel();
        jLabelTINID = new javax.swing.JLabel();
        jLabelPagIBIGID = new javax.swing.JLabel();
        jTextFieldLastName = new javax.swing.JTextField();
        jTextFieldEmployeeID = new javax.swing.JTextField();
        jTextFieldFirstName = new javax.swing.JTextField();
        jTextFieldSSSID = new javax.swing.JTextField();
        jTextFieldPhilHealthID = new javax.swing.JTextField();
        jTextFieldTINID = new javax.swing.JTextField();
        jTextFieldPagIBIGID = new javax.swing.JTextField();
        jButtonView = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonRetrun = new javax.swing.JButton();
        jLabelInputError = new javax.swing.JLabel();
        jLabelUserProfile = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jButtonLeaveForm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MotorPH - Emloyee Table");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEmployee);

        jLabelEmployeeID.setText("Employee ID:");

        jLabelLastName.setText("Last Name:");

        jLabelFirstName.setText("First Name:");

        jLabelSSSID.setText("SSS ID:");

        jLabelPhilHealthID.setText("PhilHealth ID:");

        jLabelTINID.setText("TIN ID:");

        jLabelPagIBIGID.setText("Pag-IBIG ID:");

        jTextFieldEmployeeID.setEnabled(false);

        jButtonView.setText("View");
        jButtonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonRetrun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png"))); // NOI18N
        jButtonRetrun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetrunActionPerformed(evt);
            }
        });

        jLabelInputError.setForeground(java.awt.Color.red);
        jLabelInputError.setText("jLabel1");

        jLabelUserProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N

        jLabelUsername.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelUsername.setText("jLabel2");

        jButtonLeaveForm.setText("Leave Request");
        jButtonLeaveForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeaveFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabelLastName))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(jLabelEmployeeID))
                                .addComponent(jLabelFirstName, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelSSSID, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldLastName)
                                .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldSSSID, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabelPhilHealthID)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldPhilHealthID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelPagIBIGID)
                                        .addComponent(jLabelTINID))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldTINID)
                                        .addComponent(jTextFieldPagIBIGID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButtonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButtonView, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(32, 32, 32)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabelInputError))
                    .addComponent(jButtonRetrun)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jButtonLeaveForm)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelUserProfile)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelUsername)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonRetrun)
                .addGap(136, 136, 136)
                .addComponent(jLabelInputError)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEmployeeID)
                            .addComponent(jTextFieldEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLastName)
                            .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFirstName)
                            .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSSSID)
                            .addComponent(jTextFieldSSSID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelPhilHealthID)
                        .addComponent(jTextFieldPhilHealthID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTINID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTINID))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPagIBIGID)
                    .addComponent(jTextFieldPagIBIGID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonView))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonClear))
                .addGap(18, 18, 18)
                .addComponent(jButtonLeaveForm)
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelUserProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        if (isSelectRecord()) {
            return;
        }
        
        Input input = new Input();        
        String errorMessage = input.validateNumber(jTextFieldPagIBIGID, "PagIBIG ID", 12) +
                            input.validateNumber(jTextFieldPhilHealthID, "PhilHealth ID", 12) +
                            input.validateNumber(jTextFieldSSSID,"SSS ID", 10)+
                            input.validateNumber(jTextFieldTINID,"TIN ID", 12);

        boolean hasError = !errorMessage.isEmpty();

        if (hasError) {
            JOptionPane.showMessageDialog(this, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        boolean isFound = false;
        String employeeID;
        
        employeeTableModel = (DefaultTableModel) jTableEmployee.getModel();        
            employeeTableModel.setRowCount(0);                
        
        employeeFile = new File();
            employeeList = employeeFile.readFile("src/MotorPH Employee Data - Employee Details.csv");
        
        employeeID = jTextFieldEmployeeID.getText();
        
        for (String[] i : employeeList) {
            if (i[0].equals(employeeID)) {
                isFound = true;
                i[2] = jTextFieldFirstName.getText();
                i[1] = jTextFieldLastName.getText();
                i[9] = jTextFieldPagIBIGID.getText();
                i[7] = jTextFieldPhilHealthID.getText();
                i[6] = jTextFieldSSSID.getText();
                i[8] = jTextFieldTINID.getText();
                break;
            }
        }
        
        employeeFile.writeFile("src/MotorPH Employee Data - Employee Details.csv", employeeList);        
        
        tableModel(employeeList);
        
        clearComponents();
        
        JOptionPane.showMessageDialog(null, "Successfully Updated");
        //updatedEmployeeList = updatedEmployeeFile.writeFile("src/MotorPH Employee Data - Employee Details.csv", updatedEmployeeList);
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jTableEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmployeeMouseClicked
        // TODO add your handling code here:
        int rowIndex = jTableEmployee.getSelectedRow();
        
        jTextFieldEmployeeID.setText(jTableEmployee.getValueAt(rowIndex, 0).toString());
        jTextFieldFirstName.setText(jTableEmployee.getValueAt(rowIndex, 2).toString());
        jTextFieldLastName.setText(jTableEmployee.getValueAt(rowIndex, 1).toString());
        jTextFieldPagIBIGID.setText(jTableEmployee.getValueAt(rowIndex, 6).toString());
        jTextFieldPhilHealthID.setText(jTableEmployee.getValueAt(rowIndex, 4).toString());
        jTextFieldSSSID.setText(jTableEmployee.getValueAt(rowIndex, 3).toString());
        jTextFieldTINID.setText(jTableEmployee.getValueAt(rowIndex, 5).toString());
    }//GEN-LAST:event_jTableEmployeeMouseClicked

    private void jButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewActionPerformed
        // TODO add your handling code here:
        if (isSelectRecord()) {
            return;
        }
        
        boolean isFound = false;
        String employeeID;
        String[] employeeInformation = null;
        
        employeeFile = new File();
            employeeList = employeeFile.readFile("src/MotorPH Employee Data - Employee Details.csv");
        
        employeeID = jTextFieldEmployeeID.getText();       
               
        
        for (String[] i : employeeList) {
            if (i[0].equals(employeeID)) {
                isFound = true;
                employeeInformation = i;
                break;
            }
        }
        
        Employee viewEmployee = new Employee(employeeInformation);
        viewEmployee.setUserAccount(this.userInfo);
        AttendancePage attendancePage = new AttendancePage(viewEmployee);
        attendancePage.setVisible(isFound);
        setVisible(false);        
    }//GEN-LAST:event_jButtonViewActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
        clearComponents();
        
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        if (isSelectRecord()) {
            return;
        }
        
        int result = JOptionPane.showConfirmDialog(null, "Are you sure to delete the Employee Record", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.NO_OPTION) {
                return;
            }
        
        boolean isFound = false;
        String employeeID;
        
        employeeTableModel = (DefaultTableModel) jTableEmployee.getModel();        
            employeeTableModel.setRowCount(0);                
        
        employeeFile = new File();
            employeeList = employeeFile.readFile("src/MotorPH Employee Data - Employee Details.csv");
            
        employeeID = jTextFieldEmployeeID.getText();
        
        for (String[] i : employeeList) {
            if (i[0].equals(employeeID)) {
                isFound = true;
                employeeList.remove(employeeList.indexOf(i));
                break;
            }
        }
        
        employeeFile.writeFile("src/MotorPH Employee Data - Employee Details.csv", employeeList);        
        
        tableModel(employeeList);
        
        clearComponents();
        
        JOptionPane.showMessageDialog(null, "Successfully Deleted");    
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonRetrunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetrunActionPerformed
        // TODO add your handling code here:
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButtonRetrunActionPerformed

    private void jButtonLeaveFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeaveFormActionPerformed
        // TODO add your handling code here:
        boolean isFound = false;
        String employeeID;
        String[] employeeInformation = null;
        
        employeeFile = new File();
            employeeList = employeeFile.readFile("src/MotorPH Employee Data - Employee Details.csv");
        
        employeeID = this.userInfo.getEmployeeID();       
               
        
        for (String[] i : employeeList) {
            if (i[0].equals(employeeID)) {
                isFound = true;
                employeeInformation = i;
                break;
            }
        }
        
        Employee userEmployee = new Employee(employeeInformation);
        userEmployee.setUserAccount(this.userInfo);
        LeaveRequestForm leaveForm = new LeaveRequestForm(userEmployee);
        leaveForm.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButtonLeaveFormActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(EmployeeListPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeListPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeListPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeListPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeListPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonLeaveForm;
    private javax.swing.JButton jButtonRetrun;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JButton jButtonView;
    private javax.swing.JLabel jLabelEmployeeID;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelInputError;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelPagIBIGID;
    private javax.swing.JLabel jLabelPhilHealthID;
    private javax.swing.JLabel jLabelSSSID;
    private javax.swing.JLabel jLabelTINID;
    private javax.swing.JLabel jLabelUserProfile;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmployee;
    private javax.swing.JTextField jTextFieldEmployeeID;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldPagIBIGID;
    private javax.swing.JTextField jTextFieldPhilHealthID;
    private javax.swing.JTextField jTextFieldSSSID;
    private javax.swing.JTextField jTextFieldTINID;
    // End of variables declaration//GEN-END:variables
}
