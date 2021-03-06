package io.vinson.blog.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManager {
	public static final String USER_ID = "$userId";

	@Autowired
	HttpServletRequest request;

	public void login(Integer userId) {
		HttpSession session = getSession();
		session.setAttribute(USER_ID, userId);
		System.out.println("用户" + userId + "登录系统");
	}

	public void logout() {
		HttpSession session = getSession();
		Integer userId = (Integer) session.getAttribute(USER_ID);
		session.invalidate();
		System.out.println("用户" + userId + "注销系统");
	}

	public Integer getUserId() {
		HttpSession session = getSession();
		Integer userId = (Integer) session.getAttribute(USER_ID);
		return userId;
	}

	private HttpSession getSession() {
		return request.getSession();
	}
}
