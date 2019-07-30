import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Employee Class is Abstract As Developer Manager And Sales Will use for Add the employee
 */
public abstract class Employee implements IEmployee {
    //Empid is Employee Id  
    protected int  empid;
    protected String  name;
    private int age;
    private String designation;
    // Below Variable  all are for Employee salary related Details
    protected float basicsalary;
    protected float HRA;
    protected float incentives;
    protected List<Employee> employee = new LinkedList<>();
    Scanner input=new Scanner(System.in);
    /**
     * Setter method use to Set values of users
     * @no parameters
     */

    public void  setter( ){
        System.out.println("Enter the Employee Name:");
        name=input.next();
        System.out.println("Enter the Employee ID:");
        empid=input.nextInt();
        System.out.println("Enter the Employee Age:");
        age=input.nextInt();
        System.out.println("Enter the Employee Basic Salary:");
        basicsalary=input.nextFloat();

        System.out.println("Enter the Employee Designation:");
        designation=input.next();
    }

    /***
     * To display Employee details
     */
    public void getter(){
        System.out.println("Employee ID:"+empid);
        System.out.println("Employee Name:"+name);
        System.out.println("Employee Age:"+age);
        System.out.println("Employee Designation:"+designation);
        System.out.println("Employee Basic Salary:"+basicsalary);
        System.out.println("Employee HRA:"+HRA);
        System.out.println("Employee Incentives:"+incentives);
    }

    /***
     * Abstract method which will be same for all employee with different calculations
     */
    public abstract void calculateSalary();

}