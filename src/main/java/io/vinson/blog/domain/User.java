package io.vinson.blog.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;
	private String password;
	private String nickname;
	private String email;
	private Date birthday;
	private Boolean sex;
	private String avatar;
	private String address;
	private String phone;
	private String qq;
	private String sessionId;
	private String token;
	private Date tokenExpirationDate;
	private Date signUpDate;
	private Boolean isActive;
	private Date activeDate;
	private Long signInCount;
	private String currentSignInIp;
	private Date currentSignInDate;
	private String lastSignInIp;
	private Date lastSignInDate;
	private Date createDate;
	private Date updateDate;
}
