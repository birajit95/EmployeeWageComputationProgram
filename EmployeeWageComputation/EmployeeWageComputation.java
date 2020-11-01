import java.util.Random;
public class EmployeeWageComputation{

    
    
    public static void welcomeMessage(){
        System.out.println("Welcome to Employee Wage Computation Program");
    }
    
    public static void main(String[] args){
        EmployeeWageComputation.welcomeMessage();
        EmployeeWageBuilder empBuilder = new EmployeeWageBuilder();
        empBuilder.addCompany("TCS",100,20,160);
        empBuilder.addCompany("MindTree",150,24,192);
        empBuilder.addCompany("Bridgelab",200,20,160);
        empBuilder.calculateEmpWage();
       
}
}


class CompanyEmpWage{
    private final String companyName;
    private final int wagePerHour;
    private final int maxNoOfworkingDays;
    private final int maxNoOfWorkingHours;

    public CompanyEmpWage(String companyName, int wagePerHour, int maxNoOfworkingDays, int maxNoOfWorkingHours){
           this.companyName=companyName;
           this.wagePerHour=wagePerHour;
           this.maxNoOfworkingDays=maxNoOfworkingDays;
           this.maxNoOfWorkingHours=maxNoOfWorkingHours;
    }
    String getCompanyName(){return this.companyName;}
    int getWagePerHour(){return this.wagePerHour;}
    int getMaxWorkingHours(){return this.maxNoOfWorkingHours;}
    int getMaxWorkingDays(){return this.maxNoOfworkingDays;}

}

class EmployeeWageBuilder{
      
    private static final int FULL_TIME=8;
    private static final int PART_TIME=4;
    private static final int MAX_DAYS_IN_MONTH=30;

    private CompanyEmpWage companyWageArray[];
    static int companyCount=0;

    public EmployeeWageBuilder(){
        companyWageArray=new CompanyEmpWage[5];
    }

    public void addCompany(String companyName, int wagePerHour, int maxNoOfworkingDays, int maxNoOfWorkingHours){
        companyWageArray[companyCount++]=new CompanyEmpWage(companyName, wagePerHour, maxNoOfworkingDays, maxNoOfWorkingHours);
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
        for (int i=0; i<companyCount;i++)
        {
        int totalWorkingHour=0;
        int totalWorkingDays=0;
        int totalDays=0;
        int totalWage=0;
        int perDayWorkHour=0;

        while(totalWorkingHour<companyWageArray[i].getMaxWorkingHours() && totalWorkingDays<companyWageArray[i].getMaxWorkingDays() && totalDays<MAX_DAYS_IN_MONTH){
            totalDays++;
            if(getAttendance().equals("present")){
                totalWorkingDays++;
                perDayWorkHour=getWorkingHourPerDay();
                totalWorkingHour=totalWorkingHour+perDayWorkHour;
                totalWage=totalWage+getDailyWage(perDayWorkHour, companyWageArray[i].getWagePerHour());
                
            }

        }
    System.out.println(companyWageArray[i].getCompanyName()+" : "+String.valueOf(totalWage));   

    }

    
}
}

