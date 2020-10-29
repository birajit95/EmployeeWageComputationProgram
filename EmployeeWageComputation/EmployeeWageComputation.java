import java.util.Random;
public class EmployeeWageComputation{

    private static final int FULL_TIME=8;
    private static final int PART_TIME=4;
    private static final int MAX_DAYS_IN_MONTH=30;
    
    public static void welcomeMessage(){
        System.out.println("Welcome to Employee Wage Computation Program");
    }

    public static String getAttendance(){
        if(Math.random()*10>=3){
            return "present";
        }
        else{
            return "absent";
        }
    }

    public static int getWorkingHourPerDay(){
        int workingHourPerDay;
        Random random = new Random();
        int status = random.nextInt(2);
        switch(status){
            case 0:
                  workingHourPerDay=FULL_TIME;
                  break;
            case 1:
                  workingHourPerDay=PART_TIME;
                  break;
            default:
                   workingHourPerDay=0;
                   break;           
           }
           return workingHourPerDay;
    }

    public static int getDailyWage(int perDayWorkHour, int wagePerHour){
        int workingHourPerDay=perDayWorkHour;
        return workingHourPerDay*wagePerHour;
    }

   
    public static void calculateEmpWage(String company, int wagePerHour, int maxNoOfworkingDays, int maxNoOfWorkingHours ){

        int totalWorkingHour=0;
        int totalWorkingDays=0;
        int totalDays=0;
        int totalWage=0;
        int perDayWorkHour=0;

        while(totalWorkingHour<maxNoOfWorkingHours && totalWorkingDays<maxNoOfworkingDays && totalDays<MAX_DAYS_IN_MONTH){
            totalDays++;
            if(getAttendance().equals("present")){
                totalWorkingDays++;
                perDayWorkHour=getWorkingHourPerDay();
                totalWorkingHour=totalWorkingHour+perDayWorkHour;
                totalWage=totalWage+getDailyWage(perDayWorkHour, wagePerHour);
                
            }

        }
        System.out.println("Company Name : "+company);
        System.out.println("Total Wage : "+totalWage +" and Wage per hour : "+wagePerHour); 

    }

    
    
    public static void main(String[] args){
        EmployeeWageComputation.welcomeMessage();
        
        EmployeeWageComputation.calculateEmpWage("Bridgelab",50,24,192);
        EmployeeWageComputation.calculateEmpWage("Quantifier",100,20,160);
        EmployeeWageComputation.calculateEmpWage("MindTree",150,24,192);


}

}