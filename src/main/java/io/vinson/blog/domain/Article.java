package io.vinson.blog.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String uuid;
	private String title;
	private Integer authorId;
	private Integer categoryId;
	private Date publishDate;
	private Integer month;
	private Long readNumber;
	private Long commentNumber;
	private Boolean isVisible;
	private Boolean canComment;
	private Boolean hasPassword;
	private String password;
	private Boolean hasImage;
	private Boolean hasVideo;
	private String cover;
	private String keywords;
	private String description;
	private String summary;
	private String content;
	private String markdown;
	private Boolean onTop;
	private Date createDate;
	private Date updateDate;
}
