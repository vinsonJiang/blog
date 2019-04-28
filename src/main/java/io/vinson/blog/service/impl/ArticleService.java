package io.vinson.blog.service.impl;

import java.util.List;

import io.vinson.blog.bean.ArticleDetailBean;
import io.vinson.blog.bean.ArticleForListBean;
import io.vinson.blog.domain.Article;
import io.vinson.blog.service.IArticleService;
import org.springframework.stereotype.Service;


@Service
public class ArticleService implements IArticleService {

	@Override
	public void save(Article article) {

	}

	@Override
	public void update(Article article) {

	}

	@Override
	public void delete(Article article) {

	}

	@Override
	public void delete(Integer id) {

	}

	@Override
	public List<Article> load(int curPage, int limit) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public Article find(int id) {
		return null;
	}

	@Override
	public List<ArticleForListBean> loadForList(int page, int blogArticlesLimit, int category, String keywords) {
		return null;
	}

	@Override
	public double countForList(int category, String keywords) {
		return 0;
	}

	@Override
	public ArticleDetailBean findByUUid(String uuid) {
		return null;
	}
}
