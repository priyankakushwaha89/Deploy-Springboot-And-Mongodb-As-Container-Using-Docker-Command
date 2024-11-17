package com.example.springboot_mongodb_docker_compose_1.Controller;

import com.example.springboot_mongodb_docker_compose_1.Entity.Book;
import com.example.springboot_mongodb_docker_compose_1.Repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController
{
    @Autowired
    BookRepository brepo;

    @RequestMapping("/test")
    public String test()
    {
        return "This is for the test";
    }

    @PostMapping("/save")
    public String saveData(@RequestBody Book book)
    {
       brepo.save(book);
       return "Data saved";
    }
    @GetMapping("/all")
    public List<Book> allInfo()
    {
        return brepo.findAll();
    }
    @GetMapping("/byname/{name}")
    public List<Book> byName(@PathVariable String name)
    {
        return brepo.findByName(name);
    }
    @GetMapping("/byId/{id}")
    public Optional<Book> byId(@PathVariable int id)
    {
        return brepo.findById(id);
    }
    @PutMapping("/upd/byId/{id}")
    public String UpdateById(@PathVariable int id,@RequestBody Book book)
    {
        Book b=brepo.findById(id).get();
        b.setId(book.getId());
        b.setName(book.getAuthor());
        b.setAuthor(book.getAuthor());
        brepo.save(b);
        return "Data updated";
    }

    @DeleteMapping("/del/{id}")
    public String deleteById(@PathVariable int id)
    {
        brepo.deleteById(id);
        return "Data deleted";
    }
}
