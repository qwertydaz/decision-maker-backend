package com.cromwell.decisionmaker.repository;

import com.cromwell.decisionmaker.entity.Bedroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MySqlBedroomRepo implements BedroomRepo
{
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public MySqlBedroomRepo(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Bedroom> all()
	{
		String sql = "SELECT * FROM bedroom";
		return jdbcTemplate.query(sql, new BedroomMapper());
	}

	@Override
	public Integer count()
	{
		String sql = "SELECT COUNT(*) FROM bedroom";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void create(Bedroom bedroom)
	{
		String sql = "INSERT INTO bedroom (bedroom_name) VALUES (?)";
		jdbcTemplate.update(sql, bedroom.name());
	}

	@Override
	public Bedroom retrieve(int id)
	{
		String sql = "SELECT * FROM bedroom WHERE bedroom_id = ?";
		return jdbcTemplate.queryForObject(sql, new BedroomMapper(), id);
	}

	@Override
	public void update(Bedroom bedroom)
	{
		String sql = "UPDATE bedroom SET bedroom_name = ? WHERE bedroom_id = ?";
		jdbcTemplate.update(sql, bedroom.name(), bedroom.id());
	}

	@Override
	public void delete(int id)
	{
		String sql = "DELETE FROM bedroom WHERE bedroom_id = ?";
		jdbcTemplate.update(sql, id);
	}

	private static final class BedroomMapper implements RowMapper<Bedroom>
	{
		@Override
		public Bedroom mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			return new Bedroom(
					rs.getInt("bedroom_id"),
					rs.getString("bedroom_name")
			);
		}
	}
}
