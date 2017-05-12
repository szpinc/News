package com.szp.service;

import java.util.List;

import com.szp.entity.User;

public class UserService extends BaseService implements Service<User> {

	private String sql;
	
	@Override
	public void add(User user) {
		sql = "INSERT INTO user(username,password,email,nickname,register_time) VALUES(?,MD5(?),?,?,NOW())";
		dao.update(sql, user.getUsername(),user.getPassword(),user.getEmail(),user.getNickname());
	}

	@Override
	public void delete(int id) {
		sql = "DELETE FROM user WHERE id=?";
		dao.update(sql, id);
	}

	@Override
	public void update(User user) {
		sql = "UPDATE user SET username=?,password=?,email=?,nickname=?,logoPath=? WHERE id=?";
		dao.update(sql, user.getUsername(),user.getPassword(),user.getEmail(),user.getNickname(),user.getLogoPath(),user.getId());
	}

	@Override
	public User getById(int id) {
		sql = "SELECT * FROM user WHERE id=?";
		return dao.queryBean(sql, User.class, id);
	}

	@Override
	public List<User> getAll() {
		return queryAll("user", User.class);
	}
}
