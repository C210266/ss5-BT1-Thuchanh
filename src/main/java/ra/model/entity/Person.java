package ra.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String avatar;
    private boolean sex;
    private String address;

    public Person(Long id, String name, int age, String avatar, boolean sex, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.avatar = avatar;
        this.sex = sex;
        this.address = address;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void copy(Person p){
        this.id=p.getId();
        this.name=p.getName();
        this.age=p.getAge();
        this.address=p.getAddress();
        this.avatar=p.getAvatar();
        this.sex=p.isSex();
    }
}
