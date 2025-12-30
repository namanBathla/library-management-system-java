package com.library.model;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String category;
    private int totalCount;
    private int availableCount;

    public Book(int bookId,String author, String title, String category, int totalCount, int availableCount) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.category = category;
        this.totalCount = totalCount;
        this.availableCount = availableCount;
    }
    public int getId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public int getTotalCount() { return totalCount; }
    public int getAvailableCount() { return availableCount; }
}
