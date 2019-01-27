package com.hth.cloud.service.impl;

import com.hth.cloud.mapper.SysMenuMapper;
import com.hth.cloud.service.SysMenuService;
import com.hth.entity.user.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: SysMenuService
 * 资源权限实现类
 * @Author: huoth
 * @CreateDate: 2019/1/8 22:29
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/8 22:29
 * @Version: 0.0.1
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

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
    @Override
    public List<SysMenu> getMenuByUserId(String userId) {

        return sysMenuMapper.getMenuByUserId(userId);
    }
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
    @Override
    public List<SysMenu> getAllMenu() {

        return sysMenuMapper.getAllMenu();
    }
}
