<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>本日の評価</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/global.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/resultWeek.css">
    <link href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap" rel="stylesheet">
<link rel="icon" type="image/png" href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAIAAABvFaqvAAAFKElEQVR4nJ2VW4hd5RXH/+v79vVc95k5c2YyFzWTuTijNupEYwxaL8lDzagwogRRKKVgn3wQSgt9bkGhLRRBfBAUA6IPWqkRxdQLUbHVKhoTHEMycXIyM8czk3PbZ+999t7ft/qQmVzwzf/z4sfHb61vLWJOWDMJEz83rBMSZGgNIcw333v/tdffClLFBPBWiUphmJoM05RQqVIarAGGkGAmcMYwDj40f/+9d2udEDMf/veH8wu/hhAQYhPDAAHD12JorJCzyXBanx1B2EG2hCRCHIAEiJAm0Orw6y/dd88vBYCX3zhMgpzBAVkqypIn+0qymLOmdoqddz8y7X39UPTe7+zxHWXp9Znjs7KQleWKvGZWFnJOpUwkDv3zbQACQJoqFiJJU7UZrdI0tfMWK4sSf81vbnT37fSUsjloqqClCoMqiVQaJ3aBhYiTZBMEAnhLDDNIQJrUrj+43Xp0MJyYlrfv6FQsggo5DpHrh5CQEq4HIWHaBN4CXR4iFIdFtkSN1f+tR43sMNWCrGrFvQRWjpwsTe4R5VEETaQ9xF2oBCAAxkXAhU6Sk5eGTBsNLfOzWbWkM39avfmO6NzX1dNy8iYuFk1vSFdP6F4It4A0BG0SjCueY1jMlDZ929v2+J3X/Wbbxg2Zb75zikfqmXeP9TBl5McmBdBhID+AuAtpIl++oOUSSEhD9eLyQPGJ2/rmr8/dVmkHfmqbtMtp7Lq6MTX2i2frUyfN4fXlH3T1BAyblCGSQKcMIS8DSQOGLRzv7wdvfmxiEb0qb5iOJYQZa8slFgsT3y/c5H/SDQ+c4p6TZzfPrfWETDRXiXCF7MRv5q4av27ATFdr9fOl7zZGKQw5iMhvIA3QaPRWTu+l/zx1vY+ZfZaK//LYDW89vW9kYiRK9EUQgRWcXHliJoyJe8Xn6rufaN/ZDfspYlK9sKmW1kbttIN6fRotNg1kCrvHrANjizu2l8LkkiOGncPw1K925GfTLw03GOx2jkYzv/Xn5+Mzs91lz07qqrS03O8Ld/9QdPu4/ekXzRePlfLZyY+Xvnxg7uIcsUauT0zfcpdb80SVyPkkHLSkWjU8ZedH3XjY83eXT7KTeaa9R0d6vzybrxRPjez9/Y+7dK0q5ZZsQYQknh3rv8U4WesN/aM2+8pZZEe44vCcsdJOMtSJeshV2fms4zy4esfOa3KP/2H/qcT56JU3EXZJGpsgJoFe1zXYV6YN89CqlQZ+e33jdGnorOGtpINz+kxNDr2wPqI26l8VR53SoND0zfFqfPy/8CrQ6jIQq2Nr7ef7bnwSn88V4uWOS52NH9KRQ7jW4WAtoboYWDofUret1+jbRSPyk/Y7r8o4gOUy6y3ZRJBWuvjV0YmFaXN6FQniNgq55lrjw0rWczMfuGN+J/KLscNGuHLux1oNi5/i/DKGJ9FaBolN2Zym0s2gXl06cfzjzLgvbRgG8n12zlhZabVzubAbBe3QGy2TnTXyBXHmcxFs0OiMUImM/AuTLQDcu/dWde5MGkWtL44e63JpZrs5tE32e+5VFeGa9rAXuG5+cptTcoVXSteWNaQe2M5xlNSWVTe8Z88cAFIq0Zqf+vPfXv3XkUBT330Pj9y1R6m4G2k40pSilLXO95RkhH7sL9Xb359SjRq6LTq36KrewYUDf/3jk0IQsU5ABMiO3w7DkCwbjiMIJAgMArRm3lx8TEysFKsUWkMlruvkswVAgZlYpwArraW0Ll6Pn5ycS3sPV/5QpWIpBID/A3jhiPz8eT8XAAAAAElFTkSuQmCC">
    
