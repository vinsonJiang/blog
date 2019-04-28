package io.vinson.blog.service.impl;

import io.vinson.blog.dao.UserMapper;
import io.vinson.blog.domain.User;
import io.vinson.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public void save(User user) {
		userMapper.insert(user);
	}

	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void delete(User user) {
		userMapper.deleteByPrimaryKey(user.getId());
	}

	@Override
	public void delete(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User find(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

}
