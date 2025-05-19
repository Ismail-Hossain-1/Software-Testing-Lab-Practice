package org.example.BookLender;

public class Book {
    private String id;
    private String title;
    private  boolean isLent;
    private  String borrowerId;

    public Book(String id, String title, boolean isLent, String borrowerId) {
        this.id = id;
        this.title = title;
        this.isLent = isLent;
        this.borrowerId = borrowerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLent() {
        return isLent;
    }

    public void setLent(boolean lent) {
        isLent = lent;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }
}
