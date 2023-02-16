package  com.userservice.users.controller;

import com.userservice.users.model.EmployeeVO;
import com.userservice.users.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeVO addNewEmployee(@RequestBody EmployeeVO employeeVO){
        return employeeService.addNewEmployee(employeeVO);
    }

    @GetMapping(path = "/get/by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeVO getEmployeeById(@RequestParam(required = true, defaultValue = "") String employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping(path = "/get/by-dept-and-salary", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeVO> getEmployeeByDeptAndSalary(@RequestParam(required = true, defaultValue = "") String employeeDepartment, Integer employeeSalary){
        return employeeService.getEmployeeByDeptAndSalary(employeeDepartment, employeeSalary);
    }
}

