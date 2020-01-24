package Services;

import Beans.Author;
import Beans.Book;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BookService {

    public BookService() {
    }

    public void addBook(@FormParam String title, @FormParam Long authorId) {
        Author author = Author.findById(authorId);
        if (author == null) {
            return;
        }
        Book book = new Book();
        book.title = title;
        book.author = author;
        book.persist();
    }

    public List<Book> GetBook() {
        return Book.listAll();
    }
}
