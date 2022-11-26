package br.edu.ufersa.wsgear.exceptions;

public class WrongPasswordException extends Exception{
		public WrongPasswordException() {
			super("Nome do usuário não encontrado!");
		}
}
