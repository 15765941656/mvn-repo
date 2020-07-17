<%--
  Created by IntelliJ IDEA.
  User: 86157
  Date: 2020/7/17
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>
<rapid:override name="frame-content">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a href="/admin">首页</a>
              <a href="/admin/notice">公告列表</a>
              <a><cite>添加公告</cite></a>
        </span>
            </blockquote>

            <form class="layui-form"  method="post" id="myForm" action="/notice/add">
                <div class="layui-form-item">
                    <label class="layui-form-label">标题  <span style="color: #FF5722; ">*</span></label>
                    <div class="layui-input-block">
                        <input type="text" name="noticeTitle" lay-verify="title" id="title" class="layui-input" required>
                    </div>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">内容 <span style="color: #FF5722;">*</span></label>
                    <div class="layui-input-block">
                        <textarea  name="noticeContent" lay-verify="content" id="content"></textarea>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="" >添加</button>
                    </div>
                </div>
            </form>




        </div>
    </div>
</rapid:override>
<%@ include file="../framework.jsp" %>

