package com.cromwell.decisionmaker.controller;

import com.cromwell.decisionmaker.entity.Bedroom;
import com.cromwell.decisionmaker.service.BedroomService;
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
@RequestMapping("/api/bedroom")
public class BedroomController
{
	private final BedroomService bedroomService;

	@Autowired
	public BedroomController(BedroomService bedroomService)
	{
		this.bedroomService = bedroomService;
	}

	@GetMapping("/all")
	public List<Bedroom> all()
	{
		return bedroomService.all();
	}

	@GetMapping("/count")
	public Integer count()
	{
		return bedroomService.count();
	}

	@PostMapping("/create")
	public void create(@RequestBody Bedroom bedroom)
	{
		bedroomService.create(bedroom);
	}

	@GetMapping("/retrieve/{id}")
	public Bedroom retrieve(@PathVariable int id)
	{
		return bedroomService.retrieve(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Bedroom bedroom)
	{
		bedroomService.update(bedroom);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id)
	{
		bedroomService.delete(id);
	}
}
