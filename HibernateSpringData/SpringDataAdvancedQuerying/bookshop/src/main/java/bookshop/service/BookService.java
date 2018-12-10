package bookshop.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> getAllBooksTitleAfter();

    Set<String> getAllAuthorsWithBookBefore(int year);

    List<String> getAllTitlesWithGivenAgeRestriction(String input);

    List<String> getAllGoldenWithLessThan5000Copies();

    List<String> getBooksWithPriceInRange(String n1, String n2);

    List<String> getBooksNotReleasedIn(String year);

    List<String> getBooksReleasedBefore(String date) throws ParseException;

    List<String> getBooksByGivenSubstring(String substring);

    List<String> getBookTitlesByGivenAuthorsLastNameSubstring(String substring);

    int getNumberOfBooksWithGivenLengthOfTitle(int length);

    String getReducedBook(String title);


}
