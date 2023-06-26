package com.koo.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.datasource.impl.OracleDataSource;

import org.apache.log4j.Logger;

import com.koo.framework.BaseTest;

public class DBUtils {
	private static Logger LOGGER = Logger.getLogger(DBUtils.class);
	
	Connection connection = null;
	ResultSet rs = null;
	Statement stmt = null;
	OracleConnection dbConn = null;
	
	public boolean setupDBUtills(String userName, String password, String envName) {
		boolean flag = true;
		String DBURL = null;
		try {
			if(envName.equals("TEST")) {
				DBURL = "jdbc:oracle:thin:@XXXX:1521/YYYYY";
			}else if(envName.equals("SIT")) {
				DBURL = "jdbc:oracle:thin:@XXXX:1521/YYYYY";
			} 
			
			if(dbConn==null || (! dbConn.isUsable())) {
				Properties info = new Properties();
				info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, userName);
				info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, password);
				info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");
				
				OracleDataSource oracleDataSource = new OracleDataSource();
				oracleDataSource.setURL(DBURL);
				oracleDataSource.setConnectionProperties(info);
				dbConn = (OracleConnection) oracleDataSource.getConnection();
				stmt = dbConn.createStatement();
			}
		}catch(SQLException e) {
			flag = false;
			e.printStackTrace();
		}		
		return flag;
	}
	
	public ResultSet getResultSet(String SQL) {
		try {
			rs = stmt.executeQuery(SQL);
		}catch(SQLException e) {
			e.printStackTrace();			
		}
		return rs;
	}
	
	public int updateDBRecords(String queryToUpdate) {
		int recordNum =0;
		try {
			recordNum = stmt.executeUpdate(queryToUpdate);
		}catch(SQLException e) {
			e.printStackTrace();			
		}
		return recordNum;
	}
	
	public boolean isConnection() {
		boolean flag = false;
		if(connection!= null) {
			try {
				flag = connection.isClosed();
			}catch(SQLException e) {
				flag = false;
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public void closeConnection() {
		if(connection!= null) {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public LinkedHashMap<Integer, HashMap<String, String>> getAllSQLRecords(String SQL){
		LinkedHashMap<Integer, HashMap<String, String>> allDBRecords = new LinkedHashMap<Integer, HashMap<String, String>>();
		ResultSetMetaData resultSetMetaData = null; 
		try {
			ResultSet resultSet = getResultSet(SQL);
			resultSetMetaData = resultSet.getMetaData();
			int colCount = resultSetMetaData.getColumnCount();
			HashMap<String, String> columns = null;
			int j=1;
			while(resultSet.next()) {
				columns = new HashMap<String, String>();
				for(int i=1; i<=colCount; i++) {
					columns.put(resultSetMetaData.getColumnName(i), resultSet.getString(resultSetMetaData.getColumnName(i)));
				}
				allDBRecords.put(j, columns);
				columns = null;
				j = j+1;
			}
			resultSet = null;
		}catch(SQLException e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Exception occurred in getAllSQLRecords for SQL:"+SQL+".Exception:"+e.getMessage(), false, null);
		}
		
		return allDBRecords;
	}
	
	public String getSingleDataFromSQLQuery(String SQL, String colName) {
		String dataVal = null;
		LinkedHashMap<Integer, HashMap<String, String>> testDBData;
		try {
			testDBData = getAllSQLRecords(SQL);
			if(testDBData.size()>=1) {
				dataVal = testDBData.get(1).get(colName);
			}
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Exception occurred in getSingleDataFromSQLQuery for SQL:"+SQL+" and column name:"+colName+".Exception:"+e.getMessage(), false, null);
		}
		
		return dataVal;
	}
	
	
}

