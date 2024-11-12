package com.example.apimodule.controller;

import com.example.apimodule.dto.EmployeeDto;
import com.example.apimodule.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    private EmployeeDto employeeDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeDto = new EmployeeDto(1L, "Soni", "banisoni@1233", "banssisis");
    }

    @Test
    void createEmployee() {
        when(employeeService.createEmployee(any(EmployeeDto.class))).thenReturn(employeeDto);

        ResponseEntity<EmployeeDto> response = employeeController.createEmployee(employeeDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(employeeDto, response.getBody());
    }

    @Test
    void getEmployeeById() {
        when(employeeService.getEmployeeById(anyLong())).thenReturn(employeeDto);

        ResponseEntity<EmployeeDto> response = employeeController.getEmployeeById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employeeDto, response.getBody());
    }

    @Test
    void getAllEmployees() {
        List<EmployeeDto> employeeList = Arrays.asList(employeeDto);
        when(employeeService.getAllEmployees()).thenReturn(employeeList);

        ResponseEntity<List<EmployeeDto>> response = employeeController.getAllEmployees();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employeeList, response.getBody());
    }

    @Test
    void updateEmployee() {
        when(employeeService.updateEmployee(anyLong(), any(EmployeeDto.class))).thenReturn(employeeDto);

        ResponseEntity<EmployeeDto> response = employeeController.updateEmployee(1L, employeeDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employeeDto, response.getBody());
    }

    @Test
    void deleteEmployee() {
        doNothing().when(employeeService).deleteEmployee(anyLong());

        ResponseEntity<String> response = employeeController.deleteEmployee(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Employee deleted successfully", response.getBody());
    }
}
