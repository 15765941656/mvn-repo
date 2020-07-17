<%--
  Created by IntelliJ IDEA.
  User: 86157
  Date: 2020/7/16
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>
<rapid:override name="frame-content">
    <link rel="shortcut icon" href="/img/logo.png">
    <title>博客后台 - 公告列表  </title>

    <style>
        /*覆盖 layui*/
        .layui-table {
            margin-top: 0;
        }

        .layui-btn {
            margin: 2px 0!important;
        }
    </style>

<div class="layui-layout layui-layout-admin">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
          <a href="/admin">首页</a>
          <a><cite>公告列表</cite></a>
        </span>
            </blockquote>


            <table class="layui-table" >
                <colgroup>
                    <col width="400">
                    <col width="50">
                    <col width="100">
                    <col width="100">
                    <col width="50">
                </colgroup>
                <thead>
                <tr>
                    <th>标题</th>
                    <th>Order</th>
                    <th>状态</th>
                    <th>操作</th>
                    <td>ID</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach  var="n" items="${noticeList}">
                <tr>
                    <td>
                        <a href="/notice/${n.noticeId}" target="_blank">${n.noticeTitle}</a>
                    </td>
                    <td>
                            ${n.noticeOrder}</td>
                    <td>
                        <a href="#">
                            <c:if test="${n.noticeStatus==1 }">
                                <span style="color: #5FB878;">已发布</span>
                            </c:if>
                            <c:if test="${n.noticeStatus==0 }">
                                <span style="color: RED;">未发布</span>
                            </c:if>
                        </a>
                    </td>
                    <td>
                        <a href="notice/edit?editid=${n.noticeId}"   class="layui-btn layui-btn-mini">编辑</a>
                        <a href="notice/delete?delid=${n.noticeId}" class="layui-btn layui-btn-danger layui-btn-mini"
                           onclick="return confirmDelete()">删除</a>
                    </td>
                    <td >${n.noticeId}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>Order的大小决定显示的顺序</li>
                </ul>
            </blockquote>


        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 这里展示一些提示性信息 <a href="#" target="_blank">其他导航</a> / <a href="#" target="_blank">其他导航</a>
    </div>
</div>
</rapid:override>·
<%@ include file="../framework.jsp" %>