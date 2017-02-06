package org.springframework.social.es.user;

public class DuplicateEmailException extends Exception {

	public DuplicateEmailException(String message) {
		super(message);
	}
}
