package com.avazhenin.demo.controller;

import com.avazhenin.demo.dto.DepartmentDTO;
import com.avazhenin.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    Logger log = Logger.getLogger(DepartmentController.class);

    @Autowired
    DepartmentService service;

    @GetMapping()
    public List<DepartmentDTO> getAll() {
        log.info("GET request /department");
        return service.read();
    }

    @GetMapping("/{id}")
    public Optional<DepartmentDTO> getById(@RequestParam(name = "id") Long id) {
        log.infof("GET request /department/%s", id);
        return service.readById(id);
    }

    @PostMapping("/create")
    public DepartmentDTO add(@RequestBody DepartmentDTO dep) {
        log.infof("POST request /department/create %s", dep);
        return service.create(dep);
    }

    @PutMapping("/update")
    public DepartmentDTO edit(@RequestBody DepartmentDTO dep) {
        log.infof("POST request /department/update %s", dep);
        return service.update(dep);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DepartmentDTO dep) {
        log.infof("POST request /department/delete %s", dep);
        service.delete(dep);
    }

}
