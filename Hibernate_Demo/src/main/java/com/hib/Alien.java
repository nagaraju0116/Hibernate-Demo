package com.hib;

import jakarta.persistence.*;


@Entity
/* to change table name and column names used this annotations  */
@Table(name="alien_new")
public class Alien {

	@Id
	@Column(name="a_id")
	private int aid;
	@Column(name="a_name")
	private String aname;
	private String tech;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", tech=" + tech + "]";
	}
	
}
