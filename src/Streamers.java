import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streamers {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        //3.1 : How many male and female employees are there in the organization?
        Map<String, Long> genderCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, LinkedHashMap::new,Collectors.counting()));
        System.out.println("gender count  = "+genderCount);

        //3.2 : Print the name of all departments in the organization?
        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        //What is the average age of male and female employees?
        Double maleSalary = employeeList.stream().filter(emp -> emp.getGender().equals("Male")).collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("male salary --> "+maleSalary);
        Double femaleSalary = employeeList.stream().filter(emp -> emp.getGender().equals("Female")).collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("female salary --> "+femaleSalary);
        Map<String, Double> maleAndFemaleSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("maleAndFemaleSalary salary --> "+maleAndFemaleSalary);

        //Who has the most working experience in the organization?
        Employee employee = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst().get();
        System.out.println("employee oldest ---> "+employee);
        System.out.println("employee oldest ---> "+employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).get());

        //3.10 : How many male and female employees are there in the sales and marketing team?
        Map<String, Long> res = employeeList.stream().filter(emp -> emp.getDepartment().equals("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("male and Female emp in sales and marketing dept -> "+res);

        Double v = employeeList.stream().map(m -> m.getSalary()).max(Double::compare).get();
        System.out.println("max salary -----> "+v);

        String str = "qqqQwesrt";
        Map<String, Long> val = str.toLowerCase().chars().mapToObj(c -> Character.toString((char) c)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(val);

        String hello = "hello";

        List<String> helloList = Arrays.asList("olleh","holle","helloo","HELLO");

        List<String> vallll = helloList.stream()
                .filter(i -> i.toLowerCase().chars().mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .equals(hello.toLowerCase().chars().mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())))).collect(Collectors.toList());

        System.out.println(vallll);


        System.out.println("**************************************************");

        Map<String, Long> mfCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(mfCount);

        System.out.print("deptCount ---> ");
        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::print);
        System.out.println();

        Map<String, Double> avgEmpAge = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println(avgEmpAge);

        System.out.println(employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get());

        employeeList.stream().filter(e -> e.getYearOfJoining()>2015).map(m -> m.getName()).forEach(System.out::println);

        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors
                .averagingDouble(Employee::getSalary))));

        System.out.println(employeeList.stream().filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development").collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge))).get());
        System.out.println(employeeList.stream().filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development").min(Comparator.comparingInt(Employee::getAge)).get());

        System.out.println(employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).get());

        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment)));

        DoubleSummaryStatistics value = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(value.getAverage());
        System.out.println(value.getSum());

        System.out.println(employeeList.stream().collect(Collectors.partitioningBy(i -> i.getAge()>25)));

        System.out.println(employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).get());
    }
}
