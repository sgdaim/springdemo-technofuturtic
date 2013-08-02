package bbstorespringmvc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Book extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;


	@NotBlank(message = "You must enter an ISBN")  // Message shown by SpringMVC to the end user in case of invalid form.
	private String isbn;

	@NotBlank(message = "You must enter an title")  // Message shown by SpringMVC to the end user in case of invalid form.
	@Size(min = 2, message= "Your title must contain at least 2 characters")
    private String title;
	
    private String author;
    
    private int price;
    
    
    
    public Book(){}  // No-arg constructor needed by Hibernate.
    
    public Book(String isbn, String title, String author,int price) {  // Convenient to create test books by code.
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
