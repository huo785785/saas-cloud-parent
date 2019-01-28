package com.hth.cloud.fegin.user;

import com.hth.cloud.common.base.HgResult;
import com.hth.cloud.dto.user.RegisterReqDTO;
import com.hth.entity.user.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName: IUserFeignService
 * TODO:类文件简单描述
 * @Author: huoth
 * @CreateDate: 2019/1/9 21:51
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/9 21:51
 * @Version: 0.0.1
 */
@FeignClient(name = "user-api",fallback = UserFeignServiceFallback.class)
public interface IUserFeignService {
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
     @GetMapping("/sys/user/{username}")
     HgResult<SysUser> getUserInfoByName(@PathVariable("username") String username);

     @PostMapping("/sys/user/info")
     HgResult<String> addUser(@RequestBody RegisterReqDTO dto);
}
