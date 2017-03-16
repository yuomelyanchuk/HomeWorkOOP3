package com.gmail.yuomelyanchuk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Human {
	private String lastName;
	private String firstName;
	private Date birthDay;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
	public Human() {
		super();		
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		try{
		this.birthDay = sdf.parse(birthDay);
		}catch(ParseException e){
			System.out.println(e.getMessage()+System.lineSeparator()+"must be format dd.mm.yyyy");
		}
		
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	@Override
	public String toString() {
		return "lastName=" + lastName + ", firstName=" + firstName + ", birthDay=" + sdf.format(birthDay) ;
	}

}
