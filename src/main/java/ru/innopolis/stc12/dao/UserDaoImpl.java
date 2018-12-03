package ru.innopolis.stc12.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.mappers.UserMapper;
import ru.innopolis.stc12.pojo.User;

import java.util.List;

/**
 * Class for pets handler
 */
@Repository
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE user_id = ?", new Object[]{name}, new UserMapper());
    }

    @Override
    public User getUserByFamilyname(String familyName) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE family_name = ?", new Object[]{familyName}, new UserMapper());
    }

    @Override
    public User getUserById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE user_id = ?", new Object[]{id}, new UserMapper());
    }

    @Override
    public boolean createUser(User user) {
        jdbcTemplate.update("INSERT INTO users (name, family_name, age, is_enabled, gender, role, language, login, password, email, phone, city, pet_id, ava_link, is_deleted) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                user.getName(),
                user.getFamilyName(),
                user.getAge(),
                user.isEnabled(),
                user.getGender(),
                user.getRole(),
                user.getLanguage(),
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(),
                user.getCity(),
                user.getPetId(),
                user.getAvaLink(),
                user.isDeleted());
        return true;
    }

    @Override
    public List<User> getUsersList() {
        return jdbcTemplate.query("SELECT * FROM users", new UserMapper());
    }

    @Override
    public User getUserByLogin(String login) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM users WHERE login = ?", new Object[]{login}, new UserMapper());
        } catch (EmptyResultDataAccessException ex) {
            // данная ошибка возникает, когда не найдены записи по параметру
            return null;
        }
    }

    @Override
    public User getUserByEmail(String login) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM users WHERE email = ?", new Object[]{login}, new UserMapper());
        } catch (EmptyResultDataAccessException ex) {
            // данная ошибка возникает, когда не найдены записи по параметру
            return null;
        }
    }

    @Override
    public boolean deleteUserById(int id) {
        return jdbcTemplate.update("DELETE FROM users WHERE user_id = ?", new Object[]{id}) == 1;
    }

    @Override
    public boolean deleteUserByName(String name) {
        return false;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "UPDATE users SET name = ?, family_name = ? , age = ?, is_enabled = ?, gender = ?, role = ?, language = ?, password = ?, login = ?, email = ?, phone = ?, city = ?, pet_id = ?, ava_link = ?, is_deleted = ? WHERE user_id = ? ";
        Object[] obj = new Object[]{
                user.getName(),
                user.getFamilyName(),
                user.getAge(),
                user.isEnabled(),
                user.getGender(),
                user.getRole(),
                user.getLanguage(),
                user.getPassword(),
                user.getLogin(),
                user.getEmail(),
                user.getPhone(),
                user.getCity(),
                user.getPetId(),
                user.getAvaLink(),
                user.isDeleted(),
                user.getId()};
        return jdbcTemplate.update(sql, obj) == 1;
    }

}
