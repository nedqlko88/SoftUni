package app;

import app.entities.Address;
import app.entities.Employee;
import app.entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.List;

public class Engine implements Runnable {
    private final EntityManager em;

    public Engine(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void run() {
        addressEmployeeCount();
    }

    // Problem 2
    private void editShorterTowns() {
        em.getTransaction().begin();
        List<Town> towns = em.createQuery("SELECT t FROM Town t WHERE LENGTH(t.name) <= 5", Town.class)
                .getResultList();

        towns.forEach(t -> {
            String newName = t.getName().toUpperCase();
            t.setName(newName);
            em.persist(t);
        });
        em.getTransaction().commit();
    }

    // Problem 3
    private void containsEmployee() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        em.getTransaction().begin();
        try {
            Employee result = em
                    .createQuery("SELECT e FROM Employee e WHERE concat(e.firstName , ' ', e.lastName) = :name",
                            Employee.class)
                    .setParameter("name", input)
                    .getSingleResult();
            System.out.println("Yes");
        } catch (NoResultException nre) {
            System.out.println("No");
        }
        em.getTransaction().commit();
    }

    // Problem 4
    private void employeesWithHigherSalary() {
        em.getTransaction().begin();

        List<Employee> resultList =
                em.createQuery("SELECT e FROM Employee e WHERE e.salary > 50000", Employee.class)
                        .getResultList();

        resultList.forEach(e -> System.out.println(e.getFirstName()));
    }

    // Problem 5
    private void employeesFromDepartment() {
        em.getTransaction().begin();

        List<Employee> resultList = em.createQuery(
                "SELECT e FROM Employee e WHERE e.department.name = 'Research and Development' ORDER BY e.salary, e.id",
                Employee.class)
                .getResultList();

        resultList.forEach(e -> {
            System.out.println(String.format("%s %s from %s - $%.2f",
                    e.getFirstName(),
                    e.getLastName(),
                    e.getDepartment().getName(),
                    e.getSalary())
            );
        });

    }

    // Problem 6
    private void addingNewAddress() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        em.getTransaction().begin();
        Address address = new Address();
        address.setText("Vitoshka 15");
        Town town = em.createQuery("SELECT t FROM Town t WHERE t.name = 'Sofia'", Town.class)
                .getSingleResult();
        address.setTown(town);
        em.persist(address);
        Employee wantedEmp = em.createQuery("SELECT e FROM Employee e WHERE e.lastName = :input", Employee.class)
                .setParameter("input", input)
                .getSingleResult();
        wantedEmp.setAddress(address);
        em.getTransaction().commit();
    }

    // Problem 7
    private void addressEmployeeCount() {
        Employee employee = em.createQuery("SELECT e FROM Employee e where e.salary > 40000", Employee.class)
                .getSingleResult();

        System.out.println(employee.getFirstName() + " " + employee.getDepartment().getName());
    }
}
