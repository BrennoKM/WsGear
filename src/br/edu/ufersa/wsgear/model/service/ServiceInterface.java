package br.edu.ufersa.wsgear.model.service;

public interface ServiceInterface<entity> {
	public boolean inserir (entity e);
	public boolean alterar (entity e);
	public boolean deletar (entity e);
}
