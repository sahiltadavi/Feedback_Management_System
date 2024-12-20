package com.project.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbState {
	protected DbConnection d = DbConnection.getInstanceOf();
	protected PreparedStatement stmt = d.getPreapared();
	protected ResultSet rs = d.getResultSet();
	protected Connection con = d.getConnection();
}
