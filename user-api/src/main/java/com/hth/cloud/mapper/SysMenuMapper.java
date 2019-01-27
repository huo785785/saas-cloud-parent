package com.hth.cloud.mapper;

import com.hth.entity.user.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
    /**
     * 获取该用户的所有菜单权限
     * @Author:      huoth
     * @CreateDate:  2019/1/17 17:30
     * @UpdateUser:
     * @UpdateDate:  2019/1/17 17:30
     * @Version:     0.0.1
     * @param userId
     * @return       java.util.List<com.hth.entity.user.SysMenu>
     * @throws
     */
    List<SysMenu> getMenuByUserId(String userId);
    /**
     * 获取所有的菜单权限
     * @Author:      huoth
     * @CreateDate:  2019/1/17 17:30
     * @UpdateUser:
     * @UpdateDate:  2019/1/17 17:30
     * @Version:     0.0.1
     * @param
     * @return       java.util.List<com.hth.entity.user.SysMenu>
     * @throws
     */
    List<SysMenu>getAllMenu();
}