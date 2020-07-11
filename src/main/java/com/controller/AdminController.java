package com.controller;

import com.entity.Article;
import com.entity.Comment;
import com.entity.User;
import com.service.ArticleService;
import com.service.CommentService;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller @RequestMapping("/admin")
public class AdminController {
    @Resource
    private UserService userService;
    @Resource
    private ArticleService articleService;
    @Resource
    private CommentService commentService;
    @RequestMapping("/login")
    public String login(String userName,String userPass,ModelMap m,HttpSession session) {
        User user=userService.login(userName, userPass);

        if(user!=null) {
            m.put("msg", "登录成功");
            session.setAttribute("session_user", user);

            //最近的5条文章
            List<Article> articleList=articleService.listRecentArticle(6);
            m.put("articleList", articleList);

            //最近的5条评论
            List<Comment> commentList =commentService.listRecentComment(5);
            m.put("commentList", commentList);

            return "index";
        }
        else {
            m.put("msg", "用户名或密码错误,登录失败");
            return "login";
        }
    }
}
