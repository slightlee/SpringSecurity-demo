package com.morrow.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.morrow.entity.PlatformUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Morrow
 * @since 2021-08-04
 */
@Mapper
public interface PlatformUserMapper extends BaseMapper<PlatformUser> {

}
