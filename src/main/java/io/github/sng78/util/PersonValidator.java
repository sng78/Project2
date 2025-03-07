package io.github.sng78.util;

import io.github.sng78.models.Person;
import io.github.sng78.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonRepository repository;

    @Autowired
    public PersonValidator(PersonRepository repository) {
        this.repository = repository;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        if (repository.findByFullName(person.getFullName()).isPresent()) {
            errors.rejectValue("fullName", "", "Человек с таким ФИО существует");
        }
    }
}
