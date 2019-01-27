package com.hth.cloud.service;

import com.hth.cloud.common.util.PageVO;
import com.hth.cloud.dto.user.LoginReqDTO;
import com.hth.cloud.dto.user.RegisterReqDTO;
import com.hth.cloud.vo.user.LoginRespVO;
import com.hth.entity.user.SysUser;

/**
 * @ClassName: SysUserService
 * 用户接口
 * @Author: huoth
 * @CreateDate: 2019/1/8 22:30
 * @UpdateUser: huoth
 * @UpdateDate: 2019/1/8 22:30
 * @Version: 0.0.1
 */
public interface SysUserService {
    /**
     * 通过用户查找用户信息
     * @Author:      huoth
     * @CreateDate:  2019/1/8 22:51
     * @UpdateUser:
     * @UpdateDate:  2019/1/8 22:51
     * @Version:     0.0.1
     * @param name
     * @return       com.hth.entity.user.SysUser
     * @throws
     */
    SysUser getUserInfoByName(String name);
    /**
     * 新增用户
     * @Author:      huoth
     * @CreateDate:  2019/1/18 9:43
     * @UpdateUser:
     * @UpdateDate:  2019/1/18 9:43
     * @Version:     0.0.1
     * @param dto
     * @return       java.lang.String
     * @throws
     */
    String addUser(RegisterReqDTO dto);
    /**
     * 分页获取用户
     * @Author:      huoth
     * @CreateDate:  2019/1/18 16:05
     * @UpdateUser:
     * @UpdateDate:  2019/1/18 16:05
     * @Version:     0.0.1
     * @param pageNum
     * @param pageSize
     * @return       com.hth.cloud.common.util.PageVO<com.hth.entity.user.SysUser>
     * @throws
     */
    PageVO<SysUser>getUserList(Integer pageNum,Integer pageSize);

    /**
     * 用户登录
     * @Author:      霍天豪
     * @CreateDate:  2019/1/27 22:17
     * @UpdateUser:
     * @UpdateDate:  2019/1/27 22:17
     * @Version:     0.0.1
     * @param dto
     * @return       com.hth.cloud.vo.user.LoginRespVO
     * @throws
     */
    LoginRespVO login(LoginReqDTO dto);

}
