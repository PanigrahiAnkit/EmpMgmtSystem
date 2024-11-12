package com.example.apimodule.controller;

import com.example.apimodule.dto.EmployeeDto;
import com.example.apimodule.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Employee Management System", description = "Operations related to employees")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
private  EmployeeService employeeService;

    @Operation(summary = "Create a new employee", description = "Adds a new employee to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Exception.class)))
    })
//CREATE REST API
@PostMapping
public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
    EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

}

    @Operation(summary = "Get an employee by ID", description = "Retrieves an employee by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeDto.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Exception.class)))
    })
    //GET EMPLOYEE BY ID
@GetMapping("{id}")
public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
    EmployeeDto employeeDto=employeeService.getEmployeeById(id);
    return  ResponseEntity.ok(employeeDto);
}

    @Operation(summary = "Get all employees", description = "Retrieves a list of all employees")
    @ApiResponse(responseCode = "200", description = "List of employees retrieved successfully",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmployeeDto.class)))
//GET ALL EMPLOYEES
@GetMapping
public  ResponseEntity <List<EmployeeDto>> getAllEmployees() {
    List<EmployeeDto> employees=employeeService.getAllEmployees();
    return  ResponseEntity.ok(employees);
}

    @Operation(summary = "Update an existing employee", description = "Updates the details of an existing employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Exception.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Exception.class)))
    })
    //UPDATE EMPLOYEE ID
@PutMapping("{id}")
public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto updatedEmployee) {
    EmployeeDto employeeDto=employeeService.updateEmployee(id, updatedEmployee);
    return  ResponseEntity.ok(employeeDto);
}

    @Operation(summary = "Delete an employee", description = "Deletes an employee by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Employee deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Exception.class)))
    })
@DeleteMapping("{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
    employeeService.deleteEmployee(id);
    return  ResponseEntity.ok("Employee deleted successfully");
}
}
