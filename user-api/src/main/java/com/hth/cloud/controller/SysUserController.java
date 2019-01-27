package com.hth.cloud.controller;

import com.hth.cloud.common.base.HgResult;
import com.hth.cloud.common.util.PageVO;
import com.hth.cloud.dto.user.LoginReqDTO;
import com.hth.cloud.dto.user.RegisterReqDTO;
import com.hth.cloud.service.SysUserService;
import com.hth.cloud.vo.user.LoginRespVO;
import com.hth.entity.user.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName: SysUserController
 * 用户控制器
 * @Author: huoth
 * @CreateDate: 2019/1/8 22:52
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/8 22:52
 * @Version: 0.0.1
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 用户登录
     * @Author:      霍天豪
     * @CreateDate:  2019/1/27 21:36
     * @UpdateUser:
     * @UpdateDate:  2019/1/27 21:36
     * @Version:     0.0.1
     * @param dto
     * @return       com.hth.cloud.common.base.HgResult<com.hth.cloud.vo.user.LoginRespVO>
     * @throws
     */
    @PostMapping("/login")
    public HgResult<LoginRespVO> login(@RequestBody LoginReqDTO dto){
        LoginRespVO login = sysUserService.login(dto);
        HgResult<LoginRespVO> success = HgResult.success(login);
        return success;
    }
    /**
     * 通过用户名获取用户信息
     * @Author:      huoth
     * @CreateDate:  2019/1/8 22:55
     * @UpdateUser:
     * @UpdateDate:  2019/1/8 22:55
     * @Version:     0.0.1
     * @param username
     * @return       com.hth.cloud.common.base.HgResult<com.hth.entity.user.SysUser>
     * @throws
     */
    @GetMapping("/{username}")
    public HgResult<SysUser>getUserInfoByName(@PathVariable("username")String username){
        SysUser user=sysUserService.getUserInfoByName(username);
        HgResult<SysUser>result=HgResult.success(user);
        return result;
    }
    /**
     * 新增用户
     * @Author:      huoth
     * @CreateDate:  2019/1/18 9:44
     * @UpdateUser:
     * @UpdateDate:  2019/1/18 9:44
     * @Version:     0.0.1
     * @param dto
     * @return       com.hth.cloud.common.base.HgResult<java.lang.String>
     * @throws
     */
    @PostMapping("/info")
    public HgResult<String>addUser(@RequestBody RegisterReqDTO dto){

        String s = sysUserService.addUser(dto);
        HgResult<String> result=HgResult.success(s);
        return result;
    }
    /**
     * 分页获取用户
     * @Author:      huoth
     * @CreateDate:  2019/1/18 16:07
     * @UpdateUser:
     * @UpdateDate:  2019/1/18 16:07
     * @Version:     0.0.1
     * @param pageNum
     * @param pageSize
     * @return       com.hth.cloud.common.base.HgResult<com.hth.cloud.common.util.PageVO<com.hth.entity.user.SysUser>>
     * @throws
     */
    @GetMapping("/info/{pageNum}/{pageSize}")
    public HgResult<PageVO<SysUser>>getUserList(@PathVariable("pageNum")Integer pageNum,@PathVariable("pageSize")Integer pageSize){
        PageVO<SysUser> userList = sysUserService.getUserList(pageNum, pageSize);
        HgResult<PageVO<SysUser>> result=HgResult.success(userList);
        return result;
    }
}
