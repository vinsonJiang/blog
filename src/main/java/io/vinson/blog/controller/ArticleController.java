package io.vinson.blog.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import io.vinson.blog.bean.ArticleReqBean;
import io.vinson.blog.domain.Article;
import io.vinson.blog.manager.UserManager;
import io.vinson.blog.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/articles")
public class ArticleController extends BaseController {

	@Autowired
	private IArticleService articleService;
	@Autowired
	private UserManager userManager;
 
	private Integer getCurUserId() {
        Integer userId = userManager.getUserId();
        return userId;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
    	if(getCurUserId()==null){
    		return "";
    	}
		List<Article> articles = articleService.load(page, LIMIT);
		model.addAttribute("articles", articles);
		return "articles/index";
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Map<String, Object> list(@RequestParam(value = "curPage", defaultValue = "1") int curPage, @RequestParam(value = "limit", defaultValue = "10") int limit) {
    	if(getCurUserId()==null){
    		return null;
    	}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<Article> articles = articleService.load(curPage, limit);
		long count = articleService.count();
		
		jsonMap.put("rows", articles);
		jsonMap.put("total", count);
		
		return jsonMap;
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Article show(@PathVariable("id") int id) {
    	if(getCurUserId()==null){
    		return null;
    	}
		Article article = articleService.find(id);
		return article;
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void create(@RequestBody ArticleReqBean articleBean) {
    	if(getCurUserId()==null){
    		return;
    	}
		System.out.println(articleBean.toString());
		Article article = articleBean.toModel();
		UUID uuid = UUID.randomUUID();
		article.setUuid(uuid.toString());
		String month=(new SimpleDateFormat("yyyyMM")).format(article.getPublishDate());
		article.setMonth(Integer.valueOf(month));

		if(article.getPassword()==null||article.getPassword().trim().length()<=0){
			article.setHasPassword(false);
		}else{
			article.setHasPassword(true);
		}
		
		article.setHasImage(false);
		
//		Document doc=Jsoup.parse(article.getContent());
//		String summary=doc.text();
//		summary=summary.substring(0, Math.min(200, summary.length()));
		
//		article.setSummary(summary);
		articleService.save(article);
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") Integer id, @RequestBody ArticleReqBean articleBean) {
    	if(getCurUserId()==null){
    		return;
    	}
		Article article = articleBean.toModel();
		article.setId(id);
		articleService.update(article);
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
    	if(getCurUserId()==null){
    		return;
    	}
		articleService.delete(id);
	}
	

}
