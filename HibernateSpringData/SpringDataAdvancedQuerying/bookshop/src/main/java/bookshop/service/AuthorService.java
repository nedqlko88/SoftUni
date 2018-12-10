package bookshop.service;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    List<String> getAuthorsByEnds(String firstName);

    List<String> getAuthorsWithTotalCopies();
}
