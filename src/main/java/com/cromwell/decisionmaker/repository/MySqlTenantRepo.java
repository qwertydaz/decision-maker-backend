package com.cromwell.decisionmaker.repository;

import com.cromwell.decisionmaker.entity.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MySqlTenantRepo implements TenantRepo
{
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public MySqlTenantRepo(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Tenant> all()
	{
		String sql = "SELECT * FROM tenant";
		return jdbcTemplate.query(sql, new TenantMapper());
	}

	@Override
	public Integer count()
	{
		String sql = "SELECT COUNT(*) AS Total FROM tenant";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void create(Tenant tenant)
	{
		String sql = "INSERT INTO tenant (tenant_name) VALUES (?)";
		jdbcTemplate.update(sql, tenant.name());
	}

	@Override
	public Tenant retrieve(int id)
	{
		String sql = "SELECT * FROM tenant WHERE tenant_id = ?";
		return jdbcTemplate.queryForObject(sql, new TenantMapper(), id);
	}

	@Override
	public void update(Tenant tenant)
	{
		String sql = "UPDATE tenant SET tenant_name = ? WHERE tenant_id = ?";
		jdbcTemplate.update(sql, tenant.name(), tenant.id());
	}

	@Override
	public void delete(int id)
	{
		String sql = "DELETE FROM tenant WHERE tenant_id = ?";
		jdbcTemplate.update(sql, id);
	}

	private static final class TenantMapper implements RowMapper<Tenant>
	{
		@Override
		public Tenant mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			return new Tenant(
					rs.getInt("tenant_id"),
					rs.getString("tenant_name")
			);
		}
	}
}
