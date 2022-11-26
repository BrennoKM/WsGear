package br.edu.ufersa.wsgear.exceptions;

import java.sql.SQLException;

public class UserNotFoundException extends SQLException {
	public UserNotFoundException() {
		super("Nao foi possivel encontrar o usuario");
	}
}
