package com.avazhenin.demo.repository;

import com.avazhenin.demo.dto.DepartmentDTO;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<DepartmentDTO, Long> {

}
