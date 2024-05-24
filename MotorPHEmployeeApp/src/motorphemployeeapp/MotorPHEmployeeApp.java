/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package motorphemployeeapp;
import java.util.*;
import java.io.*;
/**
 *
 * @author 63909
 */
    class Employee extends UserAccount {
            private double totalHoursWorked, totalAllowance, grossSalary, netSalary;
            private double sssContri, philhealthContri, pagibigContri;
            private double totalDeductions, withHTax;
            
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
    }
    
    abstract class Information {
        private String firstName;
        private String lastname;
        
        // getters and setters
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        
        public String getLastname() {
            return lastname;
        }
        public void setLastname(String lastname) {
            this.lastname = lastname;
        }             
    }
    
    class Personal extends Information {
        private String brithday;
        private String address;
        private int phoneNumber;
        
        // getters and setters
        public String getBrithday() {
            return brithday;
        }
        public void setBrithday(String brithday) {
            this.brithday = brithday;
        }

        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }

        public int getPhoneNumber() {
            return phoneNumber;
        }
        public void setPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
    
    class Government extends Information {
        private String sssNumber;
        private String philhealthNumber;
        private String tinNumber;
        private String pagibigNumber;

        // getters and setters
        public String getSssNumber() {
            return sssNumber;
        }
        public void setSssNumber(String sssNumber) {
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
    }

    class Job extends Information {
        private String employeeID;
        private String employmentStatus;
        private String position;
        private String immediateSupervisor;

        // getters and setters
        public String getEmployeeID() {
            return employeeID;
        }
        public void setEmployeeID(String employeeID) {
            this.employeeID = employeeID;
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
    }
    
    class Salary {
        private double basicSalary;
        private double riceSubsidy;
        private double phoneAllowance;
        private double clothingAllowance;
        private double grossSemiMonthlyRate;
        private double hourlyRate;

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
        }
    }

    class UserAccount {
        private String userID;
        private String username;
        private String password;
        private ArrayList<String> dataFile;
        private boolean authenticationResult;
        //private UserRole role;
        private Employee employeeInfo;
        
        
        // getters and setters
        public String getUserID() {
            return userID;
        }
        public void setUserID(String userID) {
            this.userID = userID;
        }        
        
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }

        public Employee getEmployeeInfo() {
            return employeeInfo;
        }
        public void setEmployeeInfo(Employee employeeInfo) {
            this.employeeInfo = employeeInfo;
        }      
        
        // getters and setters
        private HashMap<String,String[]> setUserList;      
               
        public void setUserList(ArrayList<String> dataFile) {
            this.dataFile = dataFile;
            this.setUserList = new HashMap<String, String[]>();
            
            for (String i : this.dataFile){
                String[] row = i.split(",");
                this.setUserList.put(row[2],row);
            }                    
        }
        
        protected HashMap<String, String[]> getEmployeesCollection() {
            return setUserList;
        }
        
        public HashMap<String, String[]> getemployeeProfile() {
            return setUserList;
        }
                                
        public boolean userAuthenticate(String username, String password) {
            this.username = username;
            this.password = password;           
                        
            if(this.setUserList.containsKey(this.username)){
                if(this.setUserList.get(this.username)[3].equals(this.password)){
                    authenticationResult = true;
                } else {
                    authenticationResult = false;
                }
            } else {
                authenticationResult = false;
            }
            
            return authenticationResult;
        }          
    }

    class File {
        private String fileName;
        private String filePath;
        private ArrayList<String> dataFile = null;
        BufferedReader reader = null;

        public String getFileName() {
            return fileName;
        }
        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFilePath() {
            return filePath;
        }
        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }
        
        public ArrayList<String> readFile(String filePath){
            this.filePath = filePath ;            
            dataFile = new ArrayList<String>();
            String line = "";
            
            try {
                reader = new BufferedReader(new FileReader(this.filePath));
                
                while((line = reader.readLine()) != null){
                    //dataFile.add(line);
                    dataFile.add(line);
                }
            }catch(Exception e) {
                e.printStackTrace();
            }finally {
                try {
                   reader.close(); 
                } catch (IOException e) {
                    e.printStackTrace();
                }    
            }            
            
            return dataFile;
        }        
    }


public class MotorPHEmployeeApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String username,password;
        ArrayList<String> userData = new ArrayList<>();
        
        File userFile = new File();
        userFile.setFilePath("src/MotorPH Employee Data - User Details.csv");
        userData = userFile.readFile("src/MotorPH Employee Data - User Details.csv");
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Username: ");
        username = scan.next();
        
        System.out.println("Password: ");
        password = scan.next();
        
        UserAccount userAccount = new UserAccount();
        userAccount.setUserList(userData);
        userAccount.userAuthenticate(username, password);
        
        File employeeFile = new File();
        userFile.setFilePath("src/MotorPH Employee Data - Employee Details.csv");
        userData = userFile.readFile("src/MotorPH Employee Data - Employee Details.csv");
        
        Employee employee = new Employee();
       
        scan.close();
    }
    
}
