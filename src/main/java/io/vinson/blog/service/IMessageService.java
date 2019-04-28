package io.vinson.blog.service;

import io.vinson.blog.bean.MessageForListBean;
import io.vinson.blog.domain.Message;

import java.util.List;

public interface IMessageService {
	void save(Message message);
	void update(Message message);
	void delete(Message message);
	void delete(Integer id);
	Message find(Integer id);

    List<MessageForListBean> loadForList(int page, int limit);

	long count();
}
