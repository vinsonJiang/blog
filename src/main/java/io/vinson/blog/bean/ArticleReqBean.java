package io.vinson.blog.bean;

import java.io.Serializable;
import java.util.Date;

import io.vinson.blog.domain.Article;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Builder
@Getter
@Setter
@ToString
public class ArticleReqBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String title;
	private Integer authorId;
	private Integer categoryId;
	private Boolean isVisible;
	private Boolean canComment;
	private String password;
	private String cover;
	private String keywords;
	private String description;
	private String content;
	private String markdown;
	private Boolean onTop;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date publishDate;
	private Integer readNumber;
	private Integer commentNumber;

	public Article toModel() {
		Article model = Article.builder()
				.title(title)
				.authorId(authorId)
				.categoryId(categoryId)
				.isVisible(isVisible)
				.canComment(canComment)
				.password(password)
				.cover(cover)
				.keywords(keywords)
				.description(description)
				.content(content)
				.markdown(markdown)
				.onTop(onTop)
				.publishDate(publishDate)
				.commentNumber(commentNumber.longValue())
				.readNumber(readNumber.longValue())
				.build();
		return model;
	}

}
