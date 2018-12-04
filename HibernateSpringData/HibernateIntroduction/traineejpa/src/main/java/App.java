import entities.Department;
import entities.Employee;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emfSoftuni =
                Persistence.createEntityManagerFactory("softuni");

        EntityManager emSoftuni = emfSoftuni.createEntityManager();


//       transaction/find record/ remove record
//        emSoftuni.getTransaction().begin();
//        Employee wantedEmp = emSoftuni.find(Employee.class, 1);
//        System.out.println(wantedEmp);
//        emSoftuni.remove(wantedEmp);
//        emSoftuni.getTransaction().commit();

//        transaction/ make new entity / persist / insert / update
//        emSoftuni.getTransaction().begin();
//        Employee employee = new Employee("Baba", "Qga");
//        emSoftuni.persist(employee);
//        employee.setFirstName("Babaruga");
//        emSoftuni.getTransaction().commit();

        emSoftuni.getTransaction().begin();
        Employee emp = new Employee("Nedqlko", "Nedqlkov");
        emSoftuni.persist(emp);
        System.out.println(emSoftuni.contains(emp));
        emSoftuni.detach(emp);
        System.out.println(emSoftuni.contains(emp));
        emSoftuni.getTransaction().commit();


//        EntityManagerFactory emfDepartment =
//                Persistence
//                        .createEntityManagerFactory("department");
//        EntityManager emDepartment = emfDepartment.createEntityManager();
//        emDepartment.getTransaction().begin();
//        Department department = new Department("programming");
//        emDepartment.persist(department);
//        emDepartment.getTransaction().commit();


    }
}

