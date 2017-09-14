<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ttTags" uri="/WEB-INF/tags/implicit.tld"%>

<ttTags:documentTemplate cssFiles="resume.css,rating.css"
	sidebarFragment="resume_sidebar.jsp">
	<jsp:include page="../fragments/resume/skills.jsp" />
</ttTags:documentTemplate>

