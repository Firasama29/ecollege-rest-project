package com.ecollege.exception;

public class StudentNotFoundException extends Exception {

	private static final long serialVersionUID = 7478812433781821941L;

	public StudentNotFoundException(long studentId) {
		super(String.format("No student is found with id : '%s'", studentId));
	}

}
