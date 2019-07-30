import java.util.Scanner;
public class Sales extends Employee{
    /***
     * Use to add Employee in sales Department
     * @param employee1
     */
    @Override
    public void addEmployee(Employee employee1) {
        Scanner input =new Scanner(System.in);
        setter();
        System.out.println("Enter the Employee HRA:");
        HRA=input.nextFloat();
        System.out.println("Enter the Employee Incentives:");
        incentives=input.nextFloat();
        employee.add((Sales) employee1);
    }
    /***
     * Use to Remove Employee form Sale Department  by Employee if
     * @param employee_id
     */
    @Override
    public void deleteEmployee(int employee_id) {
        employee.remove(employee_id);
    }

    /***
     * Use to Calculate total salary for sales department with Employee count
     */
    @Override
    public void calculateSalary() {
        float result=0;
        for(Employee e:employee ){
            result += e.basicsalary+e.HRA+e.incentives;
        }
        System.out.println("Total Salary of Developers Department:"+result);
    }

}