package ra.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import ra.model.dto.PersonDTOForm;
import ra.model.entity.Person;
import ra.model.repository.IPersonRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class PersonService implements IPersonService {
    private String pathUpload = "C:\\Users\\Admin\\IdeaProjects\\ORM-Myself\\src\\main\\webapp\\WEB-INF\\upload\\";
    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findByID(Long id) {
        return personRepository.findByID(id);
    }

    @Override
    public void save(PersonDTOForm p) {
        String fileName = null;
        try {
            if (!(p.getAvatar().isEmpty())) {
                fileName = p.getAvatar().getOriginalFilename();
                FileCopyUtils.copy(p.getAvatar().getBytes(), new File(pathUpload + fileName));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Person person = new Person(p.getId(), p.getName(), p.getAge(), fileName, p.isSex(), p.getAddress());
        personRepository.save(person);
    }

    @Override
    public void delete(Long id) {
        personRepository.delete(id);
    }
}
