package io.vinson.blog.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import io.vinson.blog.bean.ArticleDetailBean;
import io.vinson.blog.bean.ArticleForListBean;
import io.vinson.blog.bean.MessageForListBean;
import io.vinson.blog.bean.MessageReqBean;
import io.vinson.blog.domain.Article;
import io.vinson.blog.domain.Message;
import io.vinson.blog.service.IArticleService;
import io.vinson.blog.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController extends BaseController {
	private static final int INDEX_ARTICLES_LIMIT = 10;
	private static final int BLOG_ARTICLES_LIMIT = 6;

	private static final int MENU_ARTICLES_LIMIT = 5;
	private static final int MENU_ARCHIVES_LIMIT = 5;
	private static final int MENU_CATEGORIES_LIMIT = -1;

	private static final String MENU_URL_REGEXP = "/index|/article/(.*)|/blog";

	@Autowired
	private IArticleService articleService;
	@Autowired
	private IMessageService messageService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		List<ArticleForListBean> articles = articleService.loadForList(1, INDEX_ARTICLES_LIMIT, 0, null);
		model.addAttribute("articles", articles);
		return "index";
	}

	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String blog(@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "category", defaultValue = "0") int category, @RequestParam(value = "keywords", required = false) String keywords, Model model) {
		
		if(keywords==null || keywords.length()==0){
			keywords = null;
		}else{
			model.addAttribute("keywords", keywords);
			keywords = "%" + keywords + "%";
		}
		
		List<ArticleForListBean> articles = articleService.loadForList(page, BLOG_ARTICLES_LIMIT, category, keywords);
		long totalPage = (long) Math.ceil(articleService.countForList(category, keywords) * 1.0 / BLOG_ARTICLES_LIMIT);
		long startPage = 1;
		long endPage = totalPage;
		if (totalPage > 3) {
			if (page <= 2) {
				startPage = 1;
				endPage = 3;
			} else if (page > totalPage - 2) {
				startPage = totalPage - 2;
			} else {
				startPage = page - 1;
				endPage = page + 1;
			}
		}
		
		model.addAttribute("articles", articles);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("curCategory", category);
		return "blog";
	}

	@RequestMapping(value = "/article/{uuid}", method = RequestMethod.GET)
	public String article(@PathVariable("uuid") String uuid, Model model) {
		ArticleDetailBean article = articleService.findByUUid(uuid);
		Integer articleId = article.getId();
		Article art = Article.builder().build();
		art.setReadNumber(article.getReadNumber() + 1);
		art.setId(article.getId());
		articleService.update(art);
		
		model.addAttribute("article", article);
		return "article";
	}
	
	@ResponseBody
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public Map<String, Object> message(@Valid @ModelAttribute MessageReqBean messageReq) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		Message message = Message.builder()
				.content(messageReq.getContent())
				.sendDate(new Date())
				.nickname(messageReq.getNickname())
				.content(messageReq.getContent())
				.email(messageReq.getEmail())
				.isRead(false)
				.isVisible(true)
				.build();
		messageService.save(message);
		jsonMap.put("status", "1");
		jsonMap.put("result", "留言成功，管理员将在看到留言后回复你");
		
		return jsonMap;
	}

	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String message(Model model) {
		List<MessageForListBean> messages = messageService.loadForList(1, 1000);
		long count = messageService.count();
		model.addAttribute("messages", messages);
		model.addAttribute("count", count);
		return "message";
	}
	
}
