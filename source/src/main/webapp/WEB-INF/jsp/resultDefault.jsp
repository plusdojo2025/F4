<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>本日の評価</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/global.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/resultDefault.css">
    <link href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap" rel="stylesheet">
<link rel="icon" type="image/png" href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAIAAABvFaqvAAAFKElEQVR4nJ2VW4hd5RXH/+v79vVc95k5c2YyFzWTuTijNupEYwxaL8lDzagwogRRKKVgn3wQSgt9bkGhLRRBfBAUA6IPWqkRxdQLUbHVKhoTHEMycXIyM8czk3PbZ+999t7ft/qQmVzwzf/z4sfHb61vLWJOWDMJEz83rBMSZGgNIcw333v/tdffClLFBPBWiUphmJoM05RQqVIarAGGkGAmcMYwDj40f/+9d2udEDMf/veH8wu/hhAQYhPDAAHD12JorJCzyXBanx1B2EG2hCRCHIAEiJAm0Orw6y/dd88vBYCX3zhMgpzBAVkqypIn+0qymLOmdoqddz8y7X39UPTe7+zxHWXp9Znjs7KQleWKvGZWFnJOpUwkDv3zbQACQJoqFiJJU7UZrdI0tfMWK4sSf81vbnT37fSUsjloqqClCoMqiVQaJ3aBhYiTZBMEAnhLDDNIQJrUrj+43Xp0MJyYlrfv6FQsggo5DpHrh5CQEq4HIWHaBN4CXR4iFIdFtkSN1f+tR43sMNWCrGrFvQRWjpwsTe4R5VEETaQ9xF2oBCAAxkXAhU6Sk5eGTBsNLfOzWbWkM39avfmO6NzX1dNy8iYuFk1vSFdP6F4It4A0BG0SjCueY1jMlDZ929v2+J3X/Wbbxg2Zb75zikfqmXeP9TBl5McmBdBhID+AuAtpIl++oOUSSEhD9eLyQPGJ2/rmr8/dVmkHfmqbtMtp7Lq6MTX2i2frUyfN4fXlH3T1BAyblCGSQKcMIS8DSQOGLRzv7wdvfmxiEb0qb5iOJYQZa8slFgsT3y/c5H/SDQ+c4p6TZzfPrfWETDRXiXCF7MRv5q4av27ATFdr9fOl7zZGKQw5iMhvIA3QaPRWTu+l/zx1vY+ZfZaK//LYDW89vW9kYiRK9EUQgRWcXHliJoyJe8Xn6rufaN/ZDfspYlK9sKmW1kbttIN6fRotNg1kCrvHrANjizu2l8LkkiOGncPw1K925GfTLw03GOx2jkYzv/Xn5+Mzs91lz07qqrS03O8Ld/9QdPu4/ekXzRePlfLZyY+Xvnxg7uIcsUauT0zfcpdb80SVyPkkHLSkWjU8ZedH3XjY83eXT7KTeaa9R0d6vzybrxRPjez9/Y+7dK0q5ZZsQYQknh3rv8U4WesN/aM2+8pZZEe44vCcsdJOMtSJeshV2fms4zy4esfOa3KP/2H/qcT56JU3EXZJGpsgJoFe1zXYV6YN89CqlQZ+e33jdGnorOGtpINz+kxNDr2wPqI26l8VR53SoND0zfFqfPy/8CrQ6jIQq2Nr7ef7bnwSn88V4uWOS52NH9KRQ7jW4WAtoboYWDofUret1+jbRSPyk/Y7r8o4gOUy6y3ZRJBWuvjV0YmFaXN6FQniNgq55lrjw0rWczMfuGN+J/KLscNGuHLux1oNi5/i/DKGJ9FaBolN2Zym0s2gXl06cfzjzLgvbRgG8n12zlhZabVzubAbBe3QGy2TnTXyBXHmcxFs0OiMUImM/AuTLQDcu/dWde5MGkWtL44e63JpZrs5tE32e+5VFeGa9rAXuG5+cptTcoVXSteWNaQe2M5xlNSWVTe8Z88cAFIq0Zqf+vPfXv3XkUBT330Pj9y1R6m4G2k40pSilLXO95RkhH7sL9Xb359SjRq6LTq36KrewYUDf/3jk0IQsU5ABMiO3w7DkCwbjiMIJAgMArRm3lx8TEysFKsUWkMlruvkswVAgZlYpwArraW0Ll6Pn5ycS3sPV/5QpWIpBID/A3jhiPz8eT8XAAAAAElFTkSuQmCC">
    
</head>
<body>
    <!-- ヘッダー -->
    <div class="headerH2">
        <h2>本日の評価</h2>
    </div>

    <!-- テキスト -->
    <div class="resultText">
        <h1>まだ活動内容が<br>登録されていません!</h1>
    </div>

    <!-- アイコン表示 -->
    <div class="resultIcon">
        <svg width="147" height="120" viewBox="0 0 147 120" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M56.7002 0V7.3C49.9002 4.1 42.7002 2.3 35.4002 2.3C22.6002 2.3 9.80018 7.2 0.000183105 16.9L21.2002 38.1H35.3002L34.3002 51.3C40.5002 57.5 48.5002 60.5 56.6002 60.5H56.7002V80H36.7002V105C36.7002 113.3 43.4002 120 51.7002 120H126.7C137.7 120 146.7 111 146.7 100V0H56.7002ZM56.6002 50.5C52.3002 50.5 48.2002 49.3 44.7002 46.9L46.2002 28.2H25.4002L15.1002 17.9C21.2002 14.3 28.2002 12.4 35.4002 12.4C46.1002 12.4 56.1002 16.6 63.7002 24.1L77.8002 38.2L71.8002 44.2C67.7002 48.2 62.3002 50.5 56.6002 50.5ZM136.7 100C136.7 105.5 132.2 110 126.7 110C121.2 110 116.7 105.5 116.7 100V80H66.7002V58.7C71.1002 57.2 75.3002 54.8 78.9002 51.3L84.9002 45.3L109.6 70H116.7V62.9L70.7002 17C69.5002 15.7 68.1002 14.8 66.7002 13.7V10H136.7V100Z" fill="#5C788A"/>
        </svg>
    </div>

    <!-- テキスト -->
    <div class="registTextH3">
        <h3>一日の<span>活動内容を登録</span>して<br>今日の評価を確認しましょう!</h3>
    </div>

    <!-- 登録ボタン -->
    <div class="buttonContainer">
        <a href="<%= request.getContextPath() %>/registTime"><button type="submit" class="button">活動内容を登録</button></a>
    </div>

    <!-- フッター -->
    <jsp:include page="footerMenu.jsp" />
</body>
</html>