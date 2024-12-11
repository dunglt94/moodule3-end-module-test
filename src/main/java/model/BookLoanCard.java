package model;

import java.util.Date;

public class BookLoanCard {
    private int id;
    private String code;
    private int bookId;
    private int studentId;
    private boolean status;
    private Date loanDate;
    private Date returnDate;

    public BookLoanCard() {}

    public BookLoanCard(String code, int bookId, int studentId, boolean status, Date loanDate, Date returnDate) {
        this.code = code;
        this.bookId = bookId;
        this.studentId = studentId;
        this.status = status;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public BookLoanCard(int id, String code, int bookId, int studentId, boolean status, Date loanDate, Date returnDate) {
        this.id = id;
        this.code = code;
        this.bookId = bookId;
        this.studentId = studentId;
        this.status = status;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
