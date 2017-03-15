package com.gmail.yuomelyanchuk;

public class Student extends Human {
	private int studentCardNumber;
	private double averageScore;
	public Student() {
		super();
		
	}
	public int getStudentCardNumber() {
		return studentCardNumber;
	}
	public void setStudentCardNumber(int studentCardNumber) {
		try{
		if(studentCardNumber<1) throw new IllegalArgumentException("card number mest be greater then 0");
		this.studentCardNumber = studentCardNumber;
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}
	public double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}
	@Override
	public String toString() {
		return super.toString()+", studentCardNumber=" + studentCardNumber + ", averageScore=" + averageScore  ;
	}
	
	
	

}
