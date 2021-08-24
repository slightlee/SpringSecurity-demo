package com.morrow.entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 用户信息拓展
 */
@Getter
public class PlatformUserDetails extends User {

	private static final long serialVersionUID = 7936805097650040978L;

	/**
	 * 用户id
	 */
	private final Long id;

	/**
	 * 租户ID
	 */
	private final Long tenantId;

	/**
	 * 账号
	 */
	private final String account;

	/**
	 * 姓名
	 */
	private final String realName;

	/**
	 * 昵称
	 */
	private final String nickname;


	/**
	 * 头像
	 */
	private final String avatar;



	public PlatformUserDetails(Long id, Long tenantId, String nickname, String realName,
                               String avatar, String account, String password, boolean enabled, boolean accountNonExpired,
                               boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(account, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.id = id;
		this.tenantId = tenantId;
		this.nickname = nickname;
		this.account = account;
		this.realName = realName;
		this.avatar = avatar;
	}

}
