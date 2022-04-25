package mk.ukim.finki.emt.libraryspringboot.model.dto;

import lombok.Data;
import mk.ukim.finki.emt.libraryspringboot.model.enumeration.Category;

@Data
public class BookDto {

    private String name;
    private Category category;
    private Integer quantity;
    private Long authorId;
    private int availableCopies;

    public BookDto(String name, Category category, Integer quantity, Long authorId, int availableCopies) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }

    public BookDto() {
    }


}
