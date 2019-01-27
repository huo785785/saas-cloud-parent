package com.hth.cloud.controller;

import com.hth.cloud.common.base.HgResult;
import com.hth.cloud.service.SysMenuService;
import com.hth.entity.user.SysMenu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: SysPermissionController
 * 权限控制器
 * @Author: huoth
 * @CreateDate: 2019/1/7 21:19
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/7 21:19
 * @Version: 0.0.1
 */
@RestController
@RequestMapping("/sys/menu")
@Slf4j
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;
    /**
     * 获取用户拥有的权限
     * @Author:      huoth
     * @CreateDate:  2019/1/8 22:58
     * @UpdateUser:
     * @UpdateDate:  2019/1/8 22:58
     * @Version:     0.0.1
     * @param userId
     * @return       com.hth.cloud.common.base.HgResult<java.util.List<com.hth.entity.user.SysPermission>>
     * @throws
     */
    @GetMapping("/info/list/{userId}")
    public HgResult<List<SysMenu>>getMenuByUserId(@PathVariable("userId")String userId){
        List<SysMenu> menus = sysMenuService.getMenuByUserId(userId);
        HgResult<List<SysMenu>>result=HgResult.success(menus);
        return result;
    }
    /**
     * 获取所有权限
     * @Author:      huoth
     * @CreateDate:  2019/1/8 22:59
     * @UpdateUser:
     * @UpdateDate:  2019/1/8 22:59
     * @Version:     0.0.1
     * @param
     * @return       com.hth.cloud.common.base.HgResult<java.util.List<com.hth.entity.user.SysPermission>>
     * @throws
     */
    @GetMapping("/info/list")
    public HgResult<List<SysMenu>>getAllMenu(){
        List<SysMenu> menus = sysMenuService.getAllMenu();
        HgResult<List<SysMenu>>result=HgResult.success(menus);
        return result;
    }
}
