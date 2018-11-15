package com.mo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tcomplaint")
public class Complaint {

	@Id
	@GeneratedValue
	@Column(name="compid")
	private int compid;
	
	@Column(name="compdetails")
	private String compdetails;
	
	public Complaint(int compid, String compdetails) {
		super();
		this.compid = compid;
		this.compdetails = compdetails;
	}
	public int getCompid() {
		return compid;
	}
	public void setCompid(int compid) {
		this.compid = compid;
	}
	public String getCompdetails() {
		return compdetails;
	}
	public void setCompdetails(String compdetails) {
		this.compdetails = compdetails;
	}
}
