package com.hendisantika.springbootmongodbexample.repository;

import com.hendisantika.springbootmongodbexample.document.Employee;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mongodb-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-23
 * Time: 06:02
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    public long getMaxEmpId() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "id"));
        query.limit(1);
        Employee maxObject = mongoTemplate.findOne(query, Employee.class);
        if (maxObject == null) {
            return 0L;
        }
        return maxObject.getId();
    }

    @Override
    public long updateEmployee(String empNo, String fullName, Date hireDate) {
        Query query = new Query(Criteria.where("empNo").is(empNo));
        Update update = new Update();
        update.set("fullName", fullName);
        update.set("hireDate", hireDate);

        UpdateResult result = this.mongoTemplate.updateFirst(query, update, Employee.class);

        if (result != null) {
            return result.getModifiedCount();
        }

        return 0;
    }

}