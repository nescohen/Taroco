package cn.taroco.oauth2.authentication.service.user;

import cn.taroco.oauth2.authentication.entity.User;
import cn.taroco.oauth2.authentication.service.MockUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户信息获取
 *
 * @author liuht
 * @date 2018/7/24 17:06
 */
@Service
public class UserNameUserDetailsServiceImpl extends AbstractUserDetailService {

    @Autowired
    private MockUserService mockUserService;

    @Override
    protected User getUserVO(final String username) {
        // 查询用户信息,包含角色列表
        User user = mockUserService.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名/密码错误");
        }
        return user;
    }

}
