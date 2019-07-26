package cn.taroco.oauth2.authentication.config.annotation;

import cn.taroco.oauth2.authentication.config.token.JwtTokenConfigration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用jwt token
 *
 * @author liuht
 * 2019/7/15 16:08
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(JwtTokenConfigration.class)
public @interface EnableJwtToken {

}
