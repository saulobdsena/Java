import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkLevel level;
    private double baseSalary;
    private Department departament;
    List<HourContract> listContracts = new ArrayList<>();


    
    public Worker(String name, WorkLevel level, double baseSalary, Department departament){
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public WorkLevel getLevel() {
        return level;
    }
    public void setLevel(WorkLevel level) {
        this.level = level;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    public List<HourContract> getListContracts() {
        return listContracts;
    }
    
    public void setDepartmet(Department department){
        this.departament = department;
    }   


    public Department getDepartment(){
        return departament;
    }
    
    
    
    public void addContrat(HourContract contract){
        listContracts.add(contract);
    }

    public void removeContract(HourContract contract){
        listContracts.remove(contract);
    }

    public double income(int year, int mounth){
    
        double sum = baseSalary;
        Calendar c = Calendar.getInstance();
        
        for(HourContract hc : listContracts) {
            c.setTime(hc.getDate());
            int c_year = c.get(Calendar.YEAR);
            int c_mounth = 1 + c.get(Calendar.MONTH);
            if(year == c_year && mounth == c_mounth ){
                sum+= hc.totalValue();
            } 
        }
        
        return sum;
    }
}
