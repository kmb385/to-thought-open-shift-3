<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ttTags" uri="/WEB-INF/tags/implicit.tld"%>

<%@ attribute name="cssFiles" type="java.lang.String"%>
<%@ attribute name="jsFiles" type="java.lang.String"%>
<%@ attribute name="sidebarFragment" type="java.lang.String"%>
<%@ attribute name="requiresTextEditor" type="java.lang.Boolean"%>
<%@ attribute name="title" type="java.lang.String"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ToThought ${title}</title>
<meta name="google-site-verification" content="TWl2IyBn5Tg6pSDse_sG_TFQ6NoAl-HFkzqPAe2e0XE" />
<!-- Load Base CSS -->
<jsp:include page="/WEB-INF/views/fragments/base_css.jsp" />
<!-- Load Specified CSS -->
<c:if test="${!empty cssFiles}">
	<c:forEach var="cssFile" items="${fn:split(cssFiles,\",\")}">
		<c:choose>
			<c:when test="${!fn:contains(cssFile,pageContext.request.contextPath)}">
				<link href="<c:url value="/resources/css/${cssFile}" />" rel="stylesheet" />
			</c:when>
			<c:when test="${!fn:contains(cssFile,'resources') && empty pagecontext.request.contextPath}">
				<link href="<c:url value="/resources/css/${cssFile}"/>" rel="stylesheet" />
			</c:when>
			<c:when test="${fn:contains(cssFile,'resources') && empty pagecontext.request.contextPath}">
				<link href="${cssFile}" rel="stylesheet" />
			</c:when>
			<c:otherwise>
				<link href="${cssFile}" rel="stylesheet" />
			</c:otherwise>
		</c:choose>
	</c:forEach>
</c:if>

<!-- Load Base Javascript Javascript -->
<jsp:include page="/WEB-INF/views/fragments/base_js.jsp" />

<!-- Load Text Editor Script -->
<c:if test="${requiresTextEditor}">
	<jsp:include page="/WEB-INF/views/fragments/text_editor_files.jsp" />
	<script type="text/javascript">
		SyntaxHighlighter.all();
	</script>
</c:if>

<!-- Load Specified Javascript Files -->
<c:if test="${!empty jsFiles}">
	<c:forEach var="jsFile" items="${fn:split(jsFiles,\",\")}">
		<c:choose>
			<c:when test="${!fn:contains(jsFile,pageContext.request.contextPath)}">
				<script src="<c:url value="/resources/js/${jsFile}"/>" type="text/javascript"></script>
			</c:when>
			<c:when test="${!fn:contains(jsFile,'resources') && empty pagecontext.request.contextPath}">
				<script src="<c:url value="/resources/js/${jsFile}"/>" type="text/javascript"></script>
			</c:when>
			<c:when test="${fn:contains(jsFile,'resources') && empty pagecontext.request.contextPath}">
				<script src="${jsFile}" type="text/javascript"></script>
			</c:when>
			<c:otherwise>
				<script src="${jsFile}" type="text/javascript"></script>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</c:if>

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-41940964-1', 'blog-tothought.rhcloud.com');
  ga('send', 'pageview');

</script>
<meta name="google-site-verification" content="ih5hR8pc2tKIyfgiX9PYZggje0VEQger9avVgxABF-0" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />
	<div id="container" class="clearfix bg4">
		<div id="inner-container" class="bg2">
			<div id="center-panel" class="bg2 clearfix">
				<jsp:doBody />
			</div>
			<div id="side-bar">
				<c:if test="${!empty sidebarFragment}">
					<jsp:include page="/WEB-INF/views/sidebars/${sidebarFragment}" />
				</c:if>
			</div>
		</div>
	</div>
	<div class="spacer"></div>
</body>
</html>
