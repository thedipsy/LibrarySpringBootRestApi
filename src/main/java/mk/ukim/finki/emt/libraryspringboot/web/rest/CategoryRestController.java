package mk.ukim.finki.emt.libraryspringboot.web.rest;

import mk.ukim.finki.emt.libraryspringboot.model.enumeration.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/categories")
public class CategoryRestController {

    @GetMapping
    private List<Category> findAll(){
        return Arrays.asList(Category.values());
    }

}
