package com.cromwell.decisionmaker.entity;

public record Bedroom(int id, String name)
{
	@Override
	public String toString()
	{
		return "Bedroom{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
