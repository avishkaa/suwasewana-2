package lk.suwasewana;

import lk.suwasewana.asset.commonAsset.model.Enum.BloodGroup;
import lk.suwasewana.asset.commonAsset.model.Enum.CivilStatus;
import lk.suwasewana.asset.commonAsset.model.Enum.Gender;
import lk.suwasewana.asset.commonAsset.model.Enum.Title;
import lk.suwasewana.asset.employee.entity.Employee;
import lk.suwasewana.asset.employee.entity.Enum.Designation;
import lk.suwasewana.asset.employee.entity.Enum.EmployeeStatus;
import lk.suwasewana.asset.employee.service.EmployeeService;
import lk.suwasewana.asset.userManagement.entity.Role;
import lk.suwasewana.asset.userManagement.entity.User;
import lk.suwasewana.asset.userManagement.service.RoleService;
import lk.suwasewana.asset.userManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.stream.Collectors;

@RestController
public class ApplicationCreateRestController {
    private final RoleService roleService;
    private final UserService userService;
    private final EmployeeService employeeService;


    @Autowired
    public ApplicationCreateRestController(RoleService roleService, UserService userService,
                                           EmployeeService employeeService) {
        this.roleService = roleService;
        this.userService = userService;
        this.employeeService = employeeService;
    }

    @GetMapping( "/select/user" )
    public String saveUser() {
        //roles list start
        String[] roles = {"ADMIN"};
        for ( String s : roles ) {
            Role role = new Role();
            role.setRoleName(s);
            roleService.persist(role);
        }

//Employee
        Employee employee = new Employee();
        employee.setName("Admin User");
        employee.setName("908670000V");
        employee.setMobileOne("0750000000");
        employee.setGender(Gender.MALE);
        employee.setDesignation(Designation.ED);
        employee.setCivilStatus(CivilStatus.UNMARRIED);
        employee.setEmployeeStatus(EmployeeStatus.WORKING);
        employee.setDateOfBirth(LocalDate.now().minusYears(18));
        employee.setDateOfAssignment(LocalDate.now());
        Employee employeeDb = employeeService.persist(employee);


        //admin user one
        User user = new User();
        user.setEmployee(employeeDb);
        user.setUsername("admin");
        user.setPassword("admin");
        String message = "Username:- " + user.getUsername() + "\n Password:- " + user.getPassword();
        user.setEnabled(true);
        user.setRoles(roleService.findAll()
                              .stream()
                              .filter(role -> role.getRoleName().equals("ADMIN"))
                              .collect(Collectors.toList()));
        userService.persist(user);

        return message;
    }


}
