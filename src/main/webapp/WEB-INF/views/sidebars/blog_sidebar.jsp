<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ttTags" uri="/WEB-INF/tags/implicit.tld"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="control-container">
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<c:if test="${isNew}">
			<ttTags:control text="Create New Post"
				href="${pageContext.request.contextPath}/secure/post/new"
				classes="shadow" imageClass="add-control-btn" />
		</c:if>
	</sec:authorize>
</div>
<div class="v-margin-20 h-margin-20">
	<div class="bold fg3 v-margin-4 font-medium">Find Posts By Tag</div>
	<div class="bg2 pad-5 border shadow">
		<c:forEach items="${tags}" var="tag">
			<div class="v-margin-4 clearfix">
				<a href="${pageContext.request.contextPath}/blog/tag/${tag.tagId}/page/0"
					class="post-tag">${tag.name}</a>
				<span class="bold fg3"> x ${tag.count}</span>
			</div>
		</c:forEach>
	</div>
</div>
<c:if test="${isSingle}">
	<div class="dzone-button">
		<script type="text/javascript">
			var dzone_style = '2';
		</script>
		<script language="javascript"
			src="http://widgets.dzone.com/links/widgets/zoneit.js"></script>
	</div>
	<div class="h-margin-20 v-margin-10">
		<a href="https://twitter.com/share" class="twitter-share-button" data-via="bowersox_kevin">Tweet</a>
		<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>	
	</div>
</c:if>