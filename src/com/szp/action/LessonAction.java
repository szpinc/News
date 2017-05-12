package com.szp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.ws.Action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.szp.service.LessonService;

public class LessonAction extends ActionSupport {
	/**
	 * 创建Properties对象
	 */
	private static  Properties properties = new Properties();
	
	/**
	 * 此Map集合用户存储教师名字的键值对
	 */
	private static Hashtable<String, String> nameMap;
	
	/**
	 * 获取HttpServletReuqest对象的Map
	 */
	private Map<String, Object> requestMap = (Map<String, Object>)ActionContext.getContext().get("request");
	
	/**
	 * 获取HttpServletSession对象的Map
	 */
	private Map<String, Object> session = ActionContext.getContext().getSession();
	
	/**
	 * 获取HttpServletReuqest对象getParameters()值
	 */
	private Map<String, Object> parameters = ActionContext.getContext().getParameters();
	
	/**
	 * 创建LessonService对象
	 */
	private LessonService lessonService = new LessonService();
	
	/**
	 * 初始化参数
	 */
	static {
		try {
			//读取配置文件
			properties.load(LessonAction.class.getResourceAsStream("/name-list.properties"));
			//将Properties对象强转至HashTable，因为Properties对象实现了HashTable接口
			 nameMap = (Hashtable<String,String>)((Map)properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 处理主页的Action操作
	 * @return
	 * @throws Exception
	 */
	public String getIndex () throws Exception {
		requestMap.put("nameMap", nameMap);
		return SUCCESS;
	}
	
	/**
	 * 处理课程数据
	 * @return
	 * @throws Exception
	 */
	public String getLesson () throws Exception {
		
		//根据教师id值获取名字
		String name = nameMap.get(parameters.get("id"));
		
		System.out.println(name);
		
		/*List<String> lessonNames = lessonService.getLessonNameListByTeacherName(name);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < lessonNames.size(); i++) {
			sb.append(i+"="+lessonNames.get(i));
			if (i!=lessonNames.size()-1) {
				sb.append(",");
			}
		}
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		writer.print(sb.toString());
		writer.flush();
		writer.close();*/
		
		return SUCCESS;
	}
	
	
	
}	
