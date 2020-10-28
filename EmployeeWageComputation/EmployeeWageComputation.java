import java.util.Random;
public class EmployeeWageComputation{

    private final int WAGE_PER_HOUR=20;
    private final int FULL_TIME=8;
    private final int PART_TIME=4;
    private final int MAX_NO_OF_DAYS=20;
    private final int MAX_WORKING_HOURS=160;
    private static final int MAX_DAYS_IN_MONTH=30;
    
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

    public int getWorkingHourPerDay(){
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

    public int getDailyWage(int perDayWorkHour){
        int workingHourPerDay=perDayWorkHour;
        return workingHourPerDay*this.WAGE_PER_HOUR;
    }

    public int getMonthlyWage(){
        return this.getDailyWage(this.getWorkingHourPerDay())*this.MAX_NO_OF_DAYS;
    }
    
    public static void main(String[] args){
        EmployeeWageComputation.welcomeMessage();
        
        EmployeeWageComputation empObj = new EmployeeWageComputation();
        
        int totalWorkingHour=0;
        int totalWorkingDays=0;
        int totalDays=0;
        int totalWage=0;
        int perDayWorkHour=0;
        int maxDaysInMonth=EmployeeWageComputation.MAX_DAYS_IN_MONTH;

        while(totalWorkingHour<empObj.MAX_WORKING_HOURS && totalWorkingDays<empObj.MAX_NO_OF_DAYS && totalDays<maxDaysInMonth){
            totalDays++;
            if(empObj.getAttendance().equals("present")){
                totalWorkingDays++;
                perDayWorkHour=empObj.getWorkingHourPerDay();
                totalWorkingHour=totalWorkingHour+perDayWorkHour;
                totalWage=totalWage+empObj.getDailyWage(perDayWorkHour);
                
                System.out.println("Day-"+totalDays+"=> working hours : "+perDayWorkHour);
            }

        }
        System.out.println("Total Wage: "+totalWage); 
    }
}