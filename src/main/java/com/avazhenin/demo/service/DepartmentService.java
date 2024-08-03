package com.avazhenin.demo.service;

import com.avazhenin.demo.dto.DepartmentDTO;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    DepartmentDTO create(DepartmentDTO dep);
    List<DepartmentDTO> read();
    Optional<DepartmentDTO> readById(Long id);
    void delete(DepartmentDTO dep);
    DepartmentDTO update(DepartmentDTO dep);
}
