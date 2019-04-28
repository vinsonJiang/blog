package io.vinson.blog.dao;

import io.vinson.blog.domain.Article;

public interface ArticleMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Article record);

	int insertSelective(Article record);

	Article selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Article record);

	int updateByPrimaryKey(Article record);

}
