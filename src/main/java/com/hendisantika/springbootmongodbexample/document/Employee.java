package com.hendisantika.springbootmongodbexample.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mongodb-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-23
 * Time: 05:55
 * To change this template use File | Settings | File Templates.
 */
@Document(collection = "Employee")
public class Employee {

    @Id
    private Long id;

    @Indexed(unique = true)
    @Field(value = "empNo")
    private String empNo;

    @Field(value = "fullName")
    private String fullName;

    @Field(value = "hireDate")
    private Date hireDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "id:" + this.id + ", empNo: " + empNo //
                + ", fullName: " + this.fullName + ", hireDate: " + this.hireDate;
    }
}