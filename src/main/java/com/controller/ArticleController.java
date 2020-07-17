package com.controller;

import cn.hutool.http.HtmlUtil;
import com.entity.Article;
import com.entity.Category;
import com.entity.Tag;
import com.entity.User;
import com.github.pagehelper.PageInfo;
import com.service.ArticleService;
import com.service.CategoryService;
import com.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller @RequestMapping("/article")
public class ArticleController {

    @Resource
    ArticleService articleService;

    @Resource
    CategoryService categoryService;

    @Resource
    TagService tagService;
    @RequestMapping("")
    public String index(
            @RequestParam(required = false,defaultValue="1")  Integer pageIndex,
            @RequestParam(required = false,defaultValue="10") Integer pageSize,ModelMap m) {

        PageInfo<Article> pageInfo= articleService.getPageArticleList(pageIndex,pageSize);

        m.put("pageInfo", pageInfo);


        m.put("pageUrlPrefix","article?pageIndex"); //把前缀传给分页的导航页

        return "Article/article-list";
    }

    @RequestMapping(value="/add", method= RequestMethod.GET)
    public String gotoAddPage(ModelMap m){
        //查询分类信息
        List<Category> categoryList=categoryService.listCategory();

        //查询标签信息
        List<Tag> tagList=tagService.listTag();

        //带过去
        m.put("categoryList", categoryList);
        m.put("tagList", tagList);

        //转向
        return "Article/article-add";
    }
    @RequestMapping(value="/add", method=RequestMethod.POST)  //POST 请求走这个方法
    public String add(ModelMap m, HttpServletRequest request){
        Article article=new Article();

        //取当前用户的id
        User user=(User)request.getSession().getAttribute("session_user");
        if(user!=null) {
            article.setArticleUserId(user.getUserId());
        }

        //文章标题  drafts
        article.setArticleTitle(request.getParameter("articleTitle"));

        //文章内容
        article.setArticleContent(request.getParameter("articleContent"));

        //文章的状态
        article.setArticleStatus(Integer.parseInt(request.getParameter("articleStatus")));
        //文章摘要
        String str= HtmlUtil.cleanHtmlTag(article.getArticleContent());
        article.setArticleSummary(str.length()>150?str.substring(0,150):str);

        //文章的发布时间
        article.setArticleCreateTime(new Date());

        //文章的最后更新时间
        article.setArticleUpdateTime(new Date());

        //把几个参数置成初始值 0
        article.setArticleViewCount(0);
        article.setArticleLikeCount(0);
        article.setArticleCommentCount(0);


        //文章排序
        article.setArticleOrder(1);

        //一级分类的id
        int  parentCateId=Integer.parseInt(request.getParameter("articleParentCategoryId"));

        //二级分类的id
        int childCateId=Integer.parseInt(request.getParameter("articleChildCategoryId"));

        //把上面的两个分类装到list中
        List<Category> categoryList=new ArrayList<>(2);
        categoryList.add(new Category(parentCateId));
        categoryList.add(new Category(childCateId));

        //标签列表
        String [] tagIds =request.getParameterValues("articleTagIds");

        //把上面的标签放到list中
        List<Tag> tagList=new ArrayList<>();
        for(String tagId:tagIds) {
            tagList.add(new Tag(Integer.parseInt(tagId)));
        }

        //把分类和标签信息都添到article中
        article.setCategoryList(categoryList);
        article.setTagList(tagList);

        //添加文章
        articleService.addArticle(article);

        //将请求转发到查询所有文章
        return "forward:/article";
    }
    @RequestMapping(value="/adddrafts", method=RequestMethod.POST)  //POST 请求走这个方法
    public String adddrafts(ModelMap m, HttpServletRequest request){
        Article article=new Article();

        //取当前用户的id
        User user=(User)request.getSession().getAttribute("session_user");
        if(user!=null) {
            article.setArticleUserId(user.getUserId());
        }

        //文章标题  drafts
        article.setArticleTitle(request.getParameter("articleTitle"));

        //文章内容
        article.setArticleContent(request.getParameter("articleContent"));

        //文章的状态
        article.setArticleStatus((Integer)0);

        //文章的发布时间
        article.setArticleCreateTime(new Date());

        //文章的最后更新时间
        article.setArticleUpdateTime(new Date());

        //把几个参数置成初始值 0
        article.setArticleViewCount(0);
        article.setArticleLikeCount(0);
        article.setArticleCommentCount(0);

        //文章排序
        article.setArticleOrder(1);

        //添加文章
        articleService.addArticle(article);

        //将请求转发到查询所有文章
        return "forward:/article";
    }



    @RequestMapping("/uploadimg")  @ResponseBody
    public String uploadFile(MultipartHttpServletRequest request) throws Exception {

        //imgFile这个名称就是这么写的
        MultipartFile file =request.getFile("imgFile");

        //生成一个随机的文件名
        String newName= UUID.randomUUID().toString();
        File destFile =new File("D:/imguploads/"+newName+".jpg");

        file.transferTo(destFile);

        String path="http://localhost:8080/uploads/"+newName+".jpg";

        System.out.println(path);

        return "{\"error\":0,\"url\":\""+path+"\"}";
    }
}