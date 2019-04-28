package io.vinson.blog.bean;

import java.io.Serializable;
import java.util.Date;

public class MessageForListBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nickname;
	private String content;
	private Date sendDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

}
