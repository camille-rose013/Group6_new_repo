/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frame;

import Class.Employee;
import Class.Salary;
import java.text.DecimalFormat;

/**
 *
 * @author 63909
 */
public class PayrollPage extends javax.swing.JFrame {

    /**
     * Creates new form PayrollPage
     * @param employee
     */
    Employee employee;
    Salary salary = null;
    double basicSalary, totalAllowance, gross;
    double sss, philhealth, pagibig, withHoldingTax, govermentContribution, totalDeduction;
    double netSalary;
    DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
    
    public PayrollPage(Employee employee) {
        initComponents();
        
        this.employee = employee;
        salary = new Salary();       
                        
        basicSalary = salary.calculateBasicSalary(employee.getTotalHoursWorked(), employee.getHourlyRate());            
        totalAllowance = salary.calculateTotalAllowance(employee.getRiceSubsidy()/2, employee.getPhoneAllowance()/2, employee.getClothingAllowance()/2);        
        gross = salary.calculateGross(basicSalary, totalAllowance);
        
        sss = salary.calculateSSS(gross);
        philhealth = salary.calculatePhilHealth(gross);
        pagibig = salary.calculatePagIbig(gross);
        govermentContribution = salary.calculateGovermentContribution(sss, philhealth, pagibig);
        withHoldingTax = salary.calculateWithHoldingTax(gross, totalDeduction);
        totalDeduction = salary.calculateTotalDeductions(govermentContribution, withHoldingTax);      
                
        netSalary = salary.calculateNet(gross, totalDeduction, withHoldingTax);
        
        jLabelInputID.setText(employee.getEmployeeID());
        jLabelInputName.setText(employee.getLastName() + ", "+ employee.getFirstName());
        jLabelInputPayPeriod.setText(employee.getPayPeriod());
        
        jTextFieldHoursWorked.setText(decimalFormat.format(employee.getTotalHoursWorked()));
        jTextFieldHourlyRate.setText(decimalFormat.format(employee.getHourlyRate()));        
        jTextFieldBasicSalary1.setText(decimalFormat.format(basicSalary));
        
        jTextFieldBasicSalary2.setText(decimalFormat.format(basicSalary));    
        jTextFieldRiceSubsidy.setText(decimalFormat.format(employee.getRiceSubsidy()/2));
        jTextFieldPhoneAllowance.setText(decimalFormat.format(employee.getPhoneAllowance()/2));
        jTextFieldClothingAllowance.setText(decimalFormat.format(employee.getClothingAllowance()/2));        
        jTextFieldGrossSalary.setText(decimalFormat.format(gross));        
        
        jTextFieldSSS.setText(decimalFormat.format(sss));
        jTextFieldPhilHealth.setText(decimalFormat.format(philhealth));
        jTextFieldPagIBIG.setText(decimalFormat.format(pagibig));
        jTextFieldWitholdingTax.setText(decimalFormat.format(withHoldingTax)); 
        jTextFieldTotalDeductions.setText(decimalFormat.format(totalDeduction));
               
        
        jTextFieldNetSalary.setText(decimalFormat.format(netSalary));
        
        
        
        
    }

