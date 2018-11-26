import models.Employee;
import repositories.EmployeesDataRepository;
import repositories.base.DataRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String connectionString = "jdbc:mysql://127.0.0.1:3306/soft_uni_simple";

        Connection connection = DriverManager.getConnection(connectionString,"root", "881223");

        DataRepository<Employee> repository = new EmployeesDataRepository(connection);

        repository.getAll()
                .stream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);

        System.out.println("-----------------------------");
        repository.insert(new Employee("Georgi", "Georgiev"));

        repository.getAll()
                .stream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);



    }
}
