package com.gossipgesse.jdbctojpa;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.swing.tree.RowMapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import jdk.jfr.Name;

@Entity
@NamedQuery(name="select_person",
query="select c from Person c")
public class Person {
	@Id
//	@Column(name="npersoncode")
	@GeneratedValue
	private int npersoncode ;
//	@Column(name="spersonname") 
	private String spersonname ;
	
	
//	@Column(name="nstatus") 
	private int nstatus =1;
	
	public Person() {
		System.out.println("hai.. we are in the public constructor....");
	}
	
	public Person(String spersonname,int nstatus) {
		this.spersonname=spersonname;
		this.nstatus=nstatus;
	}
	public Person(int npersoncode, String spersonname,int nstatus) {
		this.npersoncode=npersoncode;
		this.spersonname=spersonname;
		this.nstatus=nstatus;
	}

	public int getNpersoncode() {
		return npersoncode;
	}
	public void setNpersoncode(int npersoncode) {
		this.npersoncode = npersoncode;
	}
	public String getSpersonname() {
		return spersonname;
	}
	public void setSpersonname(String spersonname) {
		this.spersonname = spersonname;
	}
	public int getNstatus() {
		return nstatus;
	}
	public void setNstatus(int nstatus) {
		this.nstatus = nstatus;
	}

	/*
	 * @Override public Person mapRow(ResultSet rs, int rowNum) throws SQLException
	 * { Person person = new Person();
	 * person.setNpersoncode(rs.getInt("npersoncode"));
	 * person.setSpersonname(rs.getString("spersonname"));
	 * person.setNstatus(rs.getInt("nstatus")); return person; }
	 */
	@Override
	public String toString() {
		return "Person [npersoncode=" + npersoncode + ", spersonname=" + spersonname + ", nstatus=" + nstatus + "]";
	}
	
}
