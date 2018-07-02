package com.example.jackrode31.parcial3;

public class Books {
    private long isbn;
    private String autor;
    private String title;
    private String año;
    private String editorial;
    private String area;

    public Books(long isbn, String autor, String title, String año, String editorial, String area){
        this.isbn = isbn;
        this.autor = autor;
        this.title = title;
        this.año = año;
        this.editorial = editorial;
        this.area = area;

    }

    public long getisbn() {
        return isbn;
    }

    public void setisbn(long isbn) {
        this.isbn = isbn;
    }

    public String getautor() {
        return autor;
    }

    public void setautor(String autor) {
        this.autor = autor;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getaño() {
        return año;
    }

    public void setaño(String año) {
        this.año = año;
    }

    public String geteditorial() {
        return editorial;
    }

    public void seteditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getarea() {
        return area;
    }

    public void setarea(String area) {
        this.area = area;
    }

    public String toString(){
        return "ISBN: "+getisbn()+ "\n" +
                "Autor: "+getautor() + "\n" +
                "Título: "+gettitle() + "\n" +
                "Año: "+getaño()+"\n"+
                "Editorial: "+geteditorial() + "\n" +
                "Area: "+getarea();


    }
}