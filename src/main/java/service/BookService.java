package service;

import DAO.BookDAO;
import DAO.IBookDAO;
import model.Book;

import java.util.List;

public class BookService implements IBookService {
    IBookDAO bookDAO = new BookDAO();
    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public void add(Book object) {

    }

    @Override
    public Book findById(int id) {
        return bookDAO.findById(id);
    }

    @Override
    public void update(Book object) {

    }

    @Override
    public void remove(int id) {

    }
}
