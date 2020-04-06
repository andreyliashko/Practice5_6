package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final EntityManager entityManager;
    @Transactional
    public Book createUser(String name, String ibsn, String author){
        Book book=new Book(name, ibsn, author);
      return entityManager.merge(book);
    };
    public Book getBookById(Integer id){
        return entityManager.find(Book.class, id);
    }
    public List<Book> getAllUsers(){
        return entityManager.createQuery("FROM Book", Book.class).getResultList();
    }
    public long count(){
        return  entityManager.createQuery("select COUNT(b) FROM Book b", Long.class).getSingleResult();
    }
    public Book findByName(String name){
        return entityManager.createNamedQuery(Book.Find_By_Name, Book.class).setParameter("name", name).getSingleResult();
    }
    public Book findByIbsn(String ibsn){
        return entityManager.createNamedQuery(Book.Find_By_Ibsn, Book.class).setParameter("ibsn", ibsn).getSingleResult();
    }
    public Book findByAuthor(String author){
        return entityManager.createNamedQuery(Book.Find_By_Author, Book.class).setParameter("author", author).getSingleResult();
    }

}
