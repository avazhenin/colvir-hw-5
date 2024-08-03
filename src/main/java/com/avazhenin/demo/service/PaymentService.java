package com.avazhenin.demo.service;

import com.avazhenin.demo.dto.PaymentDTO;
import com.avazhenin.demo.repository.query_result.GroupByAmount;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<PaymentDTO> read();

    Optional<PaymentDTO> readById(Long id);

    PaymentDTO create(PaymentDTO payment);

    PaymentDTO update(PaymentDTO payment);

    void delete(PaymentDTO payment);

    List<GroupByAmount> sumAmountByEmployee();
}
