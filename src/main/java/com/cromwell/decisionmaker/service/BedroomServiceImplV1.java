package com.cromwell.decisionmaker.service;

import com.cromwell.decisionmaker.entity.Bedroom;
import com.cromwell.decisionmaker.repository.BedroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedroomServiceImplV1 implements BedroomService
{
	private final BedroomRepo bedroomRepo;

	@Autowired
	public BedroomServiceImplV1(BedroomRepo bedroomRepo)
	{
		this.bedroomRepo = bedroomRepo;
	}

	@Override
	public List<Bedroom> all()
	{
		return bedroomRepo.all();
	}

	@Override
	public Integer count()
	{
		return bedroomRepo.count();
	}

	@Override
	public void create(Bedroom bedroom)
	{
		bedroomRepo.create(bedroom);
	}

	@Override
	public Bedroom retrieve(int id)
	{
		return bedroomRepo.retrieve(id);
	}

	@Override
	public void update(Bedroom bedroom)
	{
		bedroomRepo.update(bedroom);
	}

	@Override
	public void delete(int id)
	{
		bedroomRepo.delete(id);
	}
}
