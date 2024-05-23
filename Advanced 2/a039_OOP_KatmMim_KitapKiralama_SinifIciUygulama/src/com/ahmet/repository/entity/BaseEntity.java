package com.ahmet.repository.entity;

import static com.ahmet.utility.KitapUtility.*; // '.*' koyduk sonuna. Başına da 'static' ekledik. Böylelikle kodumuzda 'KitapUtility.idOlustur()' yerine sadece 'idOlustur()' yazabiliriz (static şeyler için). 

public class BaseEntity {
	Long id;
	Long createDate;
	Long updateDate;
	boolean isActive;
	int state;
	
	// CONSTRUCTOR 1:
	public BaseEntity() {
		id = idOlustur();
		createDate = System.currentTimeMillis();
		updateDate = System.currentTimeMillis();
	}
	
	// GETTERS AND SETTERS:
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
