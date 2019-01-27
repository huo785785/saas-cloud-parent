package com.hth.cloud.service;

import com.hth.entity.user.SysMenu;

import java.util.List;

/**
 * @ClassName: SysMenuService
 * 资源权限接口
 * @Author: huoth
 * @CreateDate: 2019/1/8 22:28
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/8 22:28
 * @Version: 0.0.1
 */
public interface SysMenuService {
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
    List<SysMenu>getMenuByUserId(String userId);
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
