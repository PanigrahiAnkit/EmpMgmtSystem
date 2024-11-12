package com.example.apimodule.service;

import com.example.apimodule.dto.EmployeeDto;
import com.example.apimodule.entity.Employee;
import com.example.apimodule.mapper.EmployeeMapper;
import com.example.apimodule.repository.EmployeeRepository;
import com.example.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private  EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            throw new IllegalArgumentException("EmployeeDto cannot be null");
        }
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        // Add some debug logs or assertions
        if (employee == null) {
            throw new IllegalStateException("Failed to map EmployeeDto to Employee");
        }

        Employee savedEmployee = employeeRepository.save(employee);

        // Check if savedEmployee is not null
        if (savedEmployee == null) {
            throw new IllegalStateException("Employee not saved successfully");
        }

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }


    @Override
    public EmployeeDto getEmployeeById(Long id) {
      Employee employee=  employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with id " + id + " not found"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {
        Employee employee=  employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with id " + id + " not found"));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee=  employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with id " + id + " not found"));
        employeeRepository.delete(employee);
    }
}
