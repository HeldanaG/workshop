package com.pluralsight;

public class Book {

    private int id;
    private String isbn;
    private String title;
    private String checkedOutTo;
    private boolean isCheckedOut;

    public Book(int id, String isbn, String title) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;

        this.setCheckedOut(false);
        this.setCheckedOutTo("");
    }
    public void checkOut(String name){

        this.setCheckedOut(true);
        this.setCheckedOutTo(name);
    }

    public void checkIn(){

        this.setCheckedOut(false);
        this.setCheckedOutTo("");
    }


    public boolean isCheckedOut() {
        return this.isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return this.checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
