import java.util.ArrayList;
import java.util.HashMap;
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
        empBuilder.getTotalWage("Bridgelab");
        empBuilder.getDailyWage("Bridgelab");
        empBuilder.getTotalWage("MindTree");
        empBuilder.getDailyWage("MindTree");


       
}
}


class CompanyEmpWage{
    private final String companyName;
    private final int wagePerHour;
    private final int maxNoOfworkingDays;
    private final int maxNoOfWorkingHours;
    private int totalWage;

    private ArrayList<Integer> dailyWage;

    public CompanyEmpWage(String companyName, int wagePerHour, int maxNoOfworkingDays, int maxNoOfWorkingHours){
           this.companyName=companyName;
           this.wagePerHour=wagePerHour;
           this.maxNoOfworkingDays=maxNoOfworkingDays;
           this.maxNoOfWorkingHours=maxNoOfWorkingHours;
           dailyWage=new ArrayList<>();
    }
    String getCompanyName(){return this.companyName;}
    int getWagePerHour(){return this.wagePerHour;}
    int getMaxWorkingHours(){return this.maxNoOfWorkingHours;}
    int getMaxWorkingDays(){return this.maxNoOfworkingDays;}
    void setTotalWage(int totalWage){ this.totalWage=totalWage;}
    void setDailyWage(Integer dailyWage){this.dailyWage.add(dailyWage); }
    int getTotalWage(){return this.totalWage;}
    ArrayList getDailyWage(){return this.dailyWage;}

    

}

interface IcomputeEmployeWage{
    public void addCompany(String companyName, int wagePerHour, int maxNoOfworkingDays, int maxNoOfWorkingHours);
    public String getAttendance();
    public void calculateEmpWage();
    public int getWorkingHourPerDay();
    public void getTotalWage(String companyName);
    public void getDailyWage(String companyName);
}

class EmployeeWageBuilder implements IcomputeEmployeWage{
      
    private static final int FULL_TIME=8;
    private static final int PART_TIME=4;
    private static final int MAX_DAYS_IN_MONTH=30;


    private ArrayList<CompanyEmpWage> companyWageList;
    private HashMap<String, CompanyEmpWage> totalWageMap;

    public EmployeeWageBuilder(){
        companyWageList = new ArrayList<CompanyEmpWage>();
        totalWageMap = new HashMap<>();
    }
    @Override
    public void addCompany(String companyName, int wagePerHour, int maxNoOfworkingDays, int maxNoOfWorkingHours){
        companyWageList.add(new CompanyEmpWage(companyName, wagePerHour, maxNoOfworkingDays, maxNoOfWorkingHours));
    }
    @Override
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
        for(CompanyEmpWage company : companyWageList)
        {
        int totalWorkingHour=0;
        int totalWorkingDays=0;
        int totalDays=0;
        int totalWage=0;
        int perDayWorkHour=0;
        int dailyWage=0;

        while(totalWorkingHour<company.getMaxWorkingHours() && totalWorkingDays<company.getMaxWorkingDays() && totalDays<MAX_DAYS_IN_MONTH){
            totalDays++;
            if(getAttendance().equals("present")){
                totalWorkingDays++;
                perDayWorkHour=getWorkingHourPerDay();
                totalWorkingHour=totalWorkingHour+perDayWorkHour;
                dailyWage=getDailyWage(perDayWorkHour, company.getWagePerHour());
                totalWage=totalWage+dailyWage;
                company.setDailyWage(dailyWage);
                
            }

        }
        company.setTotalWage(totalWage);
        totalWageMap.put(company.getCompanyName(), company);
    }    
}
@Override
public void getTotalWage(String companyName){
    System.out.println("Total Wage for "+companyName+" is "+totalWageMap.get(companyName).getTotalWage());
}

@Override
public void getDailyWage(String companyName){
    System.out.println("Daily Wage for "+companyName+ ": ");
    System.out.println(totalWageMap.get(companyName).getDailyWage());
}

}

