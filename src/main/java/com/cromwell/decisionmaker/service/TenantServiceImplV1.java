package com.cromwell.decisionmaker.service;

import com.cromwell.decisionmaker.entity.Tenant;
import com.cromwell.decisionmaker.repository.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceImplV1 implements TenantService
{
	private final TenantRepo tenantRepo;

	@Autowired
	public TenantServiceImplV1(TenantRepo tenantRepo)
	{
		this.tenantRepo = tenantRepo;
	}

	@Override
	public List<Tenant> all()
	{
		return tenantRepo.all();
	}

	@Override
	public Integer count()
	{
		return tenantRepo.count();
	}

	@Override
	public void create(Tenant tenant)
	{
		tenantRepo.create(tenant);
	}

	@Override
	public Tenant retrieve(int id)
	{
		return tenantRepo.retrieve(id);
	}

	@Override
	public void update(Tenant tenant)
	{
		tenantRepo.update(tenant);
	}

	@Override
	public void delete(int id)
	{
		tenantRepo.delete(id);
	}
}
