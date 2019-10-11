package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String listDepartment(Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }

    @GetMapping("/adddept")
    public String departmentForm(Model model){
        model.addAttribute("department", new Department());
        return "departmentform";
    }
    @PostMapping("/processDept")
    public String processForm(@Valid Department department,
                              BindingResult result){
        if (result.hasErrors()){
            return "departmentform";
        }
        departmentRepository.save(department);
        return "redirect:/deptlist";
    }
    @RequestMapping("/deptlist")
    public String departmentListing(Model model){
        model.addAttribute("departments", departmentRepository.findAll());

        return "deptlist";
    }
    @RequestMapping("/detailDept/{id}")
    public String showDepartment(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("department", departmentRepository.findById(id).get());
        return "showdepart";
    }
//    @RequestMapping("/updateDept/{id}")
//    public String updateDepartment(@PathVariable("id") long id,
//                                   Model model){
//        model.addAttribute("department", departmentRepository.findById(id).get());
//        return "departmentform";
//    }
//    @RequestMapping("/deleteDept/{id}")
//    public String delDepartment(@PathVariable("id") long id){
//        departmentRepository.deleteById(id);
//        return "redirect:/";
//    }
    //Employee -----------------------------

    @GetMapping("/addEmployee")
    public String employeeForm(Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("employee", new Employee());
        return "employeeform";
    }
    @PostMapping("/processEmployee")
    public String processForm2(@Valid Employee employee,
                              BindingResult result){
        if (result.hasErrors()){
            return "employeeform";
        }
        employeeRepository.save(employee);
        return "redirect:/employeelist";
    }
    @RequestMapping("/detailEmployee/{id}")
    public String showEmployee(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("employee", employeeRepository.findById(id).get());
        return "showemployee";
    }
    @RequestMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") long id,
                                 Model model){
        model.addAttribute("employee", employeeRepository.findById(id).get());
        model.addAttribute("departments",departmentRepository.findAll());
        return "employeeform";
    }
    @RequestMapping("/deleteEmployee/{id}")
    public String delEmployee(@PathVariable("id") long id){
        employeeRepository.deleteById(id);
        return "redirect:/";
    }
    @RequestMapping("/employeelist")
    public String employeeList(Model model){
        model.addAttribute("employees", employeeRepository.findAll());
        return "employeelist";
    }
}