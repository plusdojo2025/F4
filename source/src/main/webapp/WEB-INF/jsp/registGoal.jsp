<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>目標設定</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/global.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/registGoal.css">
<link
	href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap"
	rel="stylesheet">
<link rel="icon" type="image/png" href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAIAAABvFaqvAAAFKElEQVR4nJ2VW4hd5RXH/+v79vVc95k5c2YyFzWTuTijNupEYwxaL8lDzagwogRRKKVgn3wQSgt9bkGhLRRBfBAUA6IPWqkRxdQLUbHVKhoTHEMycXIyM8czk3PbZ+999t7ft/qQmVzwzf/z4sfHb61vLWJOWDMJEz83rBMSZGgNIcw333v/tdffClLFBPBWiUphmJoM05RQqVIarAGGkGAmcMYwDj40f/+9d2udEDMf/veH8wu/hhAQYhPDAAHD12JorJCzyXBanx1B2EG2hCRCHIAEiJAm0Orw6y/dd88vBYCX3zhMgpzBAVkqypIn+0qymLOmdoqddz8y7X39UPTe7+zxHWXp9Znjs7KQleWKvGZWFnJOpUwkDv3zbQACQJoqFiJJU7UZrdI0tfMWK4sSf81vbnT37fSUsjloqqClCoMqiVQaJ3aBhYiTZBMEAnhLDDNIQJrUrj+43Xp0MJyYlrfv6FQsggo5DpHrh5CQEq4HIWHaBN4CXR4iFIdFtkSN1f+tR43sMNWCrGrFvQRWjpwsTe4R5VEETaQ9xF2oBCAAxkXAhU6Sk5eGTBsNLfOzWbWkM39avfmO6NzX1dNy8iYuFk1vSFdP6F4It4A0BG0SjCueY1jMlDZ929v2+J3X/Wbbxg2Zb75zikfqmXeP9TBl5McmBdBhID+AuAtpIl++oOUSSEhD9eLyQPGJ2/rmr8/dVmkHfmqbtMtp7Lq6MTX2i2frUyfN4fXlH3T1BAyblCGSQKcMIS8DSQOGLRzv7wdvfmxiEb0qb5iOJYQZa8slFgsT3y/c5H/SDQ+c4p6TZzfPrfWETDRXiXCF7MRv5q4av27ATFdr9fOl7zZGKQw5iMhvIA3QaPRWTu+l/zx1vY+ZfZaK//LYDW89vW9kYiRK9EUQgRWcXHliJoyJe8Xn6rufaN/ZDfspYlK9sKmW1kbttIN6fRotNg1kCrvHrANjizu2l8LkkiOGncPw1K925GfTLw03GOx2jkYzv/Xn5+Mzs91lz07qqrS03O8Ld/9QdPu4/ekXzRePlfLZyY+Xvnxg7uIcsUauT0zfcpdb80SVyPkkHLSkWjU8ZedH3XjY83eXT7KTeaa9R0d6vzybrxRPjez9/Y+7dK0q5ZZsQYQknh3rv8U4WesN/aM2+8pZZEe44vCcsdJOMtSJeshV2fms4zy4esfOa3KP/2H/qcT56JU3EXZJGpsgJoFe1zXYV6YN89CqlQZ+e33jdGnorOGtpINz+kxNDr2wPqI26l8VR53SoND0zfFqfPy/8CrQ6jIQq2Nr7ef7bnwSn88V4uWOS52NH9KRQ7jW4WAtoboYWDofUret1+jbRSPyk/Y7r8o4gOUy6y3ZRJBWuvjV0YmFaXN6FQniNgq55lrjw0rWczMfuGN+J/KLscNGuHLux1oNi5/i/DKGJ9FaBolN2Zym0s2gXl06cfzjzLgvbRgG8n12zlhZabVzubAbBe3QGy2TnTXyBXHmcxFs0OiMUImM/AuTLQDcu/dWde5MGkWtL44e63JpZrs5tE32e+5VFeGa9rAXuG5+cptTcoVXSteWNaQe2M5xlNSWVTe8Z88cAFIq0Zqf+vPfXv3XkUBT330Pj9y1R6m4G2k40pSilLXO95RkhH7sL9Xb359SjRq6LTq36KrewYUDf/3jk0IQsU5ABMiO3w7DkCwbjiMIJAgMArRm3lx8TEysFKsUWkMlruvkswVAgZlYpwArraW0Ll6Pn5ycS3sPV/5QpWIpBID/A3jhiPz8eT8XAAAAAElFTkSuQmCC">
	
</head>

<body data-context-path="<%=request.getContextPath()%>">

	<!-- ヘッダー -->
	<div class="headerH2">
		<h2>目標設定</h2>
	</div>

	<!-- 目標設定 -->
	<div class="goalSettingText">
		<h1>今週の目標を決めましょう</h1>
	</div>

	<div class="weekMessageArea">
		<%
		String msg1 = (String) request.getAttribute("message");
		String msg2 = (String) request.getAttribute("message2");

		if ((msg1 != null && !msg1.trim().isEmpty()) || (msg2 != null && !msg2.trim().isEmpty())) {
		%>
		<%
		if (msg1 != null && !msg1.trim().isEmpty()) {
		%>
		<div class="weekMessage"><%=msg1%></div>
		<%
		}
		%>
		<%
		if (msg2 != null && !msg2.trim().isEmpty()) {
		%>
		<div class="weekMessage"><%=msg2%></div>
		<%
		}
		%>
		<%
		}
		%>
	</div>

	<!-- 目標設定フォーム -->
	<div class="form">
		<form id="registGoalForm"
			action="<%=request.getContextPath()%>/registGoal" method="post">

			<div class="form-group">
				<input type="number" min="0" step="0.1" name="exercise" id="goal-exercise"
					required placeholder=" " /> <label for="goal-exercise">一日の運動時間（推奨1時間）</label>
			</div>

			<div class="form-group">
				<input type="number" min="0" step="0.1" name="study" id="goal-study" required
					placeholder=" " /> <label for="goal-study">一日の勉強時間（1〜3時間が効果的）</label>
			</div>

			<div class="form-group">
				<input type="number" min="0" step="0.1" name="sleep" id="goal-sleep" required
					placeholder=" " /> <label for="goal-sleep">一日の睡眠時間（理想は6時間以上）</label>
			</div>


			<!-- テキスト -->
			<div class="goalSettingTextH3">
				<h3>あなたのペースで頑張りましょう！</h3>
			</div>

			<!-- 警告文 -->
			<div class="goalSettingWarning">
				<ul>
					<li>3つの目標を足した際に<span>24時間以内</span>に<br>収まるようにしてください
					</li>
					<li>単位は<span>時間</span>で設定してください
					</li>
				</ul>
			</div>

			<!-- 目標設定ボタン -->
			<div class="buttonContainer">
				<button type="submit" class="button">目標を登録</button>
			</div>
		</form>
	</div>
	<script type="module" src="js/init.js"></script>

</body>
</html>