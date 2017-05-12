package com.szp.service;

import java.util.List;

public interface Service<T> {
	
	public void add(T t);
	
	public void delete(int id);
	
	public void update(T t);
	
	public T getById(int id);
	
	public List<T> getAll();
	
	
}
