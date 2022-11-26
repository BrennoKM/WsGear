package br.edu.ufersa.wsgear.exceptions;

public class UsernameNotFoundException extends Exception{
	public UsernameNotFoundException() {
		super("Nome do usuário não encontrado!");
	}

}
