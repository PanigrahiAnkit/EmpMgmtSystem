package com.example.apimodule.service;

import com.example.apimodule.dto.EmployeeDto;
import com.example.apimodule.entity.Employee;
import com.example.apimodule.repository.EmployeeRepository;
import com.example.exception.ResourceNotFoundException;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;
    private EmployeeDto employeeDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks

        employee = new Employee(1L, "Soni", "banisoni@1233", "banssisis");
        employeeDto = new EmployeeDto(1L, "Soni", "banisoni@1233", "banssisis");
    }

    @AfterEach
    void tearDown() {
        employee = null;
        employeeDto = null;
    }

    @Test
    void testCreateEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        EmployeeDto result = employeeService.createEmployee(employeeDto);

        assertNotNull(result);
        assertEquals("Soni", result.getFirstName());
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }
    @Test
    public void testCreateEmployeeReturnsValidDto() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("John");
        employeeDto.setLastName("Doe");
        employeeDto.setEmail("john.doe@example.com");

        // Create a valid Employee object
        Employee savedEmployee = new Employee();
        savedEmployee.setId(1L);
        savedEmployee.setFirstName(employeeDto.getFirstName());
        savedEmployee.setLastName(employeeDto.getLastName());
        savedEmployee.setEmail(employeeDto.getEmail());

        // Mocking the save method to return the saved Employee
        when(employeeRepository.save(any(Employee.class))).thenReturn(savedEmployee);

        EmployeeDto result = employeeService.createEmployee(employeeDto);

        assertNotNull(result); // Ensure result is not null
        assertEquals(savedEmployee.getId(), result.getId()); // Check that IDs match
        assertEquals(savedEmployee.getFirstName(), result.getFirstName());
        assertEquals(savedEmployee.getLastName(), result.getLastName());
        assertEquals(savedEmployee.getEmail(), result.getEmail());
    }


    @Test
    void testGetEmployeeById_ExistingId() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        EmployeeDto result = employeeService.getEmployeeById(1L);

        assertNotNull(result);
        assertEquals("Soni", result.getFirstName());
        verify(employeeRepository, times(1)).findById(1L);
    }
    @Test
    void testGetEmployeeById_NonExistingId() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            employeeService.getEmployeeById(1L);
        });

        assertEquals("Employee with id 1 not found", exception.getMessage());
        verify(employeeRepository, times(1)).findById(1L);
    }
    @Test
    public void testDeleteEmployeeThrowsException() {
        Long employeeId = 1L;

        when(employeeRepository.findById(employeeId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            employeeService.deleteEmployee(employeeId);
        });
    }


}
