package ru.innopolis.stc12.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Class models for {@User}
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "family_name")
    private String familyName;
    @Column(name = "age")
    private int age;
    private boolean isEnabled;
    private String gender;
    private String role;
    private String language;
    private String password;
    private String login;
    private String city;
    private int petId;
    private Date startDate;
    private Date lastEnter;

    public User(String name,
                String familyName,
                int age,
                boolean isEnabled,
                String gender,
                String role,
                String language,
                String password,
                String login,
                String city,
                int petId,
                Date startDate,
                Date lastEnter) {
        this.name = name;
        this.familyName = familyName;
        this.age = age;
        this.isEnabled = isEnabled;
        this.gender = gender;
        this.role = role;
        this.language = language;
        this.password = password;
        this.login = login;
        this.city = city;
        this.petId = petId;
        this.startDate = startDate;
        this.lastEnter = lastEnter;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getLastEnter() {
        return lastEnter;
    }

    public void setLastEnter(Date lastEnter) {
        this.lastEnter = lastEnter;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", age=" + age +
                ", isEnabled=" + isEnabled +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", language='" + language + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", city='" + city + '\'' +
                ", petId=" + petId +
                ", startDate=" + startDate +
                ", lastEnter=" + lastEnter +
                '}';
    }
}
