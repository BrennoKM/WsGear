package br.edu.ufersa.wsgear.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface BaseInterDAO<Entity> {
	public Connection getConnection();
	public boolean inserir (Entity e);
	public boolean deletar(Entity e);
	public boolean alterar(Entity e);
	public Entity findById(Entity e);
	public ResultSet findAll();
	public ResultSet findBySpecifiedField(Entity e, String field);
	public Entity findByNome(Entity e);
}
