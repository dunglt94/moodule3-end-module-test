package DAO;

import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO {
    @SuppressWarnings("FieldCanBeLocal")
    private final String jdbcURL = "jdbc:mysql://localhost:3306/library_management";
    @SuppressWarnings("FieldCanBeLocal")
    private final String jdbcUsername = "root";
    @SuppressWarnings("FieldCanBeLocal")
    private final String jdbcPassword = "123456";

    private static final String SELECT_ALL_BOOKS = "SELECT * FROM book";
    private static final String INSERT_BOOK = "INSERT INTO book (name, author, description, quantity) VALUES (?,?,?,?)";
    private static final String SELECT_BOOK_BY_CODE = "SELECT * FROM book WHERE code = ?";
    private static final String UPDATE_BOOK = "call update_book(?,?,?,?,?)";
    private static final String DELETE_BOOK = "DELETE FROM book WHERE id = ?";


    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getString("description"),
                        rs.getInt("quantity")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void add(Book book) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK)) {
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getDescription());
            preparedStatement.setInt(4, book.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    @Override
    public Book findByCode(String code) {
        Book book = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_CODE)) {
            preparedStatement.setString(1, code);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println(preparedStatement);
                while (resultSet.next()) {
                    int bookId = resultSet.getInt("id");
                    String bookCode = resultSet.getString("code");
                    String bookName = resultSet.getString("name");
                    String author = resultSet.getString("author");
                    String description = resultSet.getString("description");
                    int quantity = resultSet.getInt("quantity");
                    book = new Book(bookId, bookCode, bookName, author, description, quantity);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public void update(Book object) {
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(UPDATE_BOOK)) {
            callableStatement.setString(1, object.getName());
            callableStatement.setString(2, object.getAuthor());
            callableStatement.setString(3, object.getDescription());
            callableStatement.setInt(4, object.getQuantity());
            callableStatement.setInt(5, object.getId());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }
}
