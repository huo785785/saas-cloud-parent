package com.hth.cloud.mapper;

import com.hth.entity.user.SysUser;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    /**
     * 通过用户查找用户信息
     * @Author:      huoth
     * @CreateDate:  2019/1/8 22:51
     * @UpdateUser:
     * @UpdateDate:  2019/1/8 22:51
     * @Version:     0.0.1
     * @param userName
     * @return       com.hth.entity.user.SysUser
     * @throws
     */
    SysUser getUserInfoByName(String userName);
    
    /**
     * 分页获取用户
     * @Author:      huoth
     * @CreateDate:  2019/1/18 16:30
     * @UpdateUser:  
     * @UpdateDate:  2019/1/18 16:30
     * @Version:     0.0.1
     * @param null
     * @return       
     * @throws       
     */
    List<SysUser>getUserList();
}