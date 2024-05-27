/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.*;

/**
 *
 * @author 63909
 */
public class Salary {
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSemiMonthlyRate;
    private double hourlyRate;
    
    private double gross, net;
    private double totalAllowance, totalDeductions;
    private double sss, philhealth, pagibig, withHoldingTax;

    // getters and setters
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
        System.out.println();
    }

    public double CalculateGross(double hoursWorked, double hourlyRate, double totalAllowance) {
		gross = (hoursWorked * hourlyRate) + totalAllowance;
		return gross;
	}
	
	public double CalculateTotalAllowance(double rice, double phone, double clothing) {
		totalAllowance = (rice + phone + clothing) / 2;
		return totalAllowance;
	}	
	
	public double CalculateSSS(double gross) {
		TreeMap<Double, Double> sssChart = new TreeMap<Double, Double>();
		sssChart.put(3249.00, 135.00);
		sssChart.put(3250.00, 157.50);
		sssChart.put(3750.00, 180.00);
		sssChart.put(4250.00, 202.50);
		sssChart.put(4750.00, 225.00);
		sssChart.put(5250.00, 247.50);
		sssChart.put(5750.00, 270.00);
		sssChart.put(6250.00, 292.50);
		sssChart.put(6750.00,315.00);
		sssChart.put(7250.00, 337.50);
		sssChart.put(7750.00, 360.00);
		sssChart.put(8250.00, 382.50);
		sssChart.put(8750.00, 405.00);
		sssChart.put(9250.00, 427.50);
		sssChart.put(9750.00, 450.00);
		sssChart.put(10250.00, 472.50);
		sssChart.put(10750.00, 495.00);
		sssChart.put(11250.00, 517.50);
		sssChart.put(11750.00, 540.00);
		sssChart.put(12250.00, 562.50);
		sssChart.put(12750.00, 585.00);
		sssChart.put(13250.00, 607.50);
		sssChart.put(13750.00, 630.00);
		sssChart.put(14250.00, 652.50);
		sssChart.put(14750.00, 675.00);
		sssChart.put(15250.00, 697.50);
		sssChart.put(15750.00, 720.00);
		sssChart.put(16250.00, 742.50);
		sssChart.put(16750.00, 765.00);
		sssChart.put(17250.00, 787.50);
		sssChart.put(17750.00, 810.00);
		sssChart.put(18250.00, 832.50);
		sssChart.put(18750.00, 855.00);
		sssChart.put(19250.00, 877.50);
		sssChart.put(19750.00, 900.00);
		sssChart.put(20250.00, 922.50);
		sssChart.put(20750.00, 945.00);
		sssChart.put(21250.00, 967.50);
		sssChart.put(21750.00, 990.00);
		sssChart.put(22250.00, 1012.50);
		sssChart.put(22750.00, 1035.00);
		sssChart.put(23250.00, 1057.50);
		sssChart.put(23750.00, 1080.00);
		sssChart.put(24250.00, 1102.50);
		sssChart.put(24750.00, 1125.00);

		sss =  sssChart.floorEntry(gross).getValue();
		return sss;
	}
	
	public double CalculatePhilHealth(double gross) {
		philhealth = (gross * .03)*.5;
		return philhealth;
	}
	
	public double CalculatePagIbig(double gross) {
		TreeMap<Double, Double> pagibigChart = new TreeMap<>();
		pagibigChart.put(1500.00, .01);
		pagibigChart.put(1501.00, .02);
		
		pagibig = gross * pagibigChart.floorEntry(gross).getValue();
		
		if (pagibig >= 100) {
			pagibig = 100;
		}
		
		return pagibig;
	}
	
	public double CalculateTotalDeductions(double sssContri, double philhealthContri, double pagibigContri) {
		totalDeductions = sssContri + philhealthContri + pagibigContri;
		return totalDeductions;
	}
	
	public double CalculateWithHoldingTax(double gross, double totalDeductions) {
		Double[] n20832 = {1.00, 0.00, 0.00};
		Double[] n20833 = {0.20, 20833.00, 0.00};
		Double[] n33333  = {0.25, 33333.00, 2500.00};
		Double[] n66667 = {0.30, 66667.00, 10833.00};
		Double[] n166667 = {0.32, 166667.00, 40833.33};
		Double[] n666667 = {0.35, 666667.00, 200833.33};
		
		TreeMap<Double, Double[]> withHTaxChart = new TreeMap<>();
		withHTaxChart.put(20832.00, n20832);
		withHTaxChart.put(20833.00, n20833);
		withHTaxChart.put(33333.00, n33333);
		withHTaxChart.put(66667.00, n66667);
		withHTaxChart.put(166667.00, n166667);
		withHTaxChart.put(666667.00, n666667);
		
		Double [] taxValue = withHTaxChart.floorEntry(gross).getValue();
		
		withHoldingTax = (((gross - totalDeductions) - taxValue[1])* taxValue[0]) + taxValue[2];
		
		return withHoldingTax;
	}
	
	public double CalculateNet(double gross, double totalDeductions, double withHtax) {
		net = gross - (totalDeductions + withHtax);
		return net;
	}
}



