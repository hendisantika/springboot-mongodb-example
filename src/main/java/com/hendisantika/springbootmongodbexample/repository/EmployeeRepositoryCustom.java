package com.hendisantika.springbootmongodbexample.repository;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mongodb-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-23
 * Time: 06:01
 * To change this template use File | Settings | File Templates.
 */
public interface EmployeeRepositoryCustom {

    long getMaxEmpId();

    long updateEmployee(String empNo, String fullName, Date hireDate);

}