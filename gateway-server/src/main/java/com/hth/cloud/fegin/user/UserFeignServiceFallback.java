package com.hth.cloud.fegin.user;

import com.hth.cloud.common.base.HgResult;
import com.hth.cloud.common.exception.code.BaseResponseCode;
import com.hth.cloud.dto.user.RegisterReqDTO;
import com.hth.entity.user.SysUser;
import org.springframework.stereotype.Component;

/**
 * @ClassName: UserFeignServiceFallback
 * 用户类熔断回掉
 * @Author: huoth
 * @CreateDate: 2019/1/9 21:19
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/9 21:19
 * @Version: 0.0.1
 */
@Component
public class UserFeignServiceFallback implements IUserFeignService {
    /**
     * 通过用户名获得用户信息
     * @Author:      huoth
     * @CreateDate:  2019/1/9 22:10
     * @UpdateUser:
     * @UpdateDate:  2019/1/9 22:10
     * @Version:     0.0.1
     * @param username
     * @return       com.hth.cloud.common.base.HgResult<com.hth.entity.user.SysUser>
     * @throws
     */
    @Override
    public HgResult<SysUser> getUserInfoByName(String username) {

        return HgResult.getHgResult(BaseResponseCode.SERVICECALLEXCEPTION);
    }

    @Override
    public HgResult<String> addUser(RegisterReqDTO dto) {
        return HgResult.getHgResult(BaseResponseCode.SERVICECALLEXCEPTION);
    }
}
