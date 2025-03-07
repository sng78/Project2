package io.github.sng78.services;

import io.github.sng78.models.Book;
import io.github.sng78.models.Person;
import io.github.sng78.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }


    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Book book) {
        repository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        updatedBook.setId(id);
        repository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }

    public Optional<Person> getOwner(int id) {
        Book book = repository.findById(id).orElse(null);
        return Optional.ofNullable(Objects.requireNonNull(book).getPerson());
    }

    @Transactional
    public void setBusy(int id, Person person) {
        findById(id).setPerson(person);
    }

    @Transactional
    public void setFree(int id) {
        findById(id).setPerson(null);
    }
}
