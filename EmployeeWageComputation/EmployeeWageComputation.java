public class EmployeeWageComputation{

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

    public static void main(String[] args){
        EmployeeWageComputation.welcomeMessage();
        
        EmployeeWageComputation empObj = new EmployeeWageComputation();
        System.out.println(empObj.getAttendance());
    }
}