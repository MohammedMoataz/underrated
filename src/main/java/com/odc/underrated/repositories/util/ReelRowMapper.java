package com.odc.underrated.repositories.util;

import com.odc.underrated.models.Reel;
import com.odc.underrated.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReelRowMapper implements RowMapper<Reel> {

	@Override
	public Reel mapRow(ResultSet rs, int rowNum) throws SQLException {
		Reel reel = new Reel();
		reel.setCaption(rs.getString("name"));
		reel.setLocation(rs.getString("location"));
		reel.setDate(rs.getDate("date").toLocalDate());
		reel.setLikes(rs.getInt("likes"));
		reel.setUser((User) rs.getObject("user"));
		return reel;
	}
}