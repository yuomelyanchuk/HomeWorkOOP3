package com.gmail.yuomelyanchuk;

public class Main {

	public static void main(String[] args) {
		Student h = new Student();
		h.setBirthDay("01.02.2017");
		h.setLastName("");
		Group group = new Group();
		group.addStudentToGroup(null);
		for (int i = 1; i < 12; i++) {
			h = new Student();
			h.setAverageScore(3.5);
			h.setBirthDay("1.02.2017");
			h.setLastName(generateString());
			h.setStudentCardNumber(i);
			h.setFirstName(generateString());
			group.addStudentToGroup(h);
		}

		group.deleteStudentFromGroup(4);
		group.deleteStudentFromGroup(5);
		group.deleteStudentFromGroup(6);
		try {
			System.out.println(group.getStudentByCardNumber(11).toString());
		} catch (NullPointerException e) {
			e.getMessage();
		}

		h.setStudentCardNumber(11);
		group.addStudentToGroup(h);
		
		try {
			System.out.println(group.getStudentByCardNumber(11).toString());
		} catch (NullPointerException e) {
			e.getMessage();
		}

		System.out.println();
		group.getStudentsByLastName("hhhhhhh");
		System.out.println();
		group.getStudentsByLastName(group.getStudentByCardNumber(1).getLastName());
		System.out.println();

		group.printAllGroup();

		System.out.println();

		System.out.println(group.toString());
		System.out.println();
		group.printAllGroup();

	}

	public static String generateString() {
		int len = (int) (Math.random() * 20) + 1;
		char[] lName = new char[len];
		for (int i = 0; i < lName.length; i++) {
			lName[i] = (char) (Math.random() * ((int) 'z' - (int) 'a') + 97);
		}
		return (new String(lName));

	}

}
