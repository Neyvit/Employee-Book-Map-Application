package pro.sky.java.course2.employeebookmapapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeebookmapapplication.data.Employee;
import pro.sky.java.course2.employeebookmapapplication.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebookmapapplication.service.EmployeeService;

import java.util.Collection;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String surname,
                                @RequestParam String name,
                                @RequestParam String middleName,
                                @RequestParam int department,
                                @RequestParam int salary) {
        return employeeService.addEmployee(surname, name, middleName, department, salary);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String surname,
                                 @RequestParam String name,
                                 @RequestParam String middleName) throws EmployeeNotFoundException {
        return "Сотрудник " + employeeService.removeEmployee(surname, name, middleName) + " удалён.";
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String surname,
                                 @RequestParam String name,
                                 @RequestParam String middleName) throws EmployeeNotFoundException {
        return employeeService.findEmployee(surname, name, middleName);
    }

    @GetMapping("/all")
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}