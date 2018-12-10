package bookshop.service;

import bookshop.domain.entities.Author;
import bookshop.domain.entities.Book;
import bookshop.domain.entities.Category;
import bookshop.domain.entities.ReducedBook;
import bookshop.domain.enums.AgeRestriction;
import bookshop.domain.enums.EditionType;
import bookshop.repository.AuthorRepository;
import bookshop.repository.BookRepository;
import bookshop.repository.CategoryRepository;
import bookshop.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private static final String BOOKS_FILE_PATH = "F:\\softUni\\Repository\\HibernateSpringData\\SpringDataIntroduction\\bookshop\\src\\main\\resources\\files\\books.txt";

    private final BookRepository bookRepository;
    private final FileUtil fileUtil;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, FileUtil fileUtil, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.fileUtil = fileUtil;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;

    }


    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] booksFileContent = this.fileUtil.getFileContent(BOOKS_FILE_PATH);

        for (String line : booksFileContent) {
            String[] params = line.split("\\s+", 6);

            Book book = new Book();
            book.setAuthor(getRandomAuthor());

            book.setCategories(getRandomCategories());

            EditionType editionType = EditionType.values()[Integer.parseInt(params[0])];
            book.setEditionType(editionType);
// TODO: 06-Dec-18 throws exception
            LocalDate releaseDate = LocalDate.parse(params[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(releaseDate);

            int copies = Integer.parseInt(params[2]);
            book.setCopies(copies);

            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(params[3]));
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(params[4])];
            book.setAgeRestriction(ageRestriction);

            book.setTitle(params[5]);

            this.bookRepository.save(book);
        }


    }

    @Override
    public List<String> getAllBooksTitleAfter() {
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(LocalDate.parse("2000-12-31"));

        return books.stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public Set<String> getAllAuthorsWithBookBefore(int year) {
        String dataString = String.format("%d-12-31", year);
        LocalDate date = LocalDate.parse(dataString);
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(date);

        return books.
                stream().
                map(b -> b.getAuthor().getFirstName() + " " + b.getAuthor().getLastName()).collect(Collectors.toSet());
    }

    @Override
    public List<String> getAllTitlesWithGivenAgeRestriction(String input) {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(input);

        List<Book> books = this.bookRepository.findAllByAgeRestriction(ageRestriction);

        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllGoldenWithLessThan5000Copies() {
        EditionType editionType = EditionType.valueOf("GOLD");
        List<Book> books = this.bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType, 5000);
        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getBooksWithPriceInRange(String input1, String input2) {
        BigDecimal n1 = new BigDecimal(input1);
        BigDecimal n2 = new BigDecimal(input2);

        List<Book> books = this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(n1, n2);
        return  books.stream()
                .map(b -> String.format("%s - $%s",b.getTitle(), b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getBooksNotReleasedIn(String year) {
        List<Book> books = this.bookRepository.findAllBooksNotReleasedIn(year);

       return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getBooksReleasedBefore(String input) throws ParseException {

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(input, formatters);

        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(date);


        return books.stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> getBooksByGivenSubstring(String substring) {
        List<Book> books = this.bookRepository.findAllByTitleContains(substring);
        return books.stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> getBookTitlesByGivenAuthorsLastNameSubstring(String substring) {

        List<Author> authors = this.authorRepository.findAllByLastNameStartsWith(substring);
        List<String> result = new ArrayList<>();
        for (Author author : authors) {
            for (Book book : author.getBooks()) {
                String line = String.format("%s (%s %s)", book.getTitle(), author.getFirstName(), author.getLastName());
                result.add(line);
            }
        }
        return result;
    }

    @Override
    public int getNumberOfBooksWithGivenLengthOfTitle(int length) {
        return this.bookRepository.countAllByTitleLength(length);
    }

    @Override
    public String getReducedBook(String title) {
        ReducedBook reducedBook = this.bookRepository.findBookByTitle(title);

        return String.format("%s %s %s %s",
                reducedBook.getTitle(),
                reducedBook.getEditionType().name(),
                reducedBook.getAgeRestriction().name(),
                reducedBook.getPrice());
    }


    private Author getRandomAuthor() {
        Random random = new Random();
        long randomId = random.nextInt(((int) this.authorRepository.count()) - 1) + 1;

        return this.authorRepository.findById(randomId).orElseThrow();
    }

    private Set<Category> getRandomCategories() {
        Random random = new Random();
        Set<Category> results = new HashSet<>();
        int randomCountOfCategories = random.nextInt((int) (categoryRepository.count() - 1)) + 1;
        for (int i = 0; i < randomCountOfCategories; i++) {
            long randomId = random.nextInt((int) (categoryRepository.count() - 1)) + 1;
            categoryRepository.findById(randomId).ifPresent(results::add);
        }
        return results;
    }


}
