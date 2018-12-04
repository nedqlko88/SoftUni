package app;

import app.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.*;

public class Engine implements Runnable {
    private final EntityManager em;

    public Engine(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void run() {
        maxSalaries();
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
        List<Address> results = em.createQuery("SELECT a FROM Address a ORDER BY a.employees.size DESC, a.town.id", Address.class).setMaxResults(10).getResultList();
        for (Address a : results) {
            System.out.println(a.getText() + ", " + a.getTown().getName() + " - " + a.getEmployees().size() + " employees");

        }


    }

    // Problem 8
    private void employeeWithProject() {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        Employee emp = em.createQuery("SELECT e FROM Employee e where e.id = : input", Employee.class)
                .setParameter("input", input).getSingleResult();

        System.out.println(String.format("%s %s - %s", emp.getFirstName(), emp.getLastName(), emp.getJobTitle()));

        emp.getProjects().stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(e -> System.out.println(e.getName()));


    }

    // Problem 9
    private void findLatestProjects() {
        List<Project> results = em.createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();
        results.stream().sorted(Comparator.comparing(Project::getName)).forEach(p -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Project name: ").append(p.getName())
                    .append(System.lineSeparator())
                    .append("\t")
                    .append("Project Description: ")
                    .append(p.getDescription())
                    .append(System.lineSeparator())
                    .append("\t")
                    .append("Project Start Date: ")
                    .append(p.getStartDate())
                    .append(System.lineSeparator())
                    .append("\t")
                    .append("Project End Date: ")
                    .append(p.getEndDate());
            System.out.println(sb.toString());
        });
    }

    // Problem 10
    private void increaseSalary() {
        List<Employee> results =
                em.createQuery(
                        "SELECT e FROM Employee e WHERE e.department.id IN (1,2,4,11)",
                        Employee.class
                )
                        .getResultList();

        results.forEach(e -> {
            em.getTransaction().begin();
            BigDecimal newSalary = e.getSalary().multiply(BigDecimal.valueOf(1.12));
            e.setSalary(newSalary);
            em.persist(e);
            em.getTransaction().commit();
            System.out.println(e.getFirstName() + " " + e.getLastName() + " $(" + e.getSalary() + ")");
        });
    }

    // Problem 11
    private void removeTown() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        List<Address> addresses =
                em.createQuery(
                        "SELECT a from Address a WHere LOWER(a.town.name) = :input",
                        Address.class
                )
                        .setParameter("input", input)
                        .getResultList();

        int count = addresses.size();

        for (Address address : addresses) {
            em.getTransaction().begin();
            em.remove(address);
            em.getTransaction().commit();
        }
        System.out.println(count);

    }

    // Problem 12
    private void findEmployee() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        List<Employee> employees = em.createQuery("SELECT e from Employee e where e.firstName like :input",
                Employee.class
        )
                .setParameter("input", input + "%")
                .getResultList();

        employees.forEach(e -> {
            System.out.println(
                    String.format("%s %s - %s - ($%.2f)",
                            e.getFirstName(),
                            e.getLastName(),
                            e.getJobTitle(),
                            e.getSalary())
            );
        });
    }

    // Problem 13
    private void maxSalaries() {
        List<BigDecimal> salaries = em.createQuery("select max(e.salary) from Employee e group by e.department.name",
                BigDecimal.class
        ).getResultList();

        List<Department> departments = em.createQuery("SELECT d FROM Department d", Department.class).getResultList();

        for (int i = 0; i < salaries.size(); i++) {
            if (salaries.get(i).compareTo(BigDecimal.valueOf(30000)) < 0 || salaries.get(i).compareTo(BigDecimal.valueOf(70000)) > 0) {
                System.out.println(departments.get(i).getName() + " - " + salaries.get(i));
            }
        }

    }
}
