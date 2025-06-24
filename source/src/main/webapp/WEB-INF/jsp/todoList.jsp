<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TODOリスト</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/global.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/todoList.css">
<link
	href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap"
	rel="stylesheet">
<link rel="icon" type="image/png" href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAIAAABvFaqvAAAFKElEQVR4nJ2VW4hd5RXH/+v79vVc95k5c2YyFzWTuTijNupEYwxaL8lDzagwogRRKKVgn3wQSgt9bkGhLRRBfBAUA6IPWqkRxdQLUbHVKhoTHEMycXIyM8czk3PbZ+999t7ft/qQmVzwzf/z4sfHb61vLWJOWDMJEz83rBMSZGgNIcw333v/tdffClLFBPBWiUphmJoM05RQqVIarAGGkGAmcMYwDj40f/+9d2udEDMf/veH8wu/hhAQYhPDAAHD12JorJCzyXBanx1B2EG2hCRCHIAEiJAm0Orw6y/dd88vBYCX3zhMgpzBAVkqypIn+0qymLOmdoqddz8y7X39UPTe7+zxHWXp9Znjs7KQleWKvGZWFnJOpUwkDv3zbQACQJoqFiJJU7UZrdI0tfMWK4sSf81vbnT37fSUsjloqqClCoMqiVQaJ3aBhYiTZBMEAnhLDDNIQJrUrj+43Xp0MJyYlrfv6FQsggo5DpHrh5CQEq4HIWHaBN4CXR4iFIdFtkSN1f+tR43sMNWCrGrFvQRWjpwsTe4R5VEETaQ9xF2oBCAAxkXAhU6Sk5eGTBsNLfOzWbWkM39avfmO6NzX1dNy8iYuFk1vSFdP6F4It4A0BG0SjCueY1jMlDZ929v2+J3X/Wbbxg2Zb75zikfqmXeP9TBl5McmBdBhID+AuAtpIl++oOUSSEhD9eLyQPGJ2/rmr8/dVmkHfmqbtMtp7Lq6MTX2i2frUyfN4fXlH3T1BAyblCGSQKcMIS8DSQOGLRzv7wdvfmxiEb0qb5iOJYQZa8slFgsT3y/c5H/SDQ+c4p6TZzfPrfWETDRXiXCF7MRv5q4av27ATFdr9fOl7zZGKQw5iMhvIA3QaPRWTu+l/zx1vY+ZfZaK//LYDW89vW9kYiRK9EUQgRWcXHliJoyJe8Xn6rufaN/ZDfspYlK9sKmW1kbttIN6fRotNg1kCrvHrANjizu2l8LkkiOGncPw1K925GfTLw03GOx2jkYzv/Xn5+Mzs91lz07qqrS03O8Ld/9QdPu4/ekXzRePlfLZyY+Xvnxg7uIcsUauT0zfcpdb80SVyPkkHLSkWjU8ZedH3XjY83eXT7KTeaa9R0d6vzybrxRPjez9/Y+7dK0q5ZZsQYQknh3rv8U4WesN/aM2+8pZZEe44vCcsdJOMtSJeshV2fms4zy4esfOa3KP/2H/qcT56JU3EXZJGpsgJoFe1zXYV6YN89CqlQZ+e33jdGnorOGtpINz+kxNDr2wPqI26l8VR53SoND0zfFqfPy/8CrQ6jIQq2Nr7ef7bnwSn88V4uWOS52NH9KRQ7jW4WAtoboYWDofUret1+jbRSPyk/Y7r8o4gOUy6y3ZRJBWuvjV0YmFaXN6FQniNgq55lrjw0rWczMfuGN+J/KLscNGuHLux1oNi5/i/DKGJ9FaBolN2Zym0s2gXl06cfzjzLgvbRgG8n12zlhZabVzubAbBe3QGy2TnTXyBXHmcxFs0OiMUImM/AuTLQDcu/dWde5MGkWtL44e63JpZrs5tE32e+5VFeGa9rAXuG5+cptTcoVXSteWNaQe2M5xlNSWVTe8Z88cAFIq0Zqf+vPfXv3XkUBT330Pj9y1R6m4G2k40pSilLXO95RkhH7sL9Xb359SjRq6LTq36KrewYUDf/3jk0IQsU5ABMiO3w7DkCwbjiMIJAgMArRm3lx8TEysFKsUWkMlruvkswVAgZlYpwArraW0Ll6Pn5ycS3sPV/5QpWIpBID/A3jhiPz8eT8XAAAAAElFTkSuQmCC">

</head>
<body data-context-path="<%=request.getContextPath()%>">
	<!-- header -->
	<div class="headerH2">
		<h2>Todoリスト</h2>
	</div>

	<!-- エラーメッセージ表示（高さは常に確保） -->
	<div class="errorMessageArea">
    	<div id="messageBox" class="errorMessage"></div>
    </div>
    
	<!-- Todoリストフォーム -->
	<form class="todoForm" id="todoForm">
		<div class="todoForm-wrapper">
			<div class="todoForm-group">
				<input type="text" id="todoInput" name="todoText" required maxlength="70" placeholder=" " />
				<label for="todoInput">Todoリスト追加</label>
			</div>
			<button type="submit" class="todoForm-button">追加</button>
		</div>
	</form>

	<!-- Todoリスト表示 -->
	<div class="todoList">
		<ul>
			<c:choose>
				<c:when test="${not empty todoList}">
					<c:forEach var="todo" items="${todoList}">
						<li><input type="checkbox" class="checkbox"
							data-id="${todo.todo_list_id}" ${todo.checkbox ? "checked" : ""}>
							<label><c:out value="${todo.list_content}" /></label>
							<button class="deleteButton" data-id="${todo.todo_list_id}"
								id="deleteButton">
								<svg width="18" height="20" viewBox="0 0 18 20" fill="none"
									xmlns="http://www.w3.org/2000/svg">
								<path fill-rule="evenodd" clip-rule="evenodd"
										d="M17.25 3.5H13.5V2.75C13.5 1.50736 12.4926 0.5 11.25 0.5H6.75C5.50736 0.5 4.5 1.50736 4.5 2.75V3.5H0.75C0.335786 3.5 0 3.83579 0 4.25C0 4.66421 0.335786 5 0.75 5H1.5V18.5C1.5 19.3284 2.17157 20 3 20H15C15.8284 20 16.5 19.3284 16.5 18.5V5H17.25C17.6642 5 18 4.66421 18 4.25C18 3.83579 17.6642 3.5 17.25 3.5ZM6 2.75C6 2.33579 6.33579 2 6.75 2H11.25C11.6642 2 12 2.33579 12 2.75V3.5H6V2.75ZM15 18.5H3V5H15V18.5ZM7.5 8.75V14.75C7.5 15.1642 7.16421 15.5 6.75 15.5C6.33579 15.5 6 15.1642 6 14.75V8.75C6 8.33579 6.33579 8 6.75 8C7.16421 8 7.5 8.33579 7.5 8.75ZM12 8.75V14.75C12 15.1642 11.6642 15.5 11.25 15.5C10.8358 15.5 10.5 15.1642 10.5 14.75V8.75C10.5 8.33579 10.8358 8 11.25 8C11.6642 8 12 8.33579 12 8.75Z"
										fill="#FF0000" />
							</svg>
							</button></li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<li class="liText">まだ何も追加されていません．．．</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>


	<!-- フッター -->
	<jsp:include page="footerMenu.jsp" />

	<script type="module" src="js/init.js"></script>




</body>
</html>