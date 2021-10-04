package com.example.entity;

import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "d_sinhvien")
public class SinhVien {
	@Id
	@GeneratedValue
	private long id;
	private String firstname;
	private String lastname;
	private Long khoaId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Long getKhoaId() {
		return khoaId;
	}
	public void setKhoaId(Long khoaId) {
		this.khoaId = khoaId;
	}
	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", khoaId="
				+ khoaId + "]";
	}
	public SinhVien(long id, String firstname, String lastname, Long khoaId) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.khoaId = khoaId;
	}
	public SinhVien() {
		super();
	}
	
}
