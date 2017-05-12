package com.szp.entity;

public class Lesson {
	
	private int id;
	private String lessonName;
	private String teacherName;
	private String className;
	private String classroomName;
	private int week;
	private int section;
	private int isListen;
	private String listenGuy1;
	private String listenGuy2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassroomName() {
		return classroomName;
	}
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	
	public int getIsListen() {
		return isListen;
	}
	public void setIsListen(int isListen) {
		this.isListen = isListen;
	}
	public String getListenGuy1() {
		return listenGuy1;
	}
	public void setListenGuy1(String listenGuy1) {
		this.listenGuy1 = listenGuy1;
	}
	public String getListenGuy2() {
		return listenGuy2;
	}
	public void setListenGuy2(String listenGuy2) {
		this.listenGuy2 = listenGuy2;
	}
	@Override
	public String toString() {
		
		return "["+lessonName+","+teacherName+","+className+","+classroomName+","+week+","+section+listenGuy1+listenGuy2+"]";
	}
	
}
