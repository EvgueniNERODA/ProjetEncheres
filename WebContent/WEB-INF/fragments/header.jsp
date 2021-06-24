<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${request.getSession != null}">
		<a
			href="${pageContext.request.contextPath }/WEB-INF/AccueilConnecte.jsp"><button>LE
				COIN QU'EST BON</button></a>
	</c:if>

	<c:if test="${request.getSession == null}">
		<a href="${pageContext.request.contextPath }/ServletAccueil"><button>LE
				COIN QU'EST BON</button></a>
	</c:if>

</body>
</html>