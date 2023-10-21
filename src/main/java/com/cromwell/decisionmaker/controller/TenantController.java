package com.cromwell.decisionmaker.controller;

import com.cromwell.decisionmaker.entity.Tenant;
import com.cromwell.decisionmaker.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/tenant")
public class TenantController
{
	private final TenantService tenantService;

	@Autowired
	public TenantController(TenantService tenantService)
	{
		this.tenantService = tenantService;
	}

	@GetMapping("/all")
	public List<Tenant> all()
	{
		return tenantService.all();
	}

	@GetMapping("/count")
	public Integer count()
	{
		return tenantService.count();
	}

	@PostMapping("/create")
	public void create(@RequestBody Tenant tenant)
	{
		tenantService.create(tenant);
	}

	@GetMapping("/retrieve/{id}")
	public Tenant retrieve(@PathVariable int id)
	{
		return tenantService.retrieve(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Tenant tenant)
	{
		tenantService.update(tenant);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id)
	{
		tenantService.delete(id);
	}
}
