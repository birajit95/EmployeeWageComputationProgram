public class EmployeeWageComputation{
    

    private final int WAGE_PER_HOUR=20;
    private final int FULL_TIME=8;

    public static void welcomeMessage(){
        System.out.println("Welcome to Employee Wage Computation Program");
    }

    public String getAttendance(){
        if(Math.random()*10>=3){
            return "present";
        }
        else{
            return "absent";
        }
    }

    public int getDailyWage(){
        int workingHourPerDay=FULL_TIME;
        return workingHourPerDay*this.WAGE_PER_HOUR;
    }

    public static void main(String[] args){
        EmployeeWageComputation.welcomeMessage();
        
        EmployeeWageComputation empObj = new EmployeeWageComputation();
        System.out.println(empObj.getAttendance());
        System.out.println(empObj.getDailyWage());

    }
}