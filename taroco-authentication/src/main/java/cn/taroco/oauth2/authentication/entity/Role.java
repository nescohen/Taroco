package cn.taroco.oauth2.authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * 角色定义
 *
 * @author liuht
 * 2019/7/16 15:14
 * @see SecurityExpressionRoot
 */
@Data
@AllArgsConstructor
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = -1956975342008354518L;

    private static final String PREFIX = "ROLE_";

    private String role;

    private List<Operation> operations;

    @Override
    public String getAuthority() {
        return PREFIX + role.toUpperCase();
    }
}