    private PayrollPage() {
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
        jPanelPayroll = new javax.swing.JPanel();
        jLabelPayroll = new javax.swing.JLabel();
        jPanelEarnings = new javax.swing.JPanel();
        jLabelBasicSalary2 = new javax.swing.JLabel();
        jTextFieldBasicSalary2 = new javax.swing.JTextField();
        jTextFieldRiceSubsidy = new javax.swing.JTextField();
        jLabelRiceSubsidy = new javax.swing.JLabel();
        jLabelPhoneAllowance = new javax.swing.JLabel();
        jTextFieldPhoneAllowance = new javax.swing.JTextField();
        jLabelClothingAllowance = new javax.swing.JLabel();
        jTextFieldClothingAllowance = new javax.swing.JTextField();
        jLabelHoursWorked = new javax.swing.JLabel();
        jLabelHourlyRate = new javax.swing.JLabel();
        jTextFieldHoursWorked = new javax.swing.JTextField();
        jTextFieldHourlyRate = new javax.swing.JTextField();
        jLabelBasicSalary1 = new javax.swing.JLabel();
        jTextFieldBasicSalary1 = new javax.swing.JTextField();
        jLabelGrossSalary = new javax.swing.JLabel();
        jTextFieldGrossSalary = new javax.swing.JTextField();
        jPanelEmployeeInformation = new javax.swing.JPanel();
        jLabelEmployeeID = new javax.swing.JLabel();
        jLabelInputID = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelInputName = new javax.swing.JLabel();
        jLabelPayPeriod = new javax.swing.JLabel();
        jLabelInputPayPeriod = new javax.swing.JLabel();
        jPanelDeduction = new javax.swing.JPanel();
        jLabelWitholdingTax = new javax.swing.JLabel();
        jTextFieldWitholdingTax = new javax.swing.JTextField();
        jTextFieldSSS = new javax.swing.JTextField();
        jLabelSSS = new javax.swing.JLabel();
        jLabelPhilHealth = new javax.swing.JLabel();
        jTextFieldPhilHealth = new javax.swing.JTextField();
        jLabelPagIBIG = new javax.swing.JLabel();
        jTextFieldPagIBIG = new javax.swing.JTextField();
        jLabelTotalDeductions = new javax.swing.JLabel();
        jTextFieldTotalDeductions = new javax.swing.JTextField();
        jLabelLess = new javax.swing.JLabel();
        jTextFieldNetSalary = new javax.swing.JTextField();
        jLabelNetSalary = new javax.swing.JLabel();
        jButtonRetrun = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MotorPH - Payroll");

        jLabelPayroll.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelPayroll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPayroll.setText("Payroll");

        jPanelEarnings.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Earnings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabelBasicSalary2.setText("Basic Salary:");

        jTextFieldBasicSalary2.setEditable(false);
        jTextFieldBasicSalary2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldBasicSalary2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTextFieldRiceSubsidy.setEditable(false);
        jTextFieldRiceSubsidy.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldRiceSubsidy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelRiceSubsidy.setText("Rice Subsidy:");

        jLabelPhoneAllowance.setText("Phone Allowance:");

        jTextFieldPhoneAllowance.setEditable(false);
        jTextFieldPhoneAllowance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPhoneAllowance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelClothingAllowance.setText("Clothing Allowance:");

        jTextFieldClothingAllowance.setEditable(false);
        jTextFieldClothingAllowance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldClothingAllowance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelHoursWorked.setText("Hours Worked:");

        jLabelHourlyRate.setText("Hourly Rate:");

        jTextFieldHoursWorked.setEditable(false);
        jTextFieldHoursWorked.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHoursWorked.setEnabled(false);

        jTextFieldHourlyRate.setEditable(false);
        jTextFieldHourlyRate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHourlyRate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelBasicSalary1.setText("Basic Salary:");

        jTextFieldBasicSalary1.setEditable(false);
        jTextFieldBasicSalary1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldBasicSalary1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelGrossSalary.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabelGrossSalary.setText("Gross Salary:");

        jTextFieldGrossSalary.setEditable(false);
        jTextFieldGrossSalary.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldGrossSalary.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldGrossSalary.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelEarningsLayout = new javax.swing.GroupLayout(jPanelEarnings);
        jPanelEarnings.setLayout(jPanelEarningsLayout);
        jPanelEarningsLayout.setHorizontalGroup(
            jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEarningsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEarningsLayout.createSequentialGroup()
                        .addGroup(jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelBasicSalary1)
                            .addComponent(jLabelHoursWorked)
                            .addComponent(jLabelHourlyRate))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldHourlyRate, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jTextFieldBasicSalary1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jTextFieldHoursWorked))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEarningsLayout.createSequentialGroup()
                                .addComponent(jLabelPhoneAllowance)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldPhoneAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEarningsLayout.createSequentialGroup()
                                .addComponent(jLabelRiceSubsidy)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldRiceSubsidy, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEarningsLayout.createSequentialGroup()
                                .addComponent(jLabelBasicSalary2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldBasicSalary2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEarningsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEarningsLayout.createSequentialGroup()
                                .addComponent(jLabelClothingAllowance)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldClothingAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEarningsLayout.createSequentialGroup()
                                .addComponent(jLabelGrossSalary)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldGrossSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanelEarningsLayout.setVerticalGroup(
            jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEarningsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEarningsLayout.createSequentialGroup()
                        .addGroup(jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelBasicSalary2)
                            .addComponent(jTextFieldBasicSalary2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRiceSubsidy)
                            .addComponent(jTextFieldRiceSubsidy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPhoneAllowance)
                            .addComponent(jTextFieldPhoneAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelEarningsLayout.createSequentialGroup()
                        .addGroup(jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelHoursWorked)
                            .addComponent(jTextFieldHoursWorked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelHourlyRate)
                            .addComponent(jTextFieldHourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelBasicSalary1)
                            .addComponent(jTextFieldBasicSalary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClothingAllowance)
                    .addComponent(jTextFieldClothingAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEarningsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGrossSalary)
                    .addComponent(jTextFieldGrossSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelEmployeeID.setText("Employee ID:");

        jLabelInputID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelInputID.setText("jLabel3");

        jLabelName.setText("Name:");

        jLabelInputName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelInputName.setText("jLabel5");

        jLabelPayPeriod.setText("Pay Period:");

        jLabelInputPayPeriod.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelInputPayPeriod.setText("jLabel16");

        javax.swing.GroupLayout jPanelEmployeeInformationLayout = new javax.swing.GroupLayout(jPanelEmployeeInformation);
        jPanelEmployeeInformation.setLayout(jPanelEmployeeInformationLayout);
        jPanelEmployeeInformationLayout.setHorizontalGroup(
            jPanelEmployeeInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmployeeInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEmployeeInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEmployeeInformationLayout.createSequentialGroup()
                        .addComponent(jLabelName)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelInputName)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelEmployeeInformationLayout.createSequentialGroup()
                        .addComponent(jLabelEmployeeID)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelInputID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addComponent(jLabelPayPeriod)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelInputPayPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelEmployeeInformationLayout.setVerticalGroup(
            jPanelEmployeeInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmployeeInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEmployeeInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPayPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelEmployeeInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelEmployeeID)
                        .addComponent(jLabelInputID)
                        .addComponent(jLabelInputPayPeriod)))
                .addGap(18, 18, 18)
                .addGroup(jPanelEmployeeInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jLabelInputName))
                .addContainerGap())
        );

        jPanelDeduction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deductions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabelWitholdingTax.setText("Witholding Tax:");

        jTextFieldWitholdingTax.setEditable(false);
        jTextFieldWitholdingTax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldWitholdingTax.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTextFieldSSS.setEditable(false);
        jTextFieldSSS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldSSS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelSSS.setText("SSS:");

        jLabelPhilHealth.setText("PhilHealth:");

        jTextFieldPhilHealth.setEditable(false);
        jTextFieldPhilHealth.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPhilHealth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelPagIBIG.setText("Pag-IBIG:");

        jTextFieldPagIBIG.setEditable(false);
        jTextFieldPagIBIG.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPagIBIG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelTotalDeductions.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabelTotalDeductions.setText("Total Deductions:");

        jTextFieldTotalDeductions.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldTotalDeductions.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanelDeductionLayout = new javax.swing.GroupLayout(jPanelDeduction);
        jPanelDeduction.setLayout(jPanelDeductionLayout);
        jPanelDeductionLayout.setHorizontalGroup(
            jPanelDeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeductionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTotalDeductions)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldTotalDeductions, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelDeductionLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanelDeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDeductionLayout.createSequentialGroup()
                        .addComponent(jLabelPhilHealth)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPhilHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDeductionLayout.createSequentialGroup()
                        .addComponent(jLabelSSS)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDeductionLayout.createSequentialGroup()
                        .addComponent(jLabelWitholdingTax)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldWitholdingTax, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDeductionLayout.createSequentialGroup()
                        .addComponent(jLabelPagIBIG)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPagIBIG, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDeductionLayout.setVerticalGroup(
            jPanelDeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeductionLayout.createSequentialGroup()
                .addGroup(jPanelDeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWitholdingTax)
                    .addComponent(jTextFieldWitholdingTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSSS)
                    .addComponent(jTextFieldSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPhilHealth)
                    .addComponent(jTextFieldPhilHealth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPagIBIG)
                    .addComponent(jTextFieldPagIBIG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanelDeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalDeductions)
                    .addComponent(jTextFieldTotalDeductions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabelLess.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabelLess.setForeground(java.awt.Color.red);
        jLabelLess.setText("Less:");

        jTextFieldNetSalary.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldNetSalary.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabelNetSalary.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabelNetSalary.setText("Net Salary:");

        jButtonRetrun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.png"))); // NOI18N
        jButtonRetrun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetrunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPayrollLayout = new javax.swing.GroupLayout(jPanelPayroll);
        jPanelPayroll.setLayout(jPanelPayrollLayout);
        jPanelPayrollLayout.setHorizontalGroup(
            jPanelPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEarnings, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelEmployeeInformation, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelDeduction, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelPayrollLayout.createSequentialGroup()
                .addComponent(jButtonRetrun)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelPayrollLayout.createSequentialGroup()
                .addComponent(jLabelPayroll)
                .addContainerGap(474, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPayrollLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPayrollLayout.createSequentialGroup()
                        .addComponent(jLabelNetSalary)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNetSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPayrollLayout.createSequentialGroup()
                        .addComponent(jLabelLess)
                        .addGap(130, 130, 130))))
        );
        jPanelPayrollLayout.setVerticalGroup(
            jPanelPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPayrollLayout.createSequentialGroup()
                .addGroup(jPanelPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPayrollLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabelPayroll))
                    .addComponent(jButtonRetrun, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanelEmployeeInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelEarnings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLess)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDeduction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelPayrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNetSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNetSalary))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanelPayroll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRetrunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetrunActionPerformed
        // TODO add your handling code here:
        AttendancePage attendancePage = new AttendancePage(employee);
        attendancePage.setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(PayrollPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayrollPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayrollPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayrollPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayrollPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRetrun;
    private javax.swing.JLabel jLabelBasicSalary1;
    private javax.swing.JLabel jLabelBasicSalary2;
    private javax.swing.JLabel jLabelClothingAllowance;
    private javax.swing.JLabel jLabelEmployeeID;
    private javax.swing.JLabel jLabelGrossSalary;
    private javax.swing.JLabel jLabelHourlyRate;
    private javax.swing.JLabel jLabelHoursWorked;
    private javax.swing.JLabel jLabelInputID;
    private javax.swing.JLabel jLabelInputName;
    private javax.swing.JLabel jLabelInputPayPeriod;
    private javax.swing.JLabel jLabelLess;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNetSalary;
    private javax.swing.JLabel jLabelPagIBIG;
    private javax.swing.JLabel jLabelPayPeriod;
    private javax.swing.JLabel jLabelPayroll;
    private javax.swing.JLabel jLabelPhilHealth;
    private javax.swing.JLabel jLabelPhoneAllowance;
    private javax.swing.JLabel jLabelRiceSubsidy;
    private javax.swing.JLabel jLabelSSS;
    private javax.swing.JLabel jLabelTotalDeductions;
    private javax.swing.JLabel jLabelWitholdingTax;
    private javax.swing.JPanel jPanelDeduction;
    private javax.swing.JPanel jPanelEarnings;
    private javax.swing.JPanel jPanelEmployeeInformation;
    private javax.swing.JPanel jPanelPayroll;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldBasicSalary1;
    private javax.swing.JTextField jTextFieldBasicSalary2;
    private javax.swing.JTextField jTextFieldClothingAllowance;
    private javax.swing.JTextField jTextFieldGrossSalary;
    private javax.swing.JTextField jTextFieldHourlyRate;
    private javax.swing.JTextField jTextFieldHoursWorked;
    private javax.swing.JTextField jTextFieldNetSalary;
    private javax.swing.JTextField jTextFieldPagIBIG;
    private javax.swing.JTextField jTextFieldPhilHealth;
    private javax.swing.JTextField jTextFieldPhoneAllowance;
    private javax.swing.JTextField jTextFieldRiceSubsidy;
    private javax.swing.JTextField jTextFieldSSS;
    private javax.swing.JTextField jTextFieldTotalDeductions;
    private javax.swing.JTextField jTextFieldWitholdingTax;
    // End of variables declaration//GEN-END:variables
}
