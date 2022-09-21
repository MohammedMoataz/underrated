package com.odc.underrated.repositories;

import com.odc.underrated.models.Reel;
import com.odc.underrated.repositories.util.ReelRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("reelRepository")
public class ReelRepositoryImpl implements ReelRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Reel createReel(Reel reel) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

        insert.setGeneratedKeyName("id");

        Map<String, Object> data = new HashMap<>();
        data.put("video", reel.getVideo());
        data.put("caption", reel.getCaption());
        data.put("location", reel.getLocation());
        data.put("likes", reel.getLikes());
        data.put("date", reel.getDate());
        data.put("user", reel.getUser());

        List<String> columns = new ArrayList<>();
        columns.add("video");
        columns.add("caption");
        columns.add("location");
        columns.add("likes");
        columns.add("date");
        columns.add("user");

        insert.setTableName("reel");
        insert.setColumnNames(columns);
        Number id = insert.executeAndReturnKey(data);

        return getReel(id.longValue());
    }

    @Override
    public Reel getReel(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM reels WHERE id = ?", new ReelRowMapper(), id);
    }

    @Override
    public List<Reel> getReels() {
        return jdbcTemplate.query("SELECT * FROM reels", new ReelRowMapper());
    }

    @Override
    public Reel updateReel(Reel reel) {
        jdbcTemplate.update(
                "update reels" +
                        "set caption = ?, location = ?, date = ?, likes = ?" +
                        " where id = ?",
                reel.getCaption(), reel.getLocation(), reel.getDate(), reel.getLikes(), reel.getUser().getId()
        );

        return reel;
    }

    @Override
    public void deleteReel(Long id) {
        NamedParameterJdbcTemplate namedTemplate =
                new NamedParameterJdbcTemplate(jdbcTemplate);

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        namedTemplate.update("delete from reels where id = :id", paramMap);
    }
}
