package WEBResources;

import Beans.Author;
import Beans.Book;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("")
public class Books {

    @PUT
    @Path("book")
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addBook(@org.jboss.resteasy.annotations.jaxrs.FormParam String title, @FormParam Long authorId) {
        Author author = Author.findById(authorId);
        if (author == null) {
            return;
        }
        Book book = new Book();
        book.title = title;
        book.author = author;
        book.persist();
    }

    @GET
    @Path("/book/GetBook")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> GetBook() {
        return Book.listAll();
    }


}
