package io.github.sng78.util;

import io.github.sng78.dao.PersonDao;
import io.github.sng78.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonDao personDao;

    @Autowired
    public PersonValidator(PersonDao personDao) {
        this.personDao = personDao;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        if (personDao.findByFullName(person.getFullName()).isPresent()) {
            errors.rejectValue("fullName", "","Человек с таким ФИО существует");
        }
    }
}
