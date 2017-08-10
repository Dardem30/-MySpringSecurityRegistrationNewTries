package by.controller;

import by.model.Role;
import by.model.User;
import by.service.EmployeeService;
import by.service.RoleService;
import by.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Роман on 05.08.2017.
 */
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/userRole", method = RequestMethod.GET)
    public ModelAndView mainUserRole(){
        ModelAndView modelAndView=new ModelAndView("roleUser");
        modelAndView.addObject("role",new Role());
        modelAndView.addObject("userList",userService.getListUser());
        modelAndView.addObject("user",new User());
        modelAndView.addObject("roleList",roleService.getListRole());
        modelAndView.addObject("employeeList",employeeService.getListEmployee());
        return modelAndView;
    }
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public String addRole(@ModelAttribute("role")Role role){
        roleService.saveRole(role);
        return "redirect:/userRole";
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")User user){
        userService.saveUser(user);
        return "redirect:/userRole";
    }
    @RequestMapping(value = "/adminUpdateUser",method = RequestMethod.GET)
    public ModelAndView adminUpdateUser(@RequestParam("id")int id){
        ModelAndView modelAndView=new ModelAndView("adminUpdateUser");
        modelAndView.addObject("roleList",roleService.getListRole());
        modelAndView.addObject("employeeList",employeeService.getListEmployee());
        modelAndView.addObject("user",userService.getById(id));
        return modelAndView;
    }
    @RequestMapping(value = "/adminUpdateUser",method = RequestMethod.POST)
    public String adminUpdateUser(@ModelAttribute("user")User user){
        this.userService.updateUser(user);
        return "redirect:/userRole";
    }
    @RequestMapping(value = "/adminDeleteUser",method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id")int id){
        this.userService.deleteUser(this.userService.getById(id));
        return "redirect:/userRole";
    }
    @RequestMapping(value = "/adminUpdateRole",method = RequestMethod.GET)
    public ModelAndView adminUpdateRole(@RequestParam("id")int id){
        ModelAndView modelAndView=new ModelAndView("adminUpdateRole");
        modelAndView.addObject("userList",userService.getListUser());
        modelAndView.addObject("role",roleService.getRoleById(id));
        return modelAndView;
    }
    @RequestMapping(value = "/adminUpdateRole",method = RequestMethod.POST)
    public String adminUpdateRole(@ModelAttribute("role")Role role){
        this.roleService.updateRole(role);
        return "redirect:/userRole";
    }
    @RequestMapping(value = "/adminDeleteRole",method = RequestMethod.GET)
    public String deleteRole(@RequestParam("id")int id){
        this.roleService.deleteRole(this.roleService.getRoleById(id));
        return "redirect:/userRole";
    }
}
