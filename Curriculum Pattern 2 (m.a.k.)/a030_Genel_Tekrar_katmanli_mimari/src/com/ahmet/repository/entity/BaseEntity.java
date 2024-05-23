package com.ahmet.repository.entity;
// Bu sınıfta bütün varlıklarda (Musteri, Urun, Satis) kullanacağımız ortak özellikleri (miras almak üzere) burada yazdık.
public class BaseEntity {
	private Long createDate;
	private Long updateDate;
	private int state; // 0-> pasif data. 1-> akftif data. 2-> silinmiş data
	
	// --- CONSTRUCTOR (with parameters): ---
	public BaseEntity(Long createDate, Long updateDate, int state) {
		super();
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.state = state;
	}
	
	// --- GETTERS & SETTERS: ---
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	
}
