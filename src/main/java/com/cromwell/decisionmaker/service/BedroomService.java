package com.cromwell.decisionmaker.service;

import com.cromwell.decisionmaker.entity.Bedroom;

import java.util.List;

public interface BedroomService
{
	List<Bedroom> all();
	Integer count();
	void create(Bedroom bedroom);
	Bedroom retrieve(int id);
	void update(Bedroom bedroom);
	void delete(int id);
}
