package jpabook.jpashop.controller;

import javax.validation.constraints.Digits;
import jpabook.jpashop.domain.item.Book;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {

    private Long id;
    private String name;

    private int price;
    private int stockQuantity;

    private String author;
    private String isbn;

    public static Book createBook(BookForm form){
        Book book = new Book();
        book.setId(form.getId());
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsBn(form.getIsbn());
        return book;
    }

    public static BookForm toForm (Book book){
        BookForm form = new BookForm();
        form.setId(book.getId());
        form.setName(book.getName());
        form.setPrice(book.getPrice());
        form.setStockQuantity(book.getStockQuantity());
        form.setAuthor(book.getAuthor());
        form.setIsbn(book.getIsBn());
        return form;
    }
}
