package controller;

import model.Book;
import service.BookService;
import service.IBookService;
import service.IStudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/books")
public class BookServlet extends HttpServlet {
    IBookService bookService = new BookService();
    IStudentService studentService = new

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":

                break;
            default:
                showBookList(req, resp);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "loan":
                showLoanFrom(req, resp );
            break;
            default:
                showBookList(req, resp);
                break;
        }
    }

    private void showBookList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Book> books = bookService.findAll();
        req.setAttribute("books", books);
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/list.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }
    private void showLoanFrom(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }
}
