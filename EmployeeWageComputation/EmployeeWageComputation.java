import java.util.Random;
public class EmployeeWageComputation{

    private static final int FULL_TIME=8;
    private static final int PART_TIME=4;
    private static final int MAX_DAYS_IN_MONTH=30;
    private final String companyName;
    private final int wagePerHour;
    private final int maxNoOfworkingDays;
    private final int maxNoOfWorkingHours;
    
    static int companyCount=0;
    static String EmpWageList[] = new String[5];

    public EmployeeWageComputation(String companyName, int wagePerHour, int maxNoOfworkingDays, int maxNoOfWorkingHours){
           this.companyName=companyName;
           this.wagePerHour=wagePerHour;
           this.maxNoOfworkingDays=maxNoOfworkingDays;
           this.maxNoOfWorkingHours=maxNoOfWorkingHours;
    }


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

    public int getDailyWage(int perDayWorkHour, int wagePerHour){
        int workingHourPerDay=perDayWorkHour;
        return workingHourPerDay*wagePerHour;
    }

   
    public void calculateEmpWage( ){

        int totalWorkingHour=0;
        int totalWorkingDays=0;
        int totalDays=0;
        int totalWage=0;
        int perDayWorkHour=0;

        while(totalWorkingHour<this.maxNoOfWorkingHours && totalWorkingDays<this.maxNoOfworkingDays && totalDays<MAX_DAYS_IN_MONTH){
            totalDays++;
            if(getAttendance().equals("present")){
                totalWorkingDays++;
                perDayWorkHour=getWorkingHourPerDay();
                totalWorkingHour=totalWorkingHour+perDayWorkHour;
                totalWage=totalWage+getDailyWage(perDayWorkHour, wagePerHour);
                
            }

        }

        EmpWageList[companyCount++]=this.companyName+":"+String.valueOf(totalWage);

    }

    public static void getComapnyWageList(){
        for(int i=0; i<companyCount; i++){
            
                System.out.println(EmpWageList[i]);
            }
        
    }
    
    
    
    public static void main(String[] args){
        EmployeeWageComputation.welcomeMessage();
        EmployeeWageComputation BridgeLab=new EmployeeWageComputation("Bridgelab",50,24,192);
        EmployeeWageComputation Quantifier=new EmployeeWageComputation("Quantifier",100,20,160);
        EmployeeWageComputation MindTree=new EmployeeWageComputation("MindTree",150,24,192);
        BridgeLab.calculateEmpWage();
        Quantifier.calculateEmpWage();
        MindTree.calculateEmpWage();
        EmployeeWageComputation.getComapnyWageList();


}

}