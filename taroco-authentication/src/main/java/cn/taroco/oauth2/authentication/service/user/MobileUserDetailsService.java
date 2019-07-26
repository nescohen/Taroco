package cn.taroco.oauth2.authentication.service.user;

import cn.taroco.oauth2.authentication.entity.User;
import cn.taroco.oauth2.authentication.service.MockUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.stereotype.Service;

/**
 *
 * @author liuht
 * 2019/5/14 13:56
 */
@Service
public class MobileUserDetailsService extends AbstractUserDetailService {

    @Autowired
    private MockUserService mockUserService;

    @Override
    protected User getUserVO(final String username) {
        final User user = mockUserService.findUserByMobile(username);
        if (user == null) {
            throw new InternalAuthenticationServiceException("手机号: " + username + ", 不存在");
        }
        return user;
    }
}
