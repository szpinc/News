package com.szp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.szp.service.Service;

import java.util.Properties;

public class BeanServiceTag extends SimpleTagSupport{
	
	private String className;
	private String filed;
	private String id;
	private String var;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getFiled() {
		return filed;
	}

	public void setFiled(String filed) {
		this.filed = filed;
	}
	
	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	private static Properties properties;
	
	static{
		properties = new Properties();
		try {
			properties.load(BeanServiceTag.class.getResourceAsStream("/bean-mapper.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void doTag() throws JspException, IOException {
		
		String serviceName = properties.getProperty(className);
		try {
			Class<?> serviceClass = Class.forName(serviceName);
			Service service = (Service)serviceClass.newInstance();
			Object obj = service.getById(Integer.parseInt(id));
			PageContext pageContext = (PageContext)getJspContext();
			pageContext.setAttribute(var, obj);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
