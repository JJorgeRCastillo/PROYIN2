package com.proyin.dao;

import java.sql.*;

public class Conexion {

	private static Conexion _instance;

	private Conexion() {
	}

	public static Conexion getInstance() {
		if (_instance == null) {
			_instance = new Conexion();
		}
		return _instance;
	}

	public Connection ConectarBD1() throws Exception {
		Connection objConexion = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			objConexion = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;"
							+ "databaseName=BDCooperativa", "sa", "123456");
		} catch (Exception ex) {
			throw ex;
		}
		return objConexion;
	}
	//  192.168.1.2  BDSanLorenzoLocal
	public Connection ConectarBD2() throws Exception {
		Connection objConexion = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			objConexion = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;"
							+ "databaseName=BDSanLorenzo", "sa", "123456");
		} catch (Exception ex) {
			throw ex;
		}
		return objConexion;
	}
	
}
