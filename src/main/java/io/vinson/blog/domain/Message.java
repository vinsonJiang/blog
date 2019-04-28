package io.vinson.blog.domain;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer userId;
	private Integer type;
	private String content;
	private Date sendDate;
	private Boolean isRead;
	private Boolean isVisible;
	private String nickname;
	private String email;
	private Date createDate;
	private Date updateDate;
}