</head>
<body>
    <!-- ヘッダー -->
    <div class="headerH2">
        <h2>今週の評価</h2>
    </div>   

    <!-- 進捗率表示 -->
    <div class="progressContainer">
        <p>今週の達成率</p>
        <div class="progressBar">
            <div class="progressBarFill" style="width: <%=session.getAttribute("level") %>%;"></div>
        </div>
        <p><span><%=session.getAttribute("level") %>%</span></p>
    </div>

    <!-- テキスト -->
    <!-- jspで生成 -->
    <div>
        <p><%=session.getAttribute("feedback") %></p>
    </div>

    <div class="resultText">
        <h1>今週もお疲れさまでした！</h1>
    </div>

    <!-- テキスト -->
    <div>
        <p>来週の自分が、少しでも心地よく過ごせるように、がんばることだけが目標じゃない。<br>安心できるペースで、やりたいことを少しずつ形にしていこう！</p>
    </div>


    <div class="textH2">
        <h2>来週の目標を登録しましょう！</h2>
        <svg width="14" height="18" viewBox="0 0 14 18" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" clip-rule="evenodd" d="M7.29871 17.2802C7.15808 17.4206 6.96746 17.4995 6.76871 17.4995C6.56996 17.4995 6.37933 17.4206 6.23871 17.2802L0.238706 11.2802C0.165019 11.2115 0.105917 11.1287 0.0649252 11.0367C0.0239334 10.9447 0.00189209 10.8454 0.000115395 10.7447C-0.0016613 10.644 0.0168629 10.544 0.0545835 10.4506C0.0923042 10.3572 0.14845 10.2724 0.219668 10.2011C0.290887 10.1299 0.375721 10.0738 0.46911 10.036C0.562498 9.99833 0.662525 9.9798 0.763228 9.98158C0.863932 9.98336 0.963246 10.0054 1.05525 10.0464C1.14724 10.0874 1.23005 10.1465 1.29871 10.2202L6.01871 14.9402V0.750172C6.01871 0.55126 6.09772 0.360493 6.23838 0.219841C6.37903 0.0791893 6.56979 0.000171661 6.76871 0.000171661C6.96762 0.000171661 7.15838 0.0791893 7.29904 0.219841C7.43969 0.360493 7.51871 0.55126 7.51871 0.750172V14.9402L12.2387 10.2202C12.3074 10.1465 12.3902 10.0874 12.4822 10.0464C12.5742 10.0054 12.6735 9.98336 12.7742 9.98158C12.8749 9.9798 12.9749 9.99833 13.0683 10.036C13.1617 10.0738 13.2465 10.1299 13.3177 10.2011C13.389 10.2724 13.4451 10.3572 13.4828 10.4506C13.5206 10.544 13.5391 10.644 13.5373 10.7447C13.5355 10.8454 13.5135 10.9447 13.4725 11.0367C13.4315 11.1287 13.3724 11.2115 13.2987 11.2802L7.29871 17.2802Z" fill="black"/>
        </svg>
    </div> 

    <!-- 登録ボタン -->
     <div class="buttonContainer">
        <a href="<%= request.getContextPath() %>/registGoal"><button type="submit" class="button">目標を登録する</button></a>
     </div>

     

    <!-- フッター -->
    <jsp:include page="footerMenu.jsp" />
</body>
</html>