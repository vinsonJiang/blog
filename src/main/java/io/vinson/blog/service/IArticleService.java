package io.vinson.blog.service;

import io.vinson.blog.bean.ArticleDetailBean;
import io.vinson.blog.bean.ArticleForListBean;
import io.vinson.blog.domain.Article;

import java.util.List;

public interface IArticleService {
	void save(Article article);
	void update(Article article);
	void delete(Article article);
	void delete(Integer id);

	List<Article> load(int curPage, int limit);

	long count();

	Article find(int id);

    List<ArticleForListBean> loadForList(int page, int blogArticlesLimit, int category, String keywords);

	double countForList(int category, String keywords);

	ArticleDetailBean findByUUid(String uuid);
}
