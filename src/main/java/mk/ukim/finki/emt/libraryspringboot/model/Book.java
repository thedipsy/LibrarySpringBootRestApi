package mk.ukim.finki.emt.libraryspringboot.model;

import lombok.Data;
import mk.ukim.finki.emt.libraryspringboot.model.enumeration.Category;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;


    @ManyToOne
    private Author author;

    private int availableCopies;

    public Book() {
    }

    public Book(String name, Category category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
