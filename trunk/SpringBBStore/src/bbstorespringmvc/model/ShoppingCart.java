package bbstorespringmvc.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

public class ShoppingCart implements Serializable {  // Needs to implement Serializable (and ArrayList and Book too) because the session might be serialized by the web container (Tomcat).
    List<Book> bookList = new ArrayList<Book>();

    public void add(Book bk){
        bookList.add(bk);
    }
    
    public void remove(Book bk){
        bookList.remove(bk);
    }
    
    public List<Book> getBooks(){
        return bookList;
    }
    
    // easy to call from a JSP: $ {shoppingCart.totalPrice)
    public int getTotalPrice() {
        int tot= 0;
        for(Book bk : bookList){
            tot += bk.getPrice();
        }
        return tot;
    }
}
