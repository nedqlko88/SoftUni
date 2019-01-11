package car.dealer.repositories;

import car.dealer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> getCustomersByOrderByBirthDateAscYoungDriverAsc();

    List<Customer> getCustomersByOrderByBirthDateAsc();

    List<Customer> getCustomersByOrderByBirthDateDesc();

    Customer getCustomerById(Long id);
}
