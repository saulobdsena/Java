import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException{

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter departament´s name: ");
        String department = sc.nextLine();

        System.out.println("Enter worker data:");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("WorkLevel: ");
        WorkLevel level = WorkLevel.valueOf(sc.nextLine());

        System.out.print("Base Salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(name, level, baseSalary, new Department(department));


        System.out.print("How many contracts to this worker: ");
        int n = sc.nextInt();


        for(int i = 0; i < n; i++){
            System.out.println("Enter contract #" + (i + 1) + " data:");
		
            System.out.print("Date (DD/MM/YYYY): ");		
            Date contractDate = sdf.parse(sc.next());

            System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContrat(contract);

        }

        System.out.print("Enter mounth and year to calculate income (MM/YYYY) ");
        String mounthAndYear = sc.next();
        int mounth = Integer.parseInt(mounthAndYear.substring(0, 2));
        int year = Integer.parseInt(mounthAndYear.substring(3, 7));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + mounthAndYear + " : " + String.format("%.2f", worker.income(year, mounth)));

        sc.close();
    }   
}
