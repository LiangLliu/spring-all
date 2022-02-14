package com.lianglliu.springvaultdemo.employee;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employees")
@Slf4j
@Validated
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Employee> getAllEmployees
            (@PageableDefault(size = QueryConstants.DEFAULT_PAGE_SIZE) Pageable pageable) {
        log.info("++++++ In get All Employees ++++++++");
        return employeeService.getAllEmployees(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee findById(@PathVariable("id") Long id) {
        log.info("++++++ In find by id ++++++++");
        return employeeService.findById(id);
    }
}
