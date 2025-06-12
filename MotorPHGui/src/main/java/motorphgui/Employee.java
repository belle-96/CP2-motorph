package motorphgui;

public class Employee {
    private String id;
    private String fullName;
    private String birthday;
    private String address;
    private String phone;
    private String sss;
    private String pagibig;
    private String tin;
    private String philhealth;
    private String employmentStatus;
    private String position;
    private String immediateSupervisor;
    private String basicSalary;
    private String riceSubsidy;
    private String phoneAllowance;
    private String clothingAllowance;
    private String grossSemiMonthly;
    private String hourlyRate;
    private String proratedAllowance;

    // Constructor that takes a CSV row as String array
public Employee(String[] data) {
    this.id = data[0];
    this.fullName = data[1];
    this.birthday = data[2];
    this.address = data[3];
    this.phone = data[4];
    this.sss = data[5];
    this.philhealth = data[6];
    this.tin = data[7];
    this.pagibig = data[8];
    this.employmentStatus = data[9];
    this.position = data[10];
    this.immediateSupervisor = data[11];
    this.basicSalary = data[12];
    this.riceSubsidy = data[13];
    this.phoneAllowance = data[14];
    this.clothingAllowance = data[15];
    this.grossSemiMonthly = data[16];
    this.hourlyRate = data[17];

    try {
        double rice = Double.parseDouble(data[13]);
        double phone = Double.parseDouble(data[14]);
        double clothing = Double.parseDouble(data[15]);
        this.proratedAllowance = String.format("%.2f", rice + phone + clothing);
    } catch (NumberFormatException e) {
        this.proratedAllowance = "0.00";
    }
}

    // Getters 
    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getBirthday() { return birthday; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getSSS() { return sss; }
    public String getPagibig() { return pagibig; }
    public String getTin() { return tin; }
    public String getPhilhealth() { return philhealth; }
    public String getEmploymentStatus() { return employmentStatus; }
    public String getPosition() { return position; }
    public String getImmediateSupervisor() { return immediateSupervisor; }
    public String getBasicSalary() { return basicSalary; }
    public String getRiceSubsidy() { return riceSubsidy; }
    public String getPhoneAllowance() { return phoneAllowance; }
    public String getClothingAllowance() { return clothingAllowance; }
    public String getGrossSemiMonthly() { return grossSemiMonthly; }
    public String getHourlyRate() { return hourlyRate; }
    public String getProratedAllowance() { return proratedAllowance; }
}
