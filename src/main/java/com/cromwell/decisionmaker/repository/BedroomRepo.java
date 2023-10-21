package com.cromwell.decisionmaker.repository;

import com.cromwell.decisionmaker.entity.Bedroom;

import java.util.List;

public interface BedroomRepo
{
	List<Bedroom> all();
	Integer count();
	void create(Bedroom bedroom);
	Bedroom retrieve(int id);
	void update(Bedroom bedroom);
	void delete(int id);
}
