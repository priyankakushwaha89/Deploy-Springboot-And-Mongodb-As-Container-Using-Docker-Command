package com.example.springboot_mongodb_docker_compose_1.Repository;

import com.example.springboot_mongodb_docker_compose_1.Entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book,Integer>
{

    List<Book> findByName(String name);
}
