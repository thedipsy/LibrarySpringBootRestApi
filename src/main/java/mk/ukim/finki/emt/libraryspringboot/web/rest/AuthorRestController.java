package mk.ukim.finki.emt.libraryspringboot.web.rest;

import mk.ukim.finki.emt.libraryspringboot.model.Author;
import mk.ukim.finki.emt.libraryspringboot.model.dto.AuthorDto;
import mk.ukim.finki.emt.libraryspringboot.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/authors")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    private List<Author> findAll(){
        return authorService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestBody AuthorDto authorDto){
        return authorService.save(authorDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> edit(@PathVariable Long id,
                                     @RequestBody AuthorDto authorDto){
        return authorService.edit(id, authorDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteById(@PathVariable Long id){
        authorService.deleteById(id);
        if(authorService.findById(id).isEmpty()) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
