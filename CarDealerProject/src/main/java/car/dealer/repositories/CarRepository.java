package car.dealer.repositories;

import car.dealer.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT *\n" +
            "From cardb.cars as c\n" +
            "where c.make = :make\n" +
            "order by c.model ASC, c.travelled_distance DESC;", nativeQuery = true)
    List<Car> getAllByMakeOrderByModelAscAndByKmDesc(@Param("make") String make);
}
