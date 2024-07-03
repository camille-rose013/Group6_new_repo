/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frame;

import Class.Employee;
import Class.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author camil
 */
public class LeaveRequestForm extends javax.swing.JFrame {

    /**
     * Creates new form LeaveRequestForm
     * 
     */    
    Employee employee; 
    File leaveRequestFile = null;
    ArrayList<String[]> leaveRequestList = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
    String reason;
    boolean isOtherSelected;
    
    public LeaveRequestForm(Employee employee) {
        this.employee = employee;
        initComponents();
        
        jLabelError.setVisible(false);
        jTextFieldFirstName.setText(employee.getFirstName());
        jTextFieldLastName.setText(employee.getLastName());
        jTextFieldDepartment.setText("N/A");
        jTextFieldPhone.setText(employee.getPhoneNumber());
        jTextFieldEmail.setText("N/A"); 
        
            jDateChooserStartDate.getDateEditor().addPropertyChangeListener(
            new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    try {
                        long dateDifference = jDateChooserEndDate.getDate().getTime() - jDateChooserStartDate.getDate().getTime() + 1;
                        jTextFieldNo_daysRequest.setText(Long.toString(TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS)));
                        
                        if (dateDifference < 1) {
                            jLabelError.setText("Invalid Date");
                            jLabelError.setVisible(true);
                        }
                    }
                    catch (NullPointerException err) {
                    }
                }
            });        

            jDateChooserEndDate.getDateEditor().addPropertyChangeListener(
            new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    try {
                        long dateDifference = jDateChooserEndDate.getDate().getTime() - jDateChooserStartDate.getDate().getTime() + 1;
                        jTextFieldNo_daysRequest.setText(Long.toString(TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS)));
                    }
                    catch (NullPointerException err) {
                    }
                }
            });
            
            jRadioButtonOthers.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jTextFieldOthers.setEditable(true);
                    isOtherSelected = true;
                }
            });
            
            jRadioButtonAnnLeave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        isOtherSelected = false;
                        reason = "";
                        jTextFieldOthers.setText("");
                        jTextFieldOthers.setEditable(false);
                        reason = jRadioButtonAnnLeave.getText();
                }
            });
            
            jRadioButtonEmergLeave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        isOtherSelected = false;
                        jTextFieldOthers.setText("");
                        jTextFieldOthers.setEditable(false);
                        reason = jRadioButtonEmergLeave.getText();
                }
            });
        
        }

    private LeaveRequestForm() {
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

        buttonGroupLeave = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelApplicantName = new javax.swing.JLabel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelDepartment = new javax.swing.JLabel();
        jTextFieldDepartment = new javax.swing.JTextField();
        jLabelPhone = new javax.swing.JLabel();
        jTextFieldPhone = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelReason = new javax.swing.JLabel();
        jRadioButtonEmergLeave = new javax.swing.JRadioButton();
        jRadioButtonAnnLeave = new javax.swing.JRadioButton();
        jRadioButtonOthers = new javax.swing.JRadioButton();
        jLabelFdAbsence = new javax.swing.JLabel();
        jLabelLdAbsence = new javax.swing.JLabel();
        jLabelNo_daysRequest = new javax.swing.JLabel();
        jTextFieldNo_daysRequest = new javax.swing.JTextField();
        jLabelInfoText = new javax.swing.JLabel();
        jLabelComment = new javax.swing.JLabel();
        jScrollPaneTextArea = new javax.swing.JScrollPane();
        jTextAreaComment = new javax.swing.JTextArea();
        jButtonSubmit = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jDateChooserStartDate = new com.toedter.calendar.JDateChooser();
        jDateChooserEndDate = new com.toedter.calendar.JDateChooser();
        jTextFieldOthers = new javax.swing.JTextField();
        jLabelError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MotorPH - Leave Request Form");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabelTitle.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabelTitle.setText("Leave Request Form");

        jLabelApplicantName.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabelApplicantName.setText("Applicant Name :");

        jTextFieldFirstName.setEditable(false);
        jTextFieldFirstName.setToolTipText("");
        jTextFieldFirstName.setActionCommand("<Not Set>");

        jTextFieldLastName.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("<html>\n<p>\nPlease fill in the form below if you need to leave work. All leave applications need to be approved by both applicant and manager.\n</p>\n</html>");

        jLabelDepartment.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabelDepartment.setText("Department :");

        jTextFieldDepartment.setEditable(false);

        jLabelPhone.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabelPhone.setText("Phone :");

        jTextFieldPhone.setEditable(false);

        jLabelEmail.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabelEmail.setText("Email :");

        jTextFieldEmail.setEditable(false);

        jLabelReason.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabelReason.setText("Reason For Leave :");

        buttonGroupLeave.add(jRadioButtonEmergLeave);
        jRadioButtonEmergLeave.setText("Emergency Leave");
        jRadioButtonEmergLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEmergLeaveActionPerformed(evt);
            }
        });

        buttonGroupLeave.add(jRadioButtonAnnLeave);
        jRadioButtonAnnLeave.setText("Annual Leave");

        buttonGroupLeave.add(jRadioButtonOthers);
        jRadioButtonOthers.setText("Others:");

        jLabelFdAbsence.setText("Start Date of Absence :");

        jLabelLdAbsence.setText("End Date of Absence :");

        jLabelNo_daysRequest.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabelNo_daysRequest.setText("No. of Days Requested :");

        jTextFieldNo_daysRequest.setEditable(false);

        jLabelInfoText.setText("Filled automatically");

        jLabelComment.setText("Comment (Optional) :");

        jTextAreaComment.setColumns(20);
        jTextAreaComment.setRows(5);
        jScrollPaneTextArea.setViewportView(jTextAreaComment);

        jButtonSubmit.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButtonSubmit.setText("Submit");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jButtonCancel.setBackground(new java.awt.Color(204, 0, 51));
        jButtonCancel.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jTextFieldOthers.setEditable(false);

        jLabelError.setForeground(java.awt.Color.red);
        jLabelError.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabelDepartment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelApplicantName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(12, 12, 12)
                                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextFieldDepartment)
                                .addComponent(jLabelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldEmail)
                                .addComponent(jTextFieldPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelNo_daysRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldNo_daysRequest)
                                .addComponent(jLabelInfoText, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelComment, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelReason, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButtonEmergLeave)
                                .addComponent(jRadioButtonAnnLeave)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jRadioButtonOthers)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextFieldOthers))
                                        .addComponent(jLabelFdAbsence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelLdAbsence, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPaneTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButtonSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jDateChooserStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooserEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabelError)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabelApplicantName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabelDepartment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabelPhone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabelReason)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonEmergLeave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonAnnLeave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonOthers)
                    .addComponent(jTextFieldOthers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelFdAbsence, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLdAbsence, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelNo_daysRequest)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldNo_daysRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInfoText, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabelComment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelError)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        EmployeeListPage employeeListPage = new EmployeeListPage(this.employee.getUserAccount());
        employeeListPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        // TODO add your handling code here:
        boolean isReasonSelected = jRadioButtonEmergLeave.isSelected() || jRadioButtonAnnLeave.isSelected() || jRadioButtonOthers.isSelected();
        if (!isReasonSelected) {
            jLabelError.setText("Please provide a reason");
            jLabelError.setVisible(true);
            return;
        }

        if (isOtherSelected) {
            if (jTextFieldOthers.getText().isEmpty()) {
                jLabelError.setText("Please provide a reason");
                jLabelError.setVisible(true);
                return;
            }
            reason = jTextFieldOthers.getText();
        } 
        
        try {
            if (Integer.parseInt(jTextFieldNo_daysRequest.getText()) < 1) {
                jLabelError.setText("Invalid Date");
                jLabelError.setVisible(true);
                return;
            }
            
            leaveRequestFile = new File();
            leaveRequestList = leaveRequestFile.readFile("src/MotorPH Employee Data - Leave Requests.csv");

            String [] leaveRequest =    {"1",
                                        employee.getEmployeeID(),
                                        employee.getLastName(),
                                        employee.getFirstName(),
                                        reason,
                                        dateFormat.format(jDateChooserStartDate.getDate()),
                                        dateFormat.format(jDateChooserEndDate.getDate()),
                                        jTextFieldNo_daysRequest.getText(),
                                        jTextAreaComment.getText()};

            leaveRequestList.add(leaveRequest);

            leaveRequestFile.writeFile("src/MotorPH Employee Data - Leave Requests.csv", leaveRequestList);

            JOptionPane.showMessageDialog(null, "Successfully Requested Leave");
            EmployeeListPage employeeListPage = new EmployeeListPage(this.employee.getUserAccount());
            employeeListPage.setVisible(true);
            dispose();
        } catch (NullPointerException | NumberFormatException  e) {
            jLabelError.setText("Please provide Valid Leave Dates");
            jLabelError.setVisible(true);
        }
        

    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void jRadioButtonEmergLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEmergLeaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonEmergLeaveActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        EmployeeListPage employeeListPage = new EmployeeListPage(this.employee.getUserAccount());
        employeeListPage.setVisible(true);
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
            java.util.logging.Logger.getLogger(LeaveRequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeaveRequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeaveRequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeaveRequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeaveRequestForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLeave;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSubmit;
    private com.toedter.calendar.JDateChooser jDateChooserEndDate;
    private com.toedter.calendar.JDateChooser jDateChooserStartDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelApplicantName;
    private javax.swing.JLabel jLabelComment;
    private javax.swing.JLabel jLabelDepartment;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JLabel jLabelFdAbsence;
    private javax.swing.JLabel jLabelInfoText;
    private javax.swing.JLabel jLabelLdAbsence;
    private javax.swing.JLabel jLabelNo_daysRequest;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JLabel jLabelReason;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonAnnLeave;
    private javax.swing.JRadioButton jRadioButtonEmergLeave;
    private javax.swing.JRadioButton jRadioButtonOthers;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneTextArea;
    private javax.swing.JTextArea jTextAreaComment;
    private javax.swing.JTextField jTextFieldDepartment;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldNo_daysRequest;
    private javax.swing.JTextField jTextFieldOthers;
    private javax.swing.JTextField jTextFieldPhone;
    // End of variables declaration//GEN-END:variables
}
