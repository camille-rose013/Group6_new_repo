/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frame;

import Class.Attendance;
import Class.Employee;
import Class.File;
import Class.Input;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 63909
 */
public class AttendancePage extends javax.swing.JFrame {

    /**s
     * Creates new form PayrollPage
     * * @param employee
     */
    DefaultTableModel attendanceTableModel;
    File scheduleFile = null;
    File attendanceFile = null;
    ArrayList<String[]> scheduleList = null;
    ArrayList<String[]> attendanceList = null;    
    Date startDate, endDate;
    Input input = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
    SimpleDateFormat computeTimeFormat = new SimpleDateFormat("HH:mm");
    Employee employee;    
      
    public AttendancePage(Employee employee) {
        this.employee = employee;
        initComponents();        
        populateCombobox();

        jLabelInputID.setText(employee.getEmployeeID());
        jLabelInputName.setText(employee.getLastName() + ", "+ employee.getFirstName());
        
        attendanceFile = new File();
        attendanceList = attendanceFile.readFile("src/MotorPH Employee Data - Attendace.csv");           
    }

    private AttendancePage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void populateCombobox(){
        scheduleFile = new File();
        scheduleList = scheduleFile.readFile("src/MotorPH Employee Data - Pay Period Schedule.csv");
        
        for (String[] date : scheduleList) {
            if (scheduleList.indexOf(date) == 0) {                
                jComboBoxPayPeriod.addItem("Select Pay Period ");
                continue;
            }
            jComboBoxPayPeriod.addItem(date[0] + " : " + date[1]);
        }       
        
    }
    
