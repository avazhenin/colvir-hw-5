package com.avazhenin.demo.controller;

import com.avazhenin.demo.dto.PaymentDTO;
import com.avazhenin.demo.repository.query_result.GroupByAmount;
import com.avazhenin.demo.service.PaymentService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    Logger log = Logger.getLogger(EmployeeController.class);

    @Autowired
    PaymentService service;

    @GetMapping()
    public List<PaymentDTO> getAll() {
        return service.read();
    }

    @GetMapping("/{id}")
    public Optional<PaymentDTO> getById(@RequestParam(name = "id") Long id) {
        log.infof("GET request /employee/%s", id);
        return service.readById(id);
    }

    @PostMapping("/create")
    public PaymentDTO create(@RequestBody PaymentDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/update")
    public PaymentDTO update(@RequestBody PaymentDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody PaymentDTO dto) {
        service.delete(dto);
    }
    @GetMapping("/payments-grouped-by-user")
    public List<GroupByAmount> sumAmountByEmployee() {
        return service.sumAmountByEmployee();
    }
}
