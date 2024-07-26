package com.avazhenin.demo.controller;

import com.avazhenin.demo.dto.EmployeeDTO;
import com.avazhenin.demo.service.EmployeeService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    Logger log = Logger.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService service;

    @GetMapping()
    public List<EmployeeDTO> getAll(){
        return service.read();
    }
    @GetMapping("/{id}")
    public Optional<EmployeeDTO> getById(@RequestParam(name = "id") Long id) {
        log.infof("GET request /employee/%s", id);
        return service.readById(id);
    }
    @PostMapping("/create")
    public EmployeeDTO create(@RequestBody EmployeeDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/update")
    public EmployeeDTO update(@RequestBody EmployeeDTO dto) {
        return service.update(dto);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody EmployeeDTO dto) {
        service.delete(dto);
    }
}
