package com.hendisantika.springbootmongodbexample.controller;

import com.hendisantika.springbootmongodbexample.document.Employee;
import com.hendisantika.springbootmongodbexample.repository.EmployeeRepository;
import com.hendisantika.springbootmongodbexample.repository.EmployeeRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mongodb-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-23
 * Time: 06:03
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MainController {

    private static final String[] NAMES = {"Tom", "Jerry", "Donald", "Naruto", "Sasuke", "Sakura", "Kakashi", "Lee",
            "Ten-ten", "Neji", "Guy", "Ino", "Shikamaru", "Chouji", "Asuma", "Shino", "Kiba", "Hinata", "Kurenai",
            "Jiraiya", "Tsunade", "Orochimaru", "Minato", "Hashirama", "Tobirama", "Sarutobi", "Gaara", "Kankuro",
            "Temari"};

    @Autowired
    private EmployeeRepositoryCustom employeeRepositoryCustom;

    @Autowired
    private EmployeeRepository employeeRepository;

    @ResponseBody
    @GetMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/testInsert'>Test Insert</a></li>";
        html += " <li><a href='/showAllEmployee'>Show All Employee</a></li>";
        html += " <li><a href='/showFullNameLikeTom'>Show All 'Tom'</a></li>";
        html += " <li><a href='/deleteAllEmployee'>Delete All Employee</a></li>";
        html += "</ul>";
        return html;
    }

    @ResponseBody
    @GetMapping("/testInsert")
    public List<Employee> testInsert() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        for (int i = 0; i < NAMES.length; i++) {

            long id = this.employeeRepositoryCustom.getMaxEmpId() + 1;
            int idx = (int) (id % NAMES.length);
            String fullName = NAMES[idx] + " " + id;

            employee.setId(id);
            employee.setEmpNo("E" + id);
            employee.setFullName(fullName);
            employee.setHireDate(new Date());
            employeeList.add(employee);
            this.employeeRepository.insert(employee);
        }
        return employeeRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/showAllEmployee")
    public String showAllEmployee() {

        List<Employee> employees = this.employeeRepository.findAll();

        String html = "";
        for (Employee emp : employees) {
            html += emp + "<br>";
        }

        return html;
    }

    @ResponseBody
    @GetMapping("/showFullNameLikeTom")
    public String showFullNameLikeTom() {

        List<Employee> employees = this.employeeRepository.findByFullNameLike("Tom");

        String html = "";
        for (Employee emp : employees) {
            html += emp + "<br>";
        }

        return html;
    }

    @ResponseBody
    @GetMapping("/deleteAllEmployee")
    public String deleteAllEmployee() {

        this.employeeRepository.deleteAll();
        return "Deleted!";
    }

}