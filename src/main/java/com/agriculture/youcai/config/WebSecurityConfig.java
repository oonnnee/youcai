package com.agriculture.youcai.config;

import com.agriculture.youcai.dataobject.Guest;
import com.agriculture.youcai.enums.ResultEnum;
import com.agriculture.youcai.service.impl.GuestServiceImpl;
import com.agriculture.youcai.utils.ResultVOUtils;
import com.agriculture.youcai.vo.ResultVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private GuestServiceImpl guestService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
            .and()
            .formLogin()
                .loginProcessingUrl("/manage/login")
                .usernameParameter("id")
                .passwordParameter("pwd")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");

                        ResultVO error = ResultVOUtils.error(ResultEnum.MANAGE_LOGIN_ERROR);
                        httpServletResponse.getWriter().write(new Gson().toJson(error));
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");

                        Guest guest = (Guest) authentication.getPrincipal();
                        guest.setPwd(null);
                        ResultVO success = ResultVOUtils.success(guest);
                        httpServletResponse.getWriter().write(new Gson().toJson(success));
                    }
                })
            .and()
            .logout()
                .logoutUrl("/manage/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");

                        ResultVO success = ResultVOUtils.success("注销成功");
                        httpServletResponse.getWriter().write(new Gson().toJson(success));
                    }
                })
            .and()
            .csrf()
                .disable().exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf-8");

                ResultVO error = ResultVOUtils.error(ResultEnum.MANAGE_NO_LOGIN);
                httpServletResponse.getWriter().write(new Gson().toJson(error));
            }
        });
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(guestService);
    }
}