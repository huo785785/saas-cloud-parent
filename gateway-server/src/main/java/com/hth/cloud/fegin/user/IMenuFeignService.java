package com.hth.cloud.fegin.user;

import com.hth.cloud.common.base.HgResult;
import com.hth.entity.user.SysMenu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassName: IMenuFeignService
 * TODO:类文件简单描述
 * @Author: huoth
 * @CreateDate: 2019/1/9 22:16
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/9 22:16
 * @Version: 0.0.1
 */
@FeignClient(name = "user-api",fallback = MenuFeignServiceFallback.class)
public interface IMenuFeignService {
    /**
     * 获取该用户的所有菜单资源
     * @Author:      huoth
     * @CreateDate:  2019/1/18 9:51
     * @UpdateUser:
     * @UpdateDate:  2019/1/18 9:51
     * @Version:     0.0.1
     * @param userId
     * @return       com.hth.cloud.common.base.HgResult<java.util.List<com.hth.entity.user.SysMenu>>
     * @throws
     */
    @GetMapping("/sys/menu/info/list/{userId}")
    HgResult<List<SysMenu>> getMenuByUserId(@PathVariable("userId") String userId);
    /**
     * 获取所有的菜单资源
     * @Author:      huoth
     * @CreateDate:  2019/1/18 9:51
     * @UpdateUser:
     * @UpdateDate:  2019/1/18 9:51
     * @Version:     0.0.1
     * @param
     * @return       com.hth.cloud.common.base.HgResult<java.util.List<com.hth.entity.user.SysMenu>>
     * @throws
     */
    @GetMapping("/sys/menu/info/list")
    HgResult<List<SysMenu>> getAllMenu();

}
