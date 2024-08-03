package com.avazhenin.demo.service.impl;

import com.avazhenin.demo.dto.PaymentDTO;
import com.avazhenin.demo.repository.PaymentRepository;
import com.avazhenin.demo.repository.query_result.GroupByAmount;
import com.avazhenin.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository repository;

    @Override
    public List<PaymentDTO> read() {
        return (List<PaymentDTO>) repository.findAll();
    }

    @Override
    public Optional<PaymentDTO> readById(Long id) {
        return repository.findById(id);
    }

    @Override
    public PaymentDTO create(PaymentDTO payment) {
        return repository.save(payment);
    }

    @Override
    public void delete(PaymentDTO payment) {
        repository.delete(payment);
    }

    @Override
    public PaymentDTO update(PaymentDTO payment) {
        return repository.save(payment);
    }

    @Override
    public List<GroupByAmount> sumAmountByEmployee() {
        return repository.sumAmountByEmployee();
    }
}
