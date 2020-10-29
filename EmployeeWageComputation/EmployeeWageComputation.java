import java.util.Random;
public class EmployeeWageComputation{

    private static final int WAGE_PER_HOUR=20;
    private static final int FULL_TIME=8;
    private static final int PART_TIME=4;
    private static final int MAX_NO_OF_DAYS=20;
    private static final int MAX_WORKING_HOURS=160;
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

    public static int getDailyWage(int perDayWorkHour){
        int workingHourPerDay=perDayWorkHour;
        return workingHourPerDay*WAGE_PER_HOUR;
    }

    public static int getMonthlyWage(){
        return getDailyWage(getWorkingHourPerDay())*MAX_NO_OF_DAYS;
    }


    public static void calculateEmpWage(){

        int totalWorkingHour=0;
        int totalWorkingDays=0;
        int totalDays=0;
        int totalWage=0;
        int perDayWorkHour=0;
        int maxDaysInMonth=EmployeeWageComputation.MAX_DAYS_IN_MONTH;

        while(totalWorkingHour<MAX_WORKING_HOURS && totalWorkingDays<MAX_NO_OF_DAYS && totalDays<maxDaysInMonth){
            totalDays++;
            if(getAttendance().equals("present")){
                totalWorkingDays++;
                perDayWorkHour=getWorkingHourPerDay();
                totalWorkingHour=totalWorkingHour+perDayWorkHour;
                totalWage=totalWage+getDailyWage(perDayWorkHour);
                
                System.out.println("Day-"+totalDays+"=> working hours : "+perDayWorkHour);
            }

        }
        System.out.println("Total Wage: "+totalWage); 
    }

    
    
    public static void main(String[] args){
        EmployeeWageComputation.welcomeMessage();
        
        EmployeeWageComputation.calculateEmpWage();
}

}