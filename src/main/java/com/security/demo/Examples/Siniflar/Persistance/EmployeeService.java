package com.security.demo.Examples.Siniflar.Persistance;

public class EmployeeService {
    AbstractDao<Employee> service;

    public EmployeeService(AbstractDao<Employee> service) {
        this.service = service;
    }

    public void createEmployee(Employee employee){
        service.save(employee);
    }

    public void changePassword(Employee employee){
        service.update(employee);
    }

}
