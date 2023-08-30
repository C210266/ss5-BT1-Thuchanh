package ra.model.service;

import ra.model.dto.PersonDTOForm;
import ra.model.entity.Person;

import java.util.List;

public interface IPersonService {
    List<Person> findAll();

    Person findByID(Long id);

    void save(PersonDTOForm p);

    void delete(Long id);
}
