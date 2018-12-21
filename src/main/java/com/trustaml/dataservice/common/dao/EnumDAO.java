package com.trustaml.dataservice.common.dao;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface EnumDAO {
    String getCategoriesJson(String string) throws JsonParseException, JsonMappingException, IOException;
    String getCategoriesJsonByUserName(String string, String username) throws JsonParseException, JsonMappingException, IOException;
	String getUserScopeJson(long scope);
	String getCategoriesJsonAsKeyValue(String string) throws JsonParseException, JsonMappingException, IOException;
}