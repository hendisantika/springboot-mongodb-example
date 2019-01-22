package com.hendisantika.springbootmongodbexample.repository;

import com.hendisantika.springbootmongodbexample.document.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mongodb-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-23
 * Time: 05:57
 * To change this template use File | Settings | File Templates.
 */
public interface EmployeeRepository extends MongoRepository<Employee, Long> { // Long: Type of Employee ID.

    Employee findByEmpNo(String empNo);

    List<Employee> findByFullNameLike(String fullName);

    List<Employee> findByHireDateGreaterThan(Date hireDate);

    // Supports native JSON query string
    @Query("{fullName:'?0'}")
    List<Employee> findCustomByFullName(String fullName);

}
