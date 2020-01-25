package WEBResources;

import Beans.Book;
import Services.BookService;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("")
public class Books {

    @Inject
    BookService bookService;


    @PUT
    @RolesAllowed("user")
    @Path("book")
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addBook(@FormParam String title, @FormParam Long authorId){
        bookService.addBook(title,authorId);
        return Response.ok().status(201).build();
    }


    @GET
    @Path("/book/GetBook")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> GetBook() {
        return bookService.GetBook();
    }


}
