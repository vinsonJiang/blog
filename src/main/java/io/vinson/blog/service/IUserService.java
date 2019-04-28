package io.vinson.blog.service;

import io.vinson.blog.domain.User;

import java.util.List;

public interface IUserService {
	void save(User user);
	void update(User user);
	void delete(User user);
	void delete(Integer id);
	public User find(Integer id);
}
