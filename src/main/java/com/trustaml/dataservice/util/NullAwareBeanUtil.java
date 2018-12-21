package com.trustaml.dataservice.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ContextClassLoaderLocal;

public class NullAwareBeanUtil extends BeanUtilsBean{
	private static final ContextClassLoaderLocal BEANS_BY_CLASSLOADER = new ContextClassLoaderLocal(){
		
		@Override
		protected Object initialValue(){
			return new NullAwareBeanUtil();
		}
		
	};
	public static NullAwareBeanUtil getInstance(){
		return  (NullAwareBeanUtil) BEANS_BY_CLASSLOADER.get();
	}
	
	@Override
	public void copyProperty(final Object dest, final String name,final Object value) throws IllegalAccessException,InvocationTargetException{
		if(value == null){
			return;
		}
		super.copyProperty(dest, name, value);
	}

}
