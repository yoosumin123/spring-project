package com.myspring.persisntence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTests {
	static {
		try {
			Class.forName("oracle.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try (
			Connection con = (Connection) DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"bg",
					"bg"
					)){
					System.out.println("INFO:" + con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
}
