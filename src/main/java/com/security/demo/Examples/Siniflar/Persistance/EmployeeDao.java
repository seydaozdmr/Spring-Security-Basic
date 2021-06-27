package com.security.demo.Examples.Siniflar.Persistance;

public class EmployeeDao extends AbstractDao<Employee>{

    @Override
    public void save(Employee employee) {
        myMap.put(employee.getId(),employee);
        System.out.println("employee saved");
    }

    @Override
    public void update(Employee employee) {
        myMap.put(employee.getId(),employee);
        System.out.println("employee updated");
    }

    @Override
    public Employee retrieve(Long id) {
        return myMap.get(id);
    }
}
