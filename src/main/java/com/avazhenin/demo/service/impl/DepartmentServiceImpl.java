package com.avazhenin.demo.service.impl;

import com.avazhenin.demo.dto.DepartmentDTO;
import com.avazhenin.demo.repository.DepartmentRepository;
import com.avazhenin.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository repository;

    @Override
    public DepartmentDTO create(DepartmentDTO department) {
        return repository.save(department);
    }

    @Override
    public void delete(DepartmentDTO dep) {
        repository.deleteById(dep.getId());
    }

    @Override
    public DepartmentDTO update(DepartmentDTO dep) {
        return repository.save(dep);
    }

    @Override
    public List<DepartmentDTO> read() {
        return (List<DepartmentDTO>) repository.findAll();
    }

    @Override
    public Optional<DepartmentDTO> readById(Long id) {
        return repository.findById(id);
    }
}
