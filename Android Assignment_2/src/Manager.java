import java.util.Scanner;

public class Manager extends Employee implements IEmployee{
    /***
     * Use To add Employee in manager
     * @param employee1
     */
    @Override
    public void addEmployee(Employee employee1) {
        Scanner input =new Scanner(System.in);
        setter();
        System.out.println("Enter the Employee HRA:");
        HRA=input.nextFloat();
        employee.add(employee1);
    }
    /***
     * Remove manager by employee id
     * @param employee_id
     */
    @Override
    public void deleteEmployee(int employee_id) {
        employee.remove(employee_id);
    }
    /***
     * Calculate Total Salary of all mangers and the total managers
     */
    @Override
    public void calculateSalary() {
        float result=0;
        for(Employee e:employee ){
            result += e.basicsalary+e.HRA;
        }
        System.out.println("Total Salary of Developers Department:"+result);
    }

}