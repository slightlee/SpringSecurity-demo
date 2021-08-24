package com.morrow.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.morrow.entity.PlatformUser;
import com.morrow.entity.PlatformUserDetails;
import com.morrow.mapper.PlatformUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserDetailServiceImpl implements UserDetailsService {


    private final PlatformUserMapper platformUserMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        PlatformUser user = platformUserMapper.selectOne(new LambdaQueryWrapper<PlatformUser>().eq(PlatformUser::getAccount, username));

        if(user != null){

            //返回oauth2的用户
            return new PlatformUserDetails(
                    user.getId(), user.getTenantId(),
                    user.getNickname(), user.getRealName(),
                    user.getAvatar(), user.getAccount(), user.getPassword(), !String.valueOf(0).equals(user.getStatus()), true, true, true,
                    AuthorityUtils.createAuthorityList("USER")
            ) ;
        }else{
            throw  new UsernameNotFoundException("用户["+username+"]不存在");
        }
    }


}
