package ro.fiipractic.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.fiipractic.repository.mapper.UserRowMapper;
import ro.fiipractic.exception.UserNotFoundException;
import ro.fiipractic.model.User;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM USER", new UserRowMapper());
    }

    public int createUser(String firstName, String  lastName, String email, String password) {
        return jdbcTemplate.update("INSERT INTO USER(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)", firstName, lastName, email, password);
    }

    public int updateUser(String firstName, String  lastName, String email, String password, Integer id) {
        return jdbcTemplate.update("UPDATE USER SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PASSWORD = ? WHERE ID = ?", firstName, lastName, email, password, id);
    }

    public int deleteUser(int id) {
        return jdbcTemplate.update("DELETE FROM USER WHERE ID = ?", id);
    }

    public User getUserById(Integer id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID = ?", new UserRowMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            throw new UserNotFoundException(String.format("User with id %s was not found", id));
        }
    }
}
