package com.avazhenin.demo.repository;

import com.avazhenin.demo.dto.PaymentDTO;
import com.avazhenin.demo.repository.query_result.GroupByAmount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentDTO, Long> {
    @Query(value = "select p.employee.name as name, sum(p.amount) as amount from payment p group by p.employee.name")
    List<GroupByAmount> sumAmountByEmployee();
}
