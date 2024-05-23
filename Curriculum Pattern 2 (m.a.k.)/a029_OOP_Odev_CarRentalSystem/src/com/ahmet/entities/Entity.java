package com.ahmet.entities;

import java.util.UUID;

public class Entity {
	private int id;
	private UUID uuid;
	
	// Default Constructor:
	public Entity() {
		this.id = 0;
		this.uuid = UUID.randomUUID();
	}
	
	// Getters and Setters:
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	// --- Methods: ---
	public void printDetails() {
		System.out.println("ID: " + id);
		System.out.println("UUID " + uuid);
	}
	
	
}
