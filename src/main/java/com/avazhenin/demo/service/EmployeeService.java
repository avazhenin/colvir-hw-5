package com.avazhenin.demo.service;

import com.avazhenin.demo.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDTO create(EmployeeDTO dep);

    List<EmployeeDTO> read();
    Optional<EmployeeDTO> readById(Long id);
    Optional<EmployeeDTO> read(EmployeeDTO dep);

    void delete(EmployeeDTO dep);

    EmployeeDTO update(EmployeeDTO dep);
}
