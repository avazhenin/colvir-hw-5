package com.avazhenin.demo.repository;

import com.avazhenin.demo.dto.EmployeeDTO;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeDTO, Long> {
}
