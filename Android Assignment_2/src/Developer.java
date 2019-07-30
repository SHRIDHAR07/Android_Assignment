public class Developer extends Employee {
    /***
     * Use to Add Employee in the employee List
     * @param employee1
     */
    @Override
    public void addEmployee(Employee employee1) {
        setter();
        employee.add(employee1);
    }

    /***
     * Use to Remove the Employee By employee id from the list
     * @param employee_id
     */
    @Override
    public void deleteEmployee(int employee_id) {
        employee.remove("employee_id");
    }

    /***
     * Use to calculate Salary For the Developers
     */
    @Override
    public void calculateSalary() {
        float result=0;
        int count=0;
        for(Employee e:employee ){
            result += e.basicsalary;
            count++;
        }
        System.out.println("Total Employee in Developers"+count);
        System.out.println("Total Salary of Developers Department:\t"+result);
    }

}
