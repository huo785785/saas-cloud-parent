package com.hth.cloud.fegin.user;

import com.hth.cloud.common.base.HgResult;
import com.hth.cloud.common.exception.code.BaseResponseCode;
import com.hth.entity.user.SysMenu;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: MenuFeignServiceFallback
 * 权限类熔断回掉
 * @Author: huoth
 * @CreateDate: 2019/1/9 22:10
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/9 22:10
 * @Version: 0.0.1
 */
@Component
public class MenuFeignServiceFallback implements IMenuFeignService {
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
    @Override
    public HgResult<List<SysMenu>> getMenuByUserId(String userId) {
        return HgResult.getHgResult(BaseResponseCode.SERVICECALLEXCEPTION);
    }
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
    @Override
    public HgResult<List<SysMenu>> getAllMenu() {
        return HgResult.getHgResult(BaseResponseCode.SERVICECALLEXCEPTION);
    }
}
