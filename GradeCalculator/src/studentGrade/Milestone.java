/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package studentGrade;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import javax.swing.JOptionPane;

/**
 *
 * @author 63909
 */
public class Milestone extends javax.swing.JFrame {
    
    /**
     * Creates new form Grade
     */
    private final int MAX_M1 = 25;
    private final int MAX_M2 = 40;
    private final int MAX_TA = 35; 

    public Milestone() {
        initComponents();
        
        jTextFieldMS1.getDocument().addDocumentListener(new ValidationListener(jTextFieldMS1, jLabelErrorMS1, MAX_M1));
        jTextFieldMS2.getDocument().addDocumentListener(new ValidationListener(jTextFieldMS2, jLabelErrorMS2, MAX_M2));
        jTextFieldTA.getDocument().addDocumentListener(new ValidationListener(jTextFieldTA, jLabelErrorTA, MAX_TA));        
    }
    
    private class ValidationListener implements DocumentListener{
            private JTextField textField;
            private JLabel errorLabel;
            private int max;

            public ValidationListener(JTextField textField, JLabel errorLabel, int max) {
                this.textField = textField;
                this.errorLabel = errorLabel;
                this.max = max;
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // This is generally used for changes that do not change the actual content
                // like attribute changes, so we do not need to validate here.
            }

            private void validate() {
                String text = textField.getText();
                try {
                    int value = Integer.parseInt(text);
                    if (value < 1 || value > max) {
                        errorLabel.setText("Must be 1-" + max);
                        errorLabel.setVisible(true); // Show error label
                    } else {
                        errorLabel.setText(""); // Clear error message
                        errorLabel.setVisible(false); // Hide error label
                    }
                } catch (NumberFormatException e) {
                    errorLabel.setText("Invalid number");
                    errorLabel.setVisible(true); // Show error label
                }
            }                   
        }    
    
