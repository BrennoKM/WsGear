package br.edu.ufersa.wsgear.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO<Entity> implements BaseInterDAO<Entity> {
	private Connection con;

	synchronized public Connection getConnection() {
		if (con == null) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/wsgear_db", "root", "admin");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		} else
			return con;
	}

	public boolean inserir(Entity e) {
		return false;
	}

	public boolean deletar(Entity e) {
		return false;
	}

	public boolean alterar(Entity e) {
		return false;
	}

	public Entity findById(Entity e) {
		return null;
	}

	public ResultSet findAll() {
		return null;
	}

	public ResultSet findBySpecifiedField(Entity e, String field) {
		return null;
	}

	@Override
	public Entity findByNome(Entity e) {
		// TODO Auto-generated method stub
		return null;
	}
}
