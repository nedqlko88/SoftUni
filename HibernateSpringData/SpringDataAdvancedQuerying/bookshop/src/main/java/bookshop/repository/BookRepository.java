package bookshop.repository;

import bookshop.domain.entities.Author;
import bookshop.domain.entities.Book;
import bookshop.domain.entities.ReducedBook;
import bookshop.domain.enums.AgeRestriction;
import bookshop.domain.enums.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
        List<Book> findAllByReleaseDateAfter(LocalDate date);

        List<Book> findAllByReleaseDateBefore(LocalDate date);

        List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

        List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

        List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2);

        @Query(value = "select b FROM bookshop.domain.entities.Book AS b Where substring(b.releaseDate, 1, 4) not like :year")

        List<Book> findAllBooksNotReleasedIn(@Param(value = "year") String year);

        List<Book> findAllByTitleContains(String substring);

        List<Book> findAllByAuthor(List<Author> authors);

        @Query("select count(b) From bookshop.domain.entities.Book AS b WHERE length(b.title) > :length")
        int countAllByTitleLength(@Param(value = "length") int length);

        @Query("SELECT new bookshop.domain.entities.ReducedBook(b.title, b.editionType, b.ageRestriction, b.price) FROM bookshop.domain.entities.Book as b where b.title = :title")
        ReducedBook findBookByTitle(@Param(value = "title") String title);








}
