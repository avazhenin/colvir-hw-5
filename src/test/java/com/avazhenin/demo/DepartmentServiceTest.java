package com.avazhenin.demo;

import com.avazhenin.demo.controller.DepartmentController;
import com.avazhenin.demo.dto.DepartmentDTO;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DepartmentServiceTest {
    Logger logger = Logger.getLogger(DepartmentServiceTest.class);

    @Autowired
    DepartmentController controller;

    @Test void init(){
        logger.info("##### Homework_1 run test init #####");
        Mockito.notNull(controller.getClass());
    }

    @Test
    void create(){
        logger.info("##### Homework_1 run test create #####");
        DepartmentDTO dto = new DepartmentDTO();
        dto.setName("Almaty");
        DepartmentDTO newDepartment = controller.add(dto);
        assertNotNull(newDepartment.getId());
    }

    @Test
    void edit(){
        logger.info("##### Homework_1 run test edit #####");
        String almaty = "Almaty";
        String bishkek = "Bishkek";
        Optional<DepartmentDTO> byId = controller.getById(0L);

        if(byId.isPresent()){
            DepartmentDTO createdDep = byId.get();
            createdDep.setName(bishkek);
            assertNotEquals(controller.edit(createdDep).getName(), almaty);
        }

    }

    @Test
    void delete(){
        logger.info("##### Homework_1 run test delete #####");
        DepartmentDTO dto = new DepartmentDTO(0L,"Karaganda");
        assertNotNull(controller.add(dto).getId());
        controller.delete(dto);
        assertNull(controller.getById(dto.getId()).orElse(null));
    }
}
