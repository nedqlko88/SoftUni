package bookshop.controller;

import bookshop.service.AuthorService;
import bookshop.service.BookService;
import bookshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;

@Controller
public class BookshopController implements CommandLineRunner {
    private final CategoryService categoryService;
    private final BookService bookService;
    private final AuthorService authorService;


    @Autowired
    public BookshopController(CategoryService categoryService, BookService bookService, AuthorService authorService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.authorService.seedAuthors();
//        this.categoryService.seedCategories();
//        this.bookService.seedBooks();

//        List<String> bookTitles = this.bookService.getAllBooksTitleAfter();
//        System.out.println(String.join("\n",bookTitles));

        Set<String> bookAuthors = this.bookService.getAllAuthorsWithBookBefore(1990);
        System.out.println(String.join("\n",bookAuthors));
    }
}
