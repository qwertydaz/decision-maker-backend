package com.cromwell.decisionmaker.entity;

public record Tenant(int id, String name)
{
	@Override
	public String toString()
	{
		return "Tenant{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