    private void setTableModel(ArrayList<Date> dateList) {
        attendanceTableModel = new DefaultTableModel(0, 0){
            @Override
            public boolean isCellEditable(int i, int j) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        attendanceFile = new File();
        attendanceList = attendanceFile.readFile("src/MotorPH Employee Data - Attendace.csv");
       
        HashMap<Date,Date[]> employeeAttendanceMap = new HashMap<>();
        ArrayList<String[]> employeeAttendanceList = new ArrayList<>();
        input = new Input();
        Attendance attendance = new Attendance();
        
        for (String[] i : attendanceList) {
            if (attendanceList.indexOf(i) == 0) {
                String[] tableHeader = {i[1],i[2],i[3], "Worked Hours"};
                attendanceTableModel.setColumnIdentifiers(tableHeader);
                continue;
            }
            if (i[0].equals(employee.getEmployeeID())) {
                Date attendanceDate = input.toDate(i[1]);
                Date timeIn = input.toTime(i[2]);
                Date timeOut = input.toTime(i[3]);
                Date[] timeAttendance = {timeIn,timeOut};
                employeeAttendanceMap.put(attendanceDate, timeAttendance);
            }
        }
        
        for (Date i : dateList) {
            if (employeeAttendanceMap.get(i) == null) {
                String[] attendanceRow = {dateFormat.format(i),"----","----", "0"};
                attendanceTableModel.addRow(attendanceRow);
                continue;
            }
            String timeIn = computeTimeFormat.format(employeeAttendanceMap.get(i)[0]);
            String timeOut = computeTimeFormat.format(employeeAttendanceMap.get(i)[1]);
            String HoursWorked = String.valueOf((int)attendance.calculateHours(timeIn, timeOut));
            String MinWorked = String.valueOf((int)((attendance.calculateHours(timeIn, timeOut)%1)*60));
            String[] attendanceRow = {dateFormat.format(i),
                                        timeFormat.format(employeeAttendanceMap.get(i)[0]),
                                        timeFormat.format(employeeAttendanceMap.get(i)[1]),
                                        HoursWorked + "hrs " + MinWorked + "min"};
            
            String[] timeAttendance = {timeIn,timeOut};
            employeeAttendanceList.add(timeAttendance);
            attendanceTableModel.addRow(attendanceRow);
        }        
        
        jTextFieldTotalWorkedHours.setText(String.valueOf((int)attendance.calculateAttendance(employeeAttendanceList)));
        jTableAttendance.setModel(attendanceTableModel);        
    }
    
    private boolean isThereAttendance() {        
        String attendance = jTextFieldTotalWorkedHours.getText();
        return !attendance.isBlank() && !attendance.equals("0");
    }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAttendance = new javax.swing.JPanel();
        jButtonRetrun = new javax.swing.JButton();
        jComboBoxPayPeriod = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAttendance = new javax.swing.JTable();
        jLabelTotalWorkedHours = new javax.swing.JLabel();
        jTextFieldTotalWorkedHours = new javax.swing.JTextField();
        jButtonComputePayroll = new javax.swing.JButton();
        jLabelAttendance = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelEmployeeID = new javax.swing.JLabel();
        jLabelInputID = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelInputName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MotorPH - Attendance");

        jButtonRetrun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.png"))); // NOI18N
        jButtonRetrun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetrunActionPerformed(evt);
            }
        });

        jComboBoxPayPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPayPeriodActionPerformed(evt);
            }
        });

        jTableAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableAttendance);

        jLabelTotalWorkedHours.setText("Total Worked Hours:");

        jTextFieldTotalWorkedHours.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextFieldTotalWorkedHours.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldTotalWorkedHours.setEnabled(false);

        jButtonComputePayroll.setText("Compute Payroll");
        jButtonComputePayroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComputePayrollActionPerformed(evt);
            }
        });

        jLabelAttendance.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelAttendance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAttendance.setText("Attedance");

        jLabelEmployeeID.setText("Employee ID:");

        jLabelInputID.setText("jLabel3");

        jLabelName.setText("Name:");

        jLabelInputName.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelName)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelInputName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelEmployeeID)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelInputID)))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmployeeID)
                    .addComponent(jLabelInputID))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jLabelInputName))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelAttendanceLayout = new javax.swing.GroupLayout(jPanelAttendance);
        jPanelAttendance.setLayout(jPanelAttendanceLayout);
        jPanelAttendanceLayout.setHorizontalGroup(
            jPanelAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAttendanceLayout.createSequentialGroup()
                .addComponent(jButtonRetrun)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelAttendanceLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxPayPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAttendance))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelAttendanceLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanelAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAttendanceLayout.createSequentialGroup()
                        .addComponent(jLabelTotalWorkedHours)
                        .addGap(10, 10, 10)
                        .addComponent(jTextFieldTotalWorkedHours, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanelAttendanceLayout.createSequentialGroup()
                        .addComponent(jButtonComputePayroll)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAttendanceLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))))
        );
        jPanelAttendanceLayout.setVerticalGroup(
            jPanelAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAttendanceLayout.createSequentialGroup()
                .addComponent(jButtonRetrun, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAttendance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jComboBoxPayPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalWorkedHours)
                    .addComponent(jTextFieldTotalWorkedHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jButtonComputePayroll)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxPayPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPayPeriodActionPerformed
        // TODO add your handling code here:
        if (jComboBoxPayPeriod.getSelectedIndex() == 0) {             
            return;
        }
        String[] dates = jComboBoxPayPeriod.getSelectedItem().toString().split(":");
        input = new Input();
        if(!input.isDate(dates[0]) || !input.isDate(dates[1])) {
            System.out.print(dates[0]+" Not Date");
            return;
        }
        
        ArrayList<Date> dateList = new ArrayList<>();
        startDate = input.toDate(dates[0]);
        endDate = input.toDate(dates[1]);
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        
        while (!calendar.getTime().after(endDate))
        {
            Date result = calendar.getTime();
            dateList.add(calendar.getTime());
            calendar.add(Calendar.DATE, 1);
        }
        
        employee.setPayPeriod((String) jComboBoxPayPeriod.getSelectedItem());
        
        setTableModel(dateList);
    }//GEN-LAST:event_jComboBoxPayPeriodActionPerformed

    private void jButtonComputePayrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComputePayrollActionPerformed
        // TODO add your handling code here:
        if (!isThereAttendance()) {
            JOptionPane.showMessageDialog(null, "No Attendance Found");
            return;
        }
        employee.setTotalHoursWorked(Double.parseDouble(jTextFieldTotalWorkedHours.getText()));
        
        PayrollPage payrollPage = new PayrollPage(employee);
        payrollPage.setVisible(isThereAttendance());
        dispose();
    }//GEN-LAST:event_jButtonComputePayrollActionPerformed

    private void jButtonRetrunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetrunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRetrunActionPerformed

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
            java.util.logging.Logger.getLogger(AttendancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendancePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonComputePayroll;
    private javax.swing.JButton jButtonRetrun;
    private javax.swing.JComboBox<String> jComboBoxPayPeriod;
    private javax.swing.JLabel jLabelAttendance;
    private javax.swing.JLabel jLabelEmployeeID;
    private javax.swing.JLabel jLabelInputID;
    private javax.swing.JLabel jLabelInputName;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelTotalWorkedHours;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAttendance;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAttendance;
    private javax.swing.JTextField jTextFieldTotalWorkedHours;
    // End of variables declaration//GEN-END:variables
}
