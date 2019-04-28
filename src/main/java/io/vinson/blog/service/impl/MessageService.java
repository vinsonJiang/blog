package io.vinson.blog.service.impl;

import io.vinson.blog.bean.MessageForListBean;
import io.vinson.blog.dao.MessageMapper;
import io.vinson.blog.domain.Message;
import io.vinson.blog.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService {
	@Autowired
	public MessageMapper messageMapper;

	@Override
	public void save(Message message) {
		messageMapper.insert(message);
	}

	@Override
	public void update(Message message) {
		messageMapper.updateByPrimaryKeySelective(message);
	}

	@Override
	public void delete(Message message) {
		messageMapper.deleteByPrimaryKey(message.getId());
	}

	@Override
	public void delete(Integer id) {
		messageMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Message find(Integer id) {
		return messageMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<MessageForListBean> loadForList(int i, int i1) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}


}
