<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ttTags" uri="/WEB-INF/tags/implicit.tld"%>

<ttTags:documentTemplate jsFiles="login.js">
	<form action="login" method="post">
		<div class="page-title">Login</div>
		<div class="v-margin-10">
			<div class="bold v-margin-4">Username</div>
			<input name="j_username" />
		</div>
		<div class="v-margin-10">
			<div class="bold v-margin-4">Password</div>
			<input name="j_password" />
		</div>
		<input type="submit" class="control" value="Login" />
	</form>
</ttTags:documentTemplate>
