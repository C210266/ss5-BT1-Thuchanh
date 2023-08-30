package ra.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class PersonDTOForm {
    private Long id;
    private String name;
    private int age;
    private MultipartFile avatar;
    private boolean sex;
    private String address;

    public PersonDTOForm(Long id, String name, int age, MultipartFile avatar, boolean sex, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.avatar = avatar;
        this.sex = sex;
        this.address = address;
    }

    public PersonDTOForm() {
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

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
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
}
