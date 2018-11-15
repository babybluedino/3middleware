package com.mo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//JPA Java Persitence API - J2EE
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tcustomer")
public class Customer {
	
	private int cid;
	private String name;
	private Complaint comp;
	
	public Customer(int cid, String name, Complaint comp) {
		super();
		this.cid = cid;
		this.name = name;
		this.comp = comp;
	}
	
	@Id
	@GeneratedValue
	@Column(name="cid")
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	@Column(name="cname")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cust_comp")
	public Complaint getComp() {
		return comp;
	}
	public void setComp(Complaint comp) {
		this.comp = comp;
	}

}
