package com.odc.underrated.repositories;

import com.odc.underrated.models.User;
import com.odc.underrated.repositories.util.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User createUser(User user) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.setGeneratedKeyName("id");

        Map<String, Object> data = new HashMap<>();
        data.put("full-name", user.getFullName());
        data.put("email", user.getEmail());
        data.put("password", user.getPassword());
        data.put("country", user.getCountry());

        ArrayList<String> columns = new ArrayList<>();
        columns.add("full-name");
        columns.add("email");
        columns.add("password");
        columns.add("country");

        insert.setTableName("users");
        insert.setColumnNames(columns);
        Number id = insert.executeAndReturnKey(data);

        return getUser(id.longValue());
    }

    @Override
    public User getUser(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new UserRowMapper(), id);
    }

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
    }

    @Override
    public User updateUser(User user) {
        jdbcTemplate.update(
                "update users" +
                        "set full-name = ?, email = ?, password = ?, country = ?" +
                        " where id = ?",
                user.getFullName(), user.getEmail(), user.getPassword(), user.getCountry(), user.getId()
        );

        return user;
    }

    @Override
    public void deleteUser(Long id) {
        NamedParameterJdbcTemplate namedTemplate =
                new NamedParameterJdbcTemplate(jdbcTemplate);

        Map<String, Long> paramMap = new HashMap<>();
        paramMap.put("id", id);

        namedTemplate.update("delete from users where id = :id", paramMap);
    }
}
