<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ttTags" uri="/WEB-INF/tags/implicit.tld"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="page-title">Education</div>
<c:forEach var="degree" items="${degrees}">
	<div class="v-bottom-margin-20">
		<div class="clearfix">
			<div class="pdf-450 float-left">
				<div class="font-medium bold">${degree.institution }</div>
				<div>${degree.program }</div>
				<div>${degree.degreeType }</div>
			</div>
			<div class="pdf-175 float-right">
				<div class="text-right">
					<c:if test="${!empty degree.startDate}">
						<fmt:formatDate value="${degree.startDate}" pattern="MMMM yyyy" />
							-
					    </c:if>
					<c:choose>
						<c:when test="${degree.isPresent}">
								Present
							</c:when>
						<c:otherwise>
							<fmt:formatDate value="${degree.endDate}" pattern="MMMM yyyy" />
						</c:otherwise>
					</c:choose>
				</div>
				<c:if test="${!empty degree.gpa}">
					<div class="text-right">
						<span class="subtle">GPA </span>${degree.gpa}
					</div>
				</c:if>
			</div>
		</div>
		<div class="simple-list">
			<ul>
				<li>${degree.emphasis } Emphasis</li>
				<c:forEach var="detail" items="${degree.degreeDetails }">
					<li>${detail.description}</li>
				</c:forEach>
			</ul>
		</div>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<div class="clearfix">
				<a
					href="<c:url value="/secure/resume/manager/degree/edit/${degree.degreeId}" />"
					class="button-32 edit-control-btn"></a> <a
					href="<c:url value="/secure/resume/manager/degree/delete/${degree.degreeId}"  />"
					class="button-32 delete-control-btn"></a>
			</div>
		</sec:authorize>
	</div>
</c:forEach>