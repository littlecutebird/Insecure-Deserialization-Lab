<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
	    <div class="navbar-header">
	    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Vulnerable Website</a>
	    </div>
	    <ul class="nav navbar-nav">
	    <li><a href="${pageContext.request.contextPath}/">Home</a></li>
	    <li><a href="${pageContext.request.contextPath}/about">About</a></li>
	    <li><a href="${pageContext.request.contextPath}/submit">Submit info</a></li>
	    <li><a href="${pageContext.request.contextPath}/check">Check info</a></li>
	    <li><a href="${pageContext.request.contextPath}/safecheck">Check info (Safe)</a></li>
	    </ul>
	</div>
</nav>