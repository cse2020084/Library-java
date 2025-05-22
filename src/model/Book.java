package model;

public class Book {
    private final String bookId;
    private String bookTitle;
    private String authorName;
    private boolean isIssued;

    public Book(String bookId, String bookTitle, String authorName, boolean isIssued) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.isIssued = isIssued;
    }


    public String getBookId() {
        return bookId;
    }


    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", authorName=" + authorName + ", isIssued="
                + isIssued + "]";
    }


}
