package com.security.demo.Examples.Siniflar.Persistance;

public class Test {
    /**
     * Bütün bu sistemin en başına bir Map koyarsak verileri alan ve kaydeden bir sisteme sahip oluruz.
     */
    private AbstractDao<Employee> dao;
    private EmployeeService service;

    public Test(AbstractDao<Employee> dao) {
        this.dao = dao;
        this.service = new EmployeeService(dao);
    }

    public static void main(String[] args) {
        Test test = new Test(new EmployeeDao());
        test.service.createEmployee(new Employee(2,"halil","password"));
        Employee employee=test.dao.retrieve(2L);
        System.out.println(employee);
        employee.setPassword("test");
        test.service.changePassword(employee);
        System.out.println(employee.getPassword());
    }
}
