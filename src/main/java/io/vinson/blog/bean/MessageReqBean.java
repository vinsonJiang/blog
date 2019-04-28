package io.vinson.blog.bean;

import java.io.Serializable;
import io.vinson.blog.domain.Message;

public class MessageReqBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;
	private String nickname;
	private String content;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Message toModel() {
		Message model = Message.builder()
				.email(email)
				.nickname(nickname)
				.content(content)
				.build();
		return model;
	}

}
