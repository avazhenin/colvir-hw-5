package com.avazhenin.demo.service.impl;

import com.avazhenin.demo.dto.EmployeeDTO;
import com.avazhenin.demo.repository.EmployeeRepository;
import com.avazhenin.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public EmployeeDTO create(EmployeeDTO dep) {
        return repository.save(dep);
    }

    @Override
    public List<EmployeeDTO> read() {
        return (List<EmployeeDTO>) repository.findAll();
    }

    @Override
    public Optional<EmployeeDTO> readById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<EmployeeDTO> read(EmployeeDTO dep) {
        return repository.findById(dep.getId());
    }

    @Override
    public void delete(EmployeeDTO dep) {
        repository.delete(dep);
    }

    @Override
    public EmployeeDTO update(EmployeeDTO dep) {
        return repository.save(dep);
    }
}
