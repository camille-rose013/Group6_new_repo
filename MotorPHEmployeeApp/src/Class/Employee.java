/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.io.*;
import java.util.*;

/**
 *
 * @author 63909
 */
public final class Employee {
    private String[] information;    
    
    public Employee(String[] information) {
        this.information = information;
        setEmployeeID(information[0]);
        setLastName(information[1]);
        setFirstName(information[2]);
        setBirthday(information[3]);
        setAddress(information[4]);
        setPhoneNumber(information[5]);
        setSSSNumber(information[6]);
        setPhilhealthNumber(information[7]);
        setTinNumber(information[8]);
        setPagibigNumber(information[9]);
        setEmploymentStatus(information[10]);
        setPosition(information[11]);
        setImmediateSupervisor(information[12]);
        setBasicSalary(Double.parseDouble(information[13].replace(",", "")));
        setRiceSubsidy(Double.parseDouble(information[14].replace(",", "")));
        setPhoneAllowance(Double.parseDouble(information[15].replace(",", "")));
        setClothingAllowance(Double.parseDouble(information[16].replace(",", "")));
        setGrossSemiMonthlyRate(Double.parseDouble(information[17].replace(",", "")));
        setHourlyRate(Double.parseDouble(information[18]));
    }
    
    public Employee() {
        
    }
    
    public String[] getInformation() {
        return information;
    }
    public void setInformation(String[] information) {
        this.information = information;
    } 
    private double totalHoursWorked, totalAllowance, grossSalary, netSalary;
    private double sssContri, philhealthContri, pagibigContri;
    private double totalDeductions, withHTax;
    private String employeeID;
    private String payPeriod;

    public String getPayPeriod() {
        return payPeriod;
    }
    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    
    private ArrayList<String[]> dataFile;
    private HashMap<String,String[]> employeeMap;
    
    //Personal Information
    private String lastName, firstName;
    private String birthday, address, phoneNumber;

    //Goverment Information
    private String sssNumber, philhealthNumber, tinNumber, pagibigNumber;

    //Employement Information
    private String employmentStatus, position, immediateSupervisor;

    //Rates and Allowances
    private double basicSalary;
    private double riceSubsidy, phoneAllowance, clothingAllowance;
    private double grossSemiMonthlyRate, hourlyRate;
	
    //getters and setters
    public String getLastName() {
            return lastName;
    }
    public void setLastName(String lastName) {
            this.lastName = lastName;
    }

    public String getFirstName() {
            return firstName;
    }
    public void setFirstName(String firstName) {
            this.firstName = firstName;
    }

    public String getBirthday() {
            return birthday;
    }
    public void setBirthday(String birthday) {
            this.birthday = birthday;
    }

    public String getAddress() {
            return address;
    }
    public void setAddress(String address) {
            this.address = address;
    }
  
    public String getPhoneNumber() {
            return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
    }

    public String getSSSNumber() {
            return sssNumber;
    }
    public void setSSSNumber(String sssNumber) {
            this.sssNumber = sssNumber;
    }

    public String getPhilhealthNumber() {
            return philhealthNumber;
    }
    public void setPhilhealthNumber(String philhealthNumber) {
            this.philhealthNumber = philhealthNumber;
    }

    public String getTinNumber() {
            return tinNumber;
    }
    public void setTinNumber(String tinNumber) {
            this.tinNumber = tinNumber;
    }

    public String getPagibigNumber() {
            return pagibigNumber;
    }
    public void setPagibigNumber(String pagibigNumber) {
            this.pagibigNumber = pagibigNumber;
    }

    public String getEmploymentStatus() {
            return employmentStatus;
    }
    public void setEmploymentStatus(String employmentStatus) {
            this.employmentStatus = employmentStatus;
    }

    public String getPosition() {
            return position;
    }
    public void setPosition(String position) {
            this.position = position;
    }

    public String getImmediateSupervisor() {
            return immediateSupervisor;
    }
    public void setImmediateSupervisor(String immediateSupervisor) {
            this.immediateSupervisor = immediateSupervisor;
    }

    public double getBasicSalary() {
            return basicSalary;
    }
    public void setBasicSalary(double basicSalary) {
            this.basicSalary = basicSalary;
    }

    public double getRiceSubsidy() {
            return riceSubsidy;
    }
    public void setRiceSubsidy(double riceSubsidy) {
            this.riceSubsidy = riceSubsidy;
    }

    public double getPhoneAllowance() {
            return phoneAllowance;
    }
    public void setPhoneAllowance(double phoneAllowance) {
            this.phoneAllowance = phoneAllowance;
    }

    public double getClothingAllowance() {
            return clothingAllowance;
    }
    public void setClothingAllowance(double clothingAllowance) {
            this.clothingAllowance = clothingAllowance;
    }

    public double getGrossSemiMonthlyRate() {
            return grossSemiMonthlyRate;
    }
    public void setGrossSemiMonthlyRate(double grossSemiMonthlyRate) {
            this.grossSemiMonthlyRate = grossSemiMonthlyRate;
    }

    public double getHourlyRate() {
            return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
            this.hourlyRate = hourlyRate;
    }

    public String getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public double getTotalHoursWorked() {
        return totalHoursWorked;
    }
    public void setTotalHoursWorked(double totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getTotalAllowance() {
        return totalAllowance;
    }
    public void setTotalAllowance(double totalAllowance) {
        this.totalAllowance = totalAllowance;
    }

    public double getGrossSalary() {
        return grossSalary;
    }
    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public double getSssContri() {
        return sssContri;
    }

    public void setSssContri(double sssContri) {
        this.sssContri = sssContri;
    }

    public double getPhilhealthContri() {
        return philhealthContri;
    }

    public void setPhilhealthContri(double philhealthContri) {
        this.philhealthContri = philhealthContri;
    }

    public double getPagibigContri() {
        return pagibigContri;
    }

    public void setPagibigContri(double pagibigContri) {
        this.pagibigContri = pagibigContri;
    }

    public double getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public double getWithHTax() {
        return withHTax;
    }

    public void setWithHTax(double withHTax) {
        this.withHTax = withHTax;
    }        
            
    public void setEmployeerMap(ArrayList<String[]> dataFile) {
        this.dataFile = dataFile;
        this.employeeMap = new HashMap<String, String[]>();
        
        for (String[] i : this.dataFile){
            this.employeeMap.put(i[0],i);
        }        
        
    }        
    public HashMap<String, String[]> getEmployeeMap() {
        return employeeMap;
    }  

}
