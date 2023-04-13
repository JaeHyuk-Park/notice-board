package db;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {

	public static Connection getConnection(){
		Connection con=null;
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQLD");
			con = ds.getConnection();
			con.setAutoCommit(false);
		} catch (Exception e) {
			System.out.print(e);
		}
		
		return con;
	}
	
	public static void close(Connection con){
		
		try {
			con.close();
		} catch (Exception e) {
		}
		
	}
	
	public static void close(Statement stmt){
		
		try {
			stmt.close();
		} catch (Exception e) {
		}
		
	}
	
	public static void close(ResultSet rs){
		
		try {
			rs.close();
		} catch (Exception e) {
		}
		
	}
	
	public static void commit(Connection con){
		
		try {
			con.commit();
		} catch (Exception e) {
			System.out.print(e);
		}
		
	}
	
	public static void rollback(Connection con){
		
		try {
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
