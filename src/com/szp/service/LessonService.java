package com.szp.service;

import java.util.ArrayList;
import java.util.List;

import com.szp.dao.BaseDao;
import com.szp.entity.Lesson;
import com.szp.util.JdbcUtil;

public class LessonService {
	private BaseDao baseDao = new BaseDao(JdbcUtil.getQueryRunner());
	private String sql;

	public void add(Lesson lesson) {
		sql = "INSERT INTO lesson_list(lessonName,teacherName,className,classroomName,week,section) VALUES(?,?,?,?,?,?)";
		baseDao.update(sql, lesson.getLessonName(), lesson.getTeacherName(), lesson.getClassName(),
				lesson.getClassroomName(), lesson.getWeek(), lesson.getSection());
	}

	public Lesson getByid(int id) {
		sql = "SELECT * FROM lesson_list WHERE id=?";
		return baseDao.queryBean(sql, Lesson.class, id);
	}

	public List<Lesson> getAll() {
		return baseDao.query("SELECT * FROM lesson_list", Lesson.class);
	}
	
	public List<Lesson> getByTeacherName (String teacherName) {
		sql = "SELECT * FROM lesson_list WHERE teacherName=?";
		return baseDao.query(sql, Lesson.class, teacherName);
	}
	
	public List<Lesson> getByLessonName (String lessonName, String teacherName) {
		sql = "SELECT * FROM lesson_list WHERE lessonName=? AND teacherName=?";
		return baseDao.query(sql, Lesson.class, lessonName,teacherName);
	}
	
	public List<String> getLessonNameListByTeacherName (String teacherName ) {
		
		List<Lesson> query = baseDao.query("select * from lesson_list where teacherName=? group by lessonName", Lesson.class, teacherName);
		List<String> list = new ArrayList<String>();
		for (Lesson lesson : query) {
			list.add(lesson.getLessonName());
		}
		return list;
	}
	
	public boolean isFree (String teacherName, int week, int section) {
		Lesson query = baseDao.queryBean("select * from lesson_list where  teacherName=? and (week=? and section=?)", Lesson.class,teacherName,week,section);
		return query==null;
	}
	
	public void setLinstenGuy (int id, String name01,String name02) {
		sql = "update lesson_list set isListen=1,listenGuy1=?,listenGuy2=? where id=?";
		baseDao.update(sql, name01,name02,id);
	}
	
	public boolean isListen (String lessonName) {
		
		sql = "SELECT * FROM lesson_list WHERE isListen=1 AND lessonName=?";
		Lesson result = baseDao.queryBean(sql, Lesson.class, lessonName);
		return result!=null;
	}
	
	public List<Lesson> getAllListen () {
		sql = "SELECT * FROM lesson_list WHERE isListen=1";
		return baseDao.query(sql, Lesson.class);
	}
	

}
