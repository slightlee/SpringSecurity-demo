package com.morrow.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.morrow.entity.PlatformUser;
import com.morrow.mapper.PlatformUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserDetailServiceImpl implements UserDetailsService {


    private final PlatformUserMapper platformUserMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        PlatformUser platformUser = platformUserMapper.selectOne(new LambdaQueryWrapper<PlatformUser>().eq(PlatformUser::getAccount, username));

        // 此处简单模拟从数据库中获取数据操作
        return new User(platformUser.getAccount(),platformUser.getPassword(),true,true,true,true, AuthorityUtils.createAuthorityList("USER"));

    }


}
