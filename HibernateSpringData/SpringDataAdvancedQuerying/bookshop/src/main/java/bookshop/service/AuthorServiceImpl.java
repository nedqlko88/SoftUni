package bookshop.service;

import bookshop.domain.entities.Author;
import bookshop.domain.entities.Book;
import bookshop.repository.AuthorRepository;
import bookshop.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final String AUTHORS_FILE_PATH = "F:\\softUni\\Repository\\HibernateSpringData\\SpringDataIntroduction\\bookshop\\src\\main\\resources\\files\\authors.txt";

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }

        String[] authorFileContent = this.fileUtil.getFileContent(AUTHORS_FILE_PATH);

        for (String line : authorFileContent) {
            String[] names = line.split("\\s+");
            Author author = new Author();
            author.setFirstName(names[0]);
            author.setLastName(names[1]);
            this.authorRepository.save(author);
        }
    }

    @Override
    public List<String> getAuthorsByEnds(String firstName) {
        List<Author> authors = this.authorRepository.findAllByFirstNameEndingWith(firstName);

        return authors.stream().map(a -> a.getFirstName() + " " + a.getLastName())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAuthorsWithTotalCopies() {
        List<Author> authors = this.authorRepository.findAll();
        List<String> results = new ArrayList<>();

        for (Author author : authors) {
            int sum = author.getBooks().stream().mapToInt(Book::getCopies).sum();
            results.add(String.format("%s %s - %d",author.getFirstName(), author.getLastName(), sum));
        }
            return results;
    }
}
