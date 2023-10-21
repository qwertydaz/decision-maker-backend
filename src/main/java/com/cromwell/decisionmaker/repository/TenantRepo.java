package com.cromwell.decisionmaker.repository;

import com.cromwell.decisionmaker.entity.Tenant;

import java.util.List;

public interface TenantRepo
{
	List<Tenant> all();
	Integer count();
	void create(Tenant tenant);
	Tenant retrieve(int id);
	void update(Tenant tenant);
	void delete(int id);
}
