package com.gmail.yuomelyanchuk;

import java.util.Arrays;



public class Group {

	private Student[] students = new Student[10];

	public Group() {
		super();
	}

	public void addStudentToGroup(Student st) {
		try {
			if (st == null || st.getLastName() == null || st.getStudentCardNumber() == 0){
				throw new NullPointerException("first enter student lastname and student card number");
			}
				
			if (getStudentIndexByCardNumber(st.getStudentCardNumber()) != -1)
			{
				throw new IllegalArgumentException("student with card number already exists");
			}

			students[getFirstEmptyPlace()] = st;

		} catch (GroupIsFullException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private int getFirstEmptyPlace() throws GroupIsFullException {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				return i;
			}
		}
		throw new GroupIsFullException();
	}

	public void deleteStudentFromGroup(int studentCardNumber) {
		try {
			students[getStudentIndexByCardNumber(studentCardNumber)] = null;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	private int getStudentIndexByCardNumber(int studentCardNumber) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStudentCardNumber() == studentCardNumber) {
				return (i);
			}
		}
		return (-1);

	}

	public Student getStudentByCardNumber(int studentCardNumber) {
		try {
			return (students[getStudentIndexByCardNumber(studentCardNumber)]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("student with card " + studentCardNumber + " not exists");
		}
		return null;
	}

	public void getStudentsByLastName(String studentLastName) {
		int k = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getLastName().equals(studentLastName)) {
				System.out.println(students[i].toString());
				k++;
			}
		}
		if (k == 0) {
			System.out.println("students with lastname '"+studentLastName+"'not found");
		}
	}

	public void printAllGroup() {
		for (Student student : students) {
			if (student != null)
				System.out.println(student.toString());
		}
	}

	private Student[] getStudentsInGroup() {
		Student[] st = new Student[0];
		for (Student student : students) {
			if (student != null) {
				st = Arrays.copyOf(st, st.length + 1);
				st[st.length - 1] = student;
			}
		}
		return (st);
	}

	private Student[] sortByLastName(Student[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j].getLastName().compareTo(arr[j + 1].getLastName()) > 0) {
					Student t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
				}
			}
		}
		return (arr);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Student student : sortByLastName(getStudentsInGroup())) {
			sb.append(student.toString());
			sb.append(System.lineSeparator());
		}
		return (sb.toString());
	}

}
