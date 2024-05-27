/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author 63909
 */
public class Attendance {
    private String pDate;
	private String timeIn;
	private String timeOut;
	private double hoursInShift, hoursOutShift;
	private double hoursIn, hoursOut, hoursLate, hoursUT, hoursOT, hoursBreak;
	private double minIn, minOut, minLate, minUT, minOT;
	private double minWorked, hoursWorked;
    
    public double CalculateHours(String timeIn, String timeOut) {
    	if (!"".equals(timeIn) && !"".equals(timeOut)) {
    		hoursIn = Integer.parseInt(timeIn.split(":")[0]);
            minIn = Integer.parseInt(timeIn.split(":")[1]);
            hoursOut = Integer.parseInt(timeOut.split(":")[0]);
            minOut = Integer.parseInt(timeOut.split(":")[1]);
        	hoursLate = 0;
        	hoursWorked = 0;
        	
            //Check if Late (Time In 8AM or 13PM)
            if ((hoursIn > 8 &&  hoursIn <= 12) || (hoursIn == 13 && minIn > 10) || (hoursIn == 8 && minIn > 10)) {
                if (hoursIn <= 12 && hoursIn > 8) {
                	hoursInShift = 8;
                    hoursLate = hoursInShift - hoursIn;
                }
                //Convert minLate to hours
                minLate = minIn/60;
                //Sum up the Total hours and min of late
                hoursLate = hoursLate + minLate;
            }
            //Calculate the Total Worked Hours
            hoursWorked = (hoursOut - hoursIn) - (hoursLate);
            
            //Less Lunch Break
        	if (hoursIn >= 13 || hoursOut <=12) {
        		//Without Lunch Break
        	}else {
        		//With Lunch Break
        		hoursWorked = hoursWorked - hoursBreak;
        	}
        	
    	} else {
    		hoursWorked = 0;
    	}
    	
    	return hoursWorked;
    }
    
	public String getpDate() {
		return pDate;
	}
	
	public void setpDate(String pDate) {
		this.pDate = pDate;
	}
	
	public String getTimeIn() {
		return timeIn;
	}
	
	public void setTimeIn(String timeIn) {
		if (timeIn == null) {
			timeIn = "0";
		}
		this.timeIn = timeIn;
	}
	
	public String getTimeOut() {
		return timeOut;
	}
	
	public void setTimeOut(String timeOut) {
		if (timeIn == null) {
			timeIn = "0";
		}
		this.timeOut = timeOut;
	}
	
	public double getHoursInShift() {
		return hoursInShift;
	}
	
	public void setHoursInShift(double hoursInShift) {
		this.hoursInShift = hoursInShift;
	}
	
	public double getHoursOutShift() {
		return hoursOutShift;
	}
	
	public void setHoursOutShift(double hoursOutShift) {
		this.hoursOutShift = hoursOutShift;
	}
	
	public double getHoursIn() {
		return hoursIn;
	}
	
	public void setHoursIn(double hoursIn) {
		this.hoursIn = hoursIn;
	}
	
	public double getHoursOut() {
		return hoursOut;
	}
	
	public void setHoursOut(double hoursOut) {
		this.hoursOut = hoursOut;
	}
	
	public double getHoursLate() {
		return hoursLate;
	}
	
	public void setHoursLate(double hoursLate) {
		this.hoursLate = hoursLate;
	}
	
	public double getHoursUT() {
		return hoursUT;
	}

	public void setHoursUT(double hoursUT) {
		this.hoursUT = hoursUT;
	}

	public double getHoursOT() {
		return hoursOT;
	}

	public void setHoursOT(double hoursOT) {
		this.hoursOT = hoursOT;
	}

	public double getHoursBreak() {
		return hoursBreak;
	}

	public void setHoursBreak(double hoursBreak) {
		this.hoursBreak = hoursBreak;
	}

	public double getMinIn() {
		return minIn;
	}

	public void setMinIn(double minIn) {
		this.minIn = minIn;
	}

	public double getMinOut() {
		return minOut;
	}

	public void setMinOut(double minOut) {
		this.minOut = minOut;
	}

	public double getMinLate() {
		return minLate;
	}

	public void setMinLate(double minLate) {
		this.minLate = minLate;
	}

	public double getMinUT() {
		return minUT;
	}

	public void setMinUT(double minUT) {
		this.minUT = minUT;
	}

	public double getMinOT() {
		return minOT;
	}

	public void setMinOT(double minOT) {
		this.minOT = minOT;
	}

	public double getMinWorked() {
		return minWorked;
	}

	public void setMinWorked(double minWorked) {
		this.minWorked = minWorked;
	}
	
	public double getHoursWorked() {
		return hoursWorked;
	}
	
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
}
