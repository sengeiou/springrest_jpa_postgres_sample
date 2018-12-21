package com.trustaml.dataservice.common.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("enumDAO")
public class EnumDAOImplementation implements EnumDAO {
	/*
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
*/
	
	// method for ScreeningRequest Enum values
	// Before selecting data from the tables, it's good to check availability
	// of the related table.
	@Override
	public String getCategoriesJson(String string)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readValue(string, JsonNode.class);
		JsonNode enums = jsonNode.get("data");
		String string1 = "";
		for (JsonNode node : enums) {
			String enumCategory = ("enum_" + (node.textValue().replace("-", "_")) + "()");
			String str = "";
			try{
//			str = jdbcTemplate.queryForObject("SELECT * FROM " + enumCategory, String.class) + ",";
			}catch(Exception e){
			    e.printStackTrace();
			}
			// System.out.println("Categories retrieved: " + str);
			string1 += str.replace("enum_range", node.textValue()).replace("{", "").replace("}", "");
		}
		string1 = ("{\"data\":{" + string1.substring(0, string1.length() - 1) + "}}");
		return string1;

	}
	
	@Override
	public String getCategoriesJsonByUserName(String string, String username)
			throws JsonParseException, JsonMappingException, IOException {
		String result = "";
		String enumCategory = "enum_"+string.replace("-", "_");
		CallableStatement stmt = null;
		Connection con = null;
		try {
//			con = jdbcTemplate.getDataSource().getConnection();
			stmt = con.prepareCall("{call " + enumCategory+"(?,?)}");
			stmt.setString(1, username);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			stmt.executeUpdate();
			result = stmt.getString(2);
		} catch (SQLException e) {
			e.getErrorCode();
		}finally {
			try{
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	@Override
	public String getUserScopeJson(long scope) {
		Connection connection = null;
		String result = "";		
		try{
//			connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement stmt = null;	
			stmt = connection.prepareCall("{call enum_user_scope(?,?)}");
			stmt.setLong(1, scope);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			stmt.executeUpdate();
			result = stmt.getString(2);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public String getCategoriesJsonAsKeyValue(String string)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readValue(string, JsonNode.class);
		JsonNode enums = jsonNode.get("data");
		String string1 = "";
		for (JsonNode node : enums) {
			String enumCategory = ("enum_" + (node.textValue().replace("-", "_")) + "()");
			String str = "";
			try{
//			str = jdbcTemplate.queryForObject("SELECT * FROM " + enumCategory, String.class) + ",";
			//System.out.println(str);
			}catch(Exception e){
			    e.printStackTrace();
			}
			//string1 += str.replace("enum_range", node.textValue()).replace("{", "").replace("}", "");
			string1 += str;
		}
		string1 = ("{\"data\":" + string1.substring(0, string1.length() - 1) + "}");
		return string1;
		
	}

}
