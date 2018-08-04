package com.gioov.spiny.common.security;

import com.gioov.common.web.http.FailureEntity;
import com.gioov.common.web.http.SuccessEntity;
import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.constant.FailureMessage;
import com.gioov.spiny.common.constant.Page;
import com.gioov.spiny.common.constant.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.gioov.spiny.user.service.UserService.SYSTEM_ADMIN;


/**
 * @author godcheese
 * @date 2018/4/29 13:40
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfiguration.class);

    @Autowired
    @Qualifier("simpleUserDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                // 禁用 csrf
                .csrf().disable()

                // 禁用 ROLE_ANONYMOUS 角色
//                .anonymous().disable()

                // 解决 in a frame because it set 'X-Frame-Options' to 'deny'. 问题
                .headers().frameOptions().disable()

                .and()

                .authorizeRequests()

                // 静态资源 url ，无需登录认证权限
                .antMatchers(Url.STATIC).permitAll()
                .antMatchers(Page.User.LOGIN).permitAll()
                .antMatchers("/druid").hasAnyAuthority("ROLE_" + SYSTEM_ADMIN, "/DRUID")

                // 其它请求均需要认证 或 .antMatchers(Url.PATH_PATTERN).authenticated()
                .anyRequest().authenticated()
//                ;

                .and()

                // 开启表单登录，设置登录 url
                .formLogin().loginPage(Page.User.LOGIN).usernameParameter("account").passwordParameter("password")

                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        /**
                         * 登录成功，返回 status 201
                         * body 返回
                         */
                        SimpleUser simpleUser = (SimpleUser) authentication.getPrincipal();
                        httpServletResponse.setStatus(200);
                        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                        PrintWriter printWriter = httpServletResponse.getWriter();
                        printWriter.write(new SuccessEntity(simpleUser).toString());
                        printWriter.flush();
                        printWriter.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setStatus(404);
                        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                        PrintWriter printWriter = httpServletResponse.getWriter();
                        printWriter.write(new FailureEntity(FailureMessage.LOGIN_FAIL).toString());
                        printWriter.flush();
                        printWriter.close();
                    }
                })

                // 自定义登录表单提交 url
                .loginProcessingUrl(Api.User.LOGIN)

                .and()

                // 开启记住我功能， cookie 保存登录数据
                .rememberMe().rememberMeParameter("rememberMe");

        // __________________________________________________________


//                .and()
//
//                .logout()
//
//                // 设置注销 url
//                .logoutUrl(Api.User.LOGOUT).permitAll();


    }


}
