package com.ahmet.repository.entity;

import java.util.UUID;

public class BaseEntity {
	String id;
	Long createDate;
	Long updateDate;
	boolean isActive;
	int state;
	/* MUTLAKA BU ALANLARI OLUŞTURUN:
	 * Oluşturulma tarihi -> Long
	 * Güncelleme tarihi
	 * Kayıt aktif mi pasif mi.
	 * State 
	 */
	
	// CONSTRUCTOR:
	public BaseEntity() {
		id = UUID.randomUUID().toString();
		createDate = System.currentTimeMillis();
		updateDate = System.currentTimeMillis();
	}

	// GETTERS AND SETTERS:
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public Long getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Long updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
	
}