    private void validateAndCalculate() {
        String errorMessage = validateInput(jTextFieldMS1, MAX_M1, "Milestone 1") +
                validateInput(jTextFieldMS2, MAX_M2, "Milestone 2") +
                validateInput(jTextFieldTA, MAX_TA, "Terminal Assessment");

        boolean hasError = !errorMessage.isEmpty();

        if (hasError) {
            JOptionPane.showMessageDialog(this, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
            jTextFieldGradeAverage.setText("");
            return;
        }
        
            // Instantiate Student class          
            Student stud = new Student();
            // Assign textfield values to stud object
            stud.setStudentName(jTextFieldStudentName.getText());
            stud.setStudentNumber(jTextFieldStudentNumber.getText());

            stud.setMS1(Float.parseFloat(jTextFieldMS1.getText()));
            stud.setMS2(Float.parseFloat(jTextFieldMS2.getText()));
            stud.setTA(Float.parseFloat(jTextFieldTA.getText()));

             // Calculate the Average Grade and Display on the jTextField
            jTextFieldGradeAverage.setText(String.valueOf(stud.computeAverage()));
            
    }

    private String validateInput(JTextField textField, int max, String fieldName) {
        String text = textField.getText();
        try {
            int value = Integer.parseInt(text);
            if (value < 1 || value > max) {
                return fieldName + " grade must be between 1 and " + max + ".\n";
            }
        } catch (NumberFormatException e) {
            return fieldName + " grade must be a valid number.\n";
        }
        return "";
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelStudentName = new javax.swing.JLabel();
        jLabelStudentNumber = new javax.swing.JLabel();
        jLabelMS1 = new javax.swing.JLabel();
        jLabelMS2 = new javax.swing.JLabel();
        jLabelTA = new javax.swing.JLabel();
        jLabelGradeAverage = new javax.swing.JLabel();
        jTextFieldStudentName = new javax.swing.JTextField();
        jTextFieldStudentNumber = new javax.swing.JTextField();
        jTextFieldMS1 = new javax.swing.JTextField();
        jTextFieldMS2 = new javax.swing.JTextField();
        jTextFieldTA = new javax.swing.JTextField();
        jTextFieldGradeAverage = new javax.swing.JTextField();
        jButtonCalculate = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jLabelErrorMS1 = new javax.swing.JLabel();
        jLabelErrorMS2 = new javax.swing.JLabel();
        jLabelErrorTA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grade Calculator");

        jLabelStudentName.setText("Student Name:");

        jLabelStudentNumber.setText("Student Number:");

        jLabelMS1.setText("Milestone 1:");

        jLabelMS2.setText("Milestone 2:");

        jLabelTA.setText("Terminal Assessment:");

        jLabelGradeAverage.setText("Grade Average:");

        jTextFieldStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStudentNameActionPerformed(evt);
            }
        });

        jTextFieldGradeAverage.setEditable(false);

        jButtonCalculate.setText("Calculate");
        jButtonCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculateActionPerformed(evt);
            }
        });

        jButtonClear.setText("Clear All");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jLabelErrorMS1.setForeground(java.awt.Color.red);

        jLabelErrorMS2.setForeground(java.awt.Color.red);
        jLabelErrorMS2.setToolTipText("");

        jLabelErrorTA.setForeground(java.awt.Color.red);
        jLabelErrorTA.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelGradeAverage)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelTA)
                        .addComponent(jLabelStudentName, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelMS2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelStudentNumber, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabelMS1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldStudentName)
                    .addComponent(jTextFieldStudentNumber)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldTA, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldMS2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldMS1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCalculate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jButtonClear))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelErrorTA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelErrorMS2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelErrorMS1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jTextFieldGradeAverage))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStudentNumber)
                            .addComponent(jTextFieldStudentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldMS1)
                            .addComponent(jLabelErrorMS1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabelMS1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldMS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelErrorMS2))
                    .addComponent(jLabelMS2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTA)
                        .addComponent(jTextFieldTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelErrorTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGradeAverage)
                    .addComponent(jTextFieldGradeAverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCalculate)
                    .addComponent(jButtonClear))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldStudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStudentNameActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
    // Clear All Set Value
    jTextFieldStudentName.setText("");
    jTextFieldStudentNumber.setText("");
    
    jTextFieldMS1.setText("");
    jTextFieldMS2.setText("");
    jTextFieldTA.setText("");
    
    jTextFieldGradeAverage.setText("");
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculateActionPerformed
        // TODO add your handling code here:        
    validateAndCalculate();        
    
    }//GEN-LAST:event_jButtonCalculateActionPerformed

    public class Student {
    //attributes
    private String studentNumber;
    private String studentName;
    private float ms1;
    private float ms2;
    private float ta;
    private float averageGrade;
   
    //getter and setter methods
    //getter methods
    public String getStudentNumber() {
        return studentNumber;
    }
    
    public String getStudentName() {
        return studentName;
    }
   
    public String getMS1() {
        return String.valueOf(ms1);
    }
   
    public String getMS2() {
        return String.valueOf(ms2);
    }
   
    public String getTA() {
        return String.valueOf(ta);
    }
   
    public String getAveGrade() {
        return String.valueOf(averageGrade);
    }
   
    //setter methods
    public void setStudentNumber(String studNumber) {
        studentNumber = studNumber;
    }
   
    public void setStudentName(String studName) {
        studentName = studName;
    }
   
    public void setMS1(float g1) {
        ms1 = g1;
    }
   
    public void setMS2(float g2) {
        ms2 = g2;
    }
   
    public void setTA(float g3) {
        ta = g3;
    }
   
    //methods
    public float computeAverage() {
        averageGrade = (ms1 + ms2 + ta) / 3;
        return averageGrade;
    }
}
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
            java.util.logging.Logger.getLogger(Milestone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Milestone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Milestone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Milestone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Milestone().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalculate;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JLabel jLabelErrorMS1;
    private javax.swing.JLabel jLabelErrorMS2;
    private javax.swing.JLabel jLabelErrorTA;
    private javax.swing.JLabel jLabelGradeAverage;
    private javax.swing.JLabel jLabelMS1;
    private javax.swing.JLabel jLabelMS2;
    private javax.swing.JLabel jLabelStudentName;
    private javax.swing.JLabel jLabelStudentNumber;
    private javax.swing.JLabel jLabelTA;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldGradeAverage;
    private javax.swing.JTextField jTextFieldMS1;
    private javax.swing.JTextField jTextFieldMS2;
    private javax.swing.JTextField jTextFieldStudentName;
    private javax.swing.JTextField jTextFieldStudentNumber;
    private javax.swing.JTextField jTextFieldTA;
    // End of variables declaration//GEN-END:variables
}
