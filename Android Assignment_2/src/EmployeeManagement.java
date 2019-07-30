import java.util.*;

/**
 * This is main method
 */
public class EmployeeManagement{
    public static void main(String args[]){
        Employee developer=new Developer();
        Employee manager=new Manager();
        Employee sales = new Sales();
        // Map To Identify Unique Employee i.e Mangers, Developers and Sales
        Map<Integer,List<Employee>> map=new HashMap<>();
        Scanner input=new Scanner(System.in);
        //choice use to Select which Employee you want to Add
        int choice;
        // no is to iterator use to iterate in loops
        int no;
        // To give exit options
        char answer;
        // to know how many employee u want to enter
        int no_of_employee;
        do {
            System.out.println("Enter Which Employee you want to add \n1)Developer \n2)Manager \n3)Sales \n4)All Employee Details ");
            System.out.println("5)Total Expenditure on Salary \n6)Remove Employee");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("**********How many Developers you want to add************** ");
                    no_of_employee = input.nextInt();
                    for (no = 1; no <= no_of_employee; no++) {
                        developer.addEmployee(developer);
                        map.put(1001,developer.employee);
                    }
                    break;
                case 2:
                    System.out.println("**********How many Manager you want to add************** ");
                    no_of_employee = input.nextInt();
                    for (no = 1; no <= no_of_employee; no++) {
                        manager.addEmployee(manager);
                        map.put(1002,manager.employee);
                    }
                    break;
                case 3:
                    System.out.println("**********How many Sales Person  you want to add************** ");
                    no_of_employee = input.nextInt();
                    for (no = 1; no <= no_of_employee; no++) {
                        sales.addEmployee(sales);
                        map.put(1003,sales.employee);
                        sales.employee.add(sales);
                    }
                    break;

                case 4:
                    System.out.println("Enter the key Value :");
                    int value=input.nextInt();
                    switch(value){
                        case 1001:
                            //For Display Developers in Employee
                            for (Employee b :  developer.employee) {
                                System.out.println("***************Employee Details*****************\n ");
                                //Fetching Value Form the Map
                                for (Map.Entry<Integer, List<Employee>> entry : map.entrySet()) {
                                    Integer key = entry.getKey();
                                    if(key==value) {
                                        for (Employee e :developer.employee) {
                                            System.out.println("Key = " + key);
                                            e.getter();
                                        }
                                    }else{
                                        break;
                                    }
                                }
                                developer.calculateSalary();
                                System.out.println("***************Employee Details End HERE*****************\n ");
                            }
                            break;
                        case 1002:
                            //For Display Mangers in Employee
                            for (Employee b :  manager.employee) {
                                System.out.println("***************Employee Details*****************\n ");
                                //Fetching Value Form the Map
                                for (Map.Entry<Integer, List<Employee>> entry : map.entrySet()) {
                                    Integer key = entry.getKey();
                                    if(key==value) {
                                        for (Employee e : manager.employee) {
                                            System.out.println("Key = " + key);
                                            e.getter();
                                        }
                                    }else{
                                        break;
                                    }
                                }
                                manager.calculateSalary();
                                System.out.println("***************Employee Details End HERE*****************\n ");
                            }
                            break;
                        case 1003:
                            //For Display sales in Employee
                            for (Employee b :  sales.employee) {
                                System.out.println("***************Employee Details*****************\n ");
                                //Fetching Value Form the Map
                                for (Map.Entry<Integer, List<Employee>> entry : map.entrySet()) {
                                    Integer key = entry.getKey();
                                    if(key==value) {
                                        for (Employee e : sales.employee) {
                                            System.out.println("Key = " + key);
                                            e.getter();
                                        }
                                    }else{
                                        break;
                                    }
                                }
                                sales.calculateSalary();
                                System.out.println("***************Employee Details End HERE*****************\n ");
                            }
                            break;
                    }


                    break;
                case 5:
                    System.out.println("***************Total Expenditure on Employee Salary *****************\n ");
                    float result=0;
                    int count=0;
                    for(Employee e: developer.employee ) {
                        result += e.basicsalary + e.HRA + e.incentives;
                        count++;
                    }
                        for(Employee m :manager.employee){
                            result += m.basicsalary+m.HRA+m.incentives;
                            count++;
                        }
                        for(Employee s:sales.employee){
                            result += s.basicsalary+s.HRA+s.incentives;
                            count++;
                        }
                    System.out.println("Total Employees in Company :"+count);
                    System.out.println("\t"+result);
                    break;
                case 6:
                    System.out.println("Which Department you want to Remove Employee:");
                    System.out.println("1)Developer \n2)Manager \n3)Sales ");
                    // Use for Choice which Department Employee Should get Remove
                    int remove_emp;
                    int employee_id;
                    remove_emp=input.nextInt();
                    switch(remove_emp){
                        case 1:
                            System.out.println("Employee Details:");
                            for(Employee e: developer.employee ){
                                System.out.println(" Id \t Name");
                                System.out.println(" "+e.empid+" "+e.name);
                            }

                            System.out.println("Which Employee You want to Delete (Give Employee id ):");
                            // Which Employee ID we want to delete
                            employee_id =input.nextInt();
                            employee_id-=1;
                            developer.deleteEmployee(employee_id);
                            developer.calculateSalary();
                            developer.employee.remove(employee_id);
                            break;
                        case 2:
                            System.out.println("Employee Details:");
                            for(Employee e: developer.employee ){
                                System.out.println(" Id \t Name");
                                System.out.println(" "+e.empid+" "+e.name);
                            }

                            System.out.println("Which Employee You want to Delete (Give Employee id ):");
                            // Which Employee ID we want to delete
                            employee_id =input.nextInt();
                            employee_id-=1;
                            manager.deleteEmployee(employee_id);
                            manager.calculateSalary();
                            manager.employee.remove(employee_id);
                            break;
                        case 3:
                            System.out.println("Employee Details:");
                            for(Employee e: developer.employee ){
                                System.out.println(" Id  Name");
                                System.out.println(" "+e.empid+" "+e.name);
                            }
                            System.out.println("Which Employee You want to Delete (Give Employee id ):");
                            // Which Employee ID we want to delete
                            employee_id =input.nextInt();
                            employee_id-=1;
                            sales.deleteEmployee(employee_id);
                            sales.calculateSalary();
                            sales.employee.remove(employee_id);
                            break;
                    }
                default:
                    System.out.println("*****************PLEASE ENTER VALID OPTIONS************");
                    break;
            }
            System.out.println("***********Do you want to continue***********:");
            answer=input.next().charAt(0);
        }while(answer=='Y'||answer=='y');
        System.exit(0);
    }
}