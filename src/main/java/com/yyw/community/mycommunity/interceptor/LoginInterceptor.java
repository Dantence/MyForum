package com.yyw.community.mycommunity.interceptor;

import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.entity.UserExample;
import com.yyw.community.mycommunity.mapper.UserMapper;
import com.yyw.community.mycommunity.service.MessageService;
import com.yyw.community.mycommunity.service.NotificationService;
import com.yyw.community.mycommunity.utils.commonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/7
 *       2022/7/20 将未读通知数加入session
 */
@Service
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private MessageService messageService;

    @Value("${github.redirect.uri}")
    private String githubRedirectUri;

    @Value("${gitee.redirect.uri}")
    private String giteeRedirectUri;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //设置context级别的属性
        request.getServletContext().setAttribute("giteeRedirectUri", giteeRedirectUri);
        request.getServletContext().setAttribute("githubRedirectUri", githubRedirectUri);
        String token = commonUtils.getToken(request);
        if(token != null){
            UserExample userExample = new UserExample();
            userExample.createCriteria().andTokenEqualTo(token);
            List<User> userList = userMapper.selectByExample(userExample);
            if(userList.size() != 0 && userList.get(0).getIsValid() != 0){
                request.getSession().setAttribute("user", userList.get(0));
                Long unreadNotificationCount = notificationService.unreadCount(userList.get(0).getId());
                request.getSession().setAttribute("unreadNotificationCount", unreadNotificationCount);
                Long unreadMessageCount = messageService.unreadCount(userList.get(0).getId());
                request.getSession().setAttribute("unreadMessageCount", unreadMessageCount);
                request.getSession().setAttribute("unreadCount", unreadMessageCount + unreadNotificationCount);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
