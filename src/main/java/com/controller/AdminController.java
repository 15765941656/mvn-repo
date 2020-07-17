package com.controller;

import com.entity.Article;
import com.entity.Comment;
import com.entity.Notice;
import com.entity.User;
import com.service.ArticleService;
import com.service.CommentService;
import com.service.NoticeService;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller @RequestMapping("/admin")
public class AdminController {
    @Resource
    private UserService userService;
    @Resource
    private ArticleService articleService;
    @Resource
    private CommentService commentService;
    @Resource
    private NoticeService noticeService;
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

    @RequestMapping(value="/add",method=RequestMethod.POST)
    public String add(User user,MultipartFile photo) throws IOException {
        user.setUserRegisterTime(new Date());
        user.setUserStatus(1);
        user.setUserPhoto(photo.getBytes());
        userService.addUser(user);
        return "forward:/admin/user";   //添加完成以后.转到用望列表
    }


    @RequestMapping(value="/useradd",method=RequestMethod.GET)
    public String gotoAddPage() {
        return "User/user-add";
    }

    @RequestMapping("/user")
    public String users(ModelMap m) {
        List<User> userList= userService.listUser();
        m.put("userList",userList);
        return "User/user-list";
    }

    @RequestMapping("/photo/{id}")
    public void showPhoto(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        User user=userService.getUserById(id);

        response.setContentType("image/jpg");
        ServletOutputStream outStream=response.getOutputStream();
        outStream.write(user.getUserPhoto());
        outStream.flush();
    }
}
