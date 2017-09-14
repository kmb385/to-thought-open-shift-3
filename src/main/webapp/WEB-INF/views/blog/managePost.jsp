<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="ttTags" uri="/WEB-INF/tags/implicit.tld" %>

<ttTags:documentTemplate cssFiles="post.css,post_tags.css" 
	jsFiles="tag_editor.js,${pageContext.request.contextPath}/resources/js/pages/manage_post.js" 
	requiresTextEditor="true">
	
	<div class="font-large bold">New Blog Post</div>
	<form action="<c:url value="/secure/post/save"/>" method="POST">
		<div class="v-margin-10">
			<div class="bold v-margin-4"><span class="required">*</span>Title</div>
			<div>
				<input name="title" class="post-title" value="${post.title}" />
			</div>
			<form:errors path="post.title" cssClass="error field-error" />
			<div class="bold v-margin-4">Source Code</div>
			<div>
				<input name="sourceCode" class="post-title" value="${post.sourceCode}" />
			</div>
		</div>
		<div class="v-margin-10 clearfix">
			<textarea id="post-editor" class="post-editor" name="postPart.body">${post.postPart.body}</textarea>
		</div>
		<div class="v-margin-10">
			<div class="bold v-margin-4">Tags</div>
			<div class="tag-editor"></div>
		</div>
		<input id="postId" name="postId" type="hidden" value="${post.postId}" />
	</form>
	<div class="spacer"></div>
</ttTags:documentTemplate>
