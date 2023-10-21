package com.cromwell.decisionmaker.service;

import com.cromwell.decisionmaker.entity.Tenant;

import java.util.List;

public interface TenantService
{
	List<Tenant> all();
	Integer count();
	void create(Tenant tenant);
	Tenant retrieve(int id);
	void update(Tenant tenant);
	void delete(int id);
}
