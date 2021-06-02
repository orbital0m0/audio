package com.audio.util;

import javax.naming.Context;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBconnection {

public static Connection getCon() throws NamingException, SQLException {
		
		Context initCtx = new InitialContext();
		
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		
		DataSource ds = (DataSource)envCtx.lookup("jdbc/maria-audio");
		
		Connection conn = ds.getConnection();
		
		return conn;
	
	}
	
	
}
