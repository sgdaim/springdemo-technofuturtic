package bbstorespringmvc.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Book extends BaseEntity implements Serializable{

	private String isbn;
    private String title;
    private String author;
    private int price;
    
    
    
    public Book(){}
    
    public Book(String isbn, String title, String author,int price){
        this.setIsbn(isbn);
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    

    public String toString() {
        return this.getTitle();
    }
}
