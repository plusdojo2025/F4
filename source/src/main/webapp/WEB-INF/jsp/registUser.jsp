<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>アカウント作成</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/global.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/registUser.css">
<link
	href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap"
	rel="stylesheet">
<link rel="icon" type="image/png" href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAIAAABvFaqvAAAFKElEQVR4nJ2VW4hd5RXH/+v79vVc95k5c2YyFzWTuTijNupEYwxaL8lDzagwogRRKKVgn3wQSgt9bkGhLRRBfBAUA6IPWqkRxdQLUbHVKhoTHEMycXIyM8czk3PbZ+999t7ft/qQmVzwzf/z4sfHb61vLWJOWDMJEz83rBMSZGgNIcw333v/tdffClLFBPBWiUphmJoM05RQqVIarAGGkGAmcMYwDj40f/+9d2udEDMf/veH8wu/hhAQYhPDAAHD12JorJCzyXBanx1B2EG2hCRCHIAEiJAm0Orw6y/dd88vBYCX3zhMgpzBAVkqypIn+0qymLOmdoqddz8y7X39UPTe7+zxHWXp9Znjs7KQleWKvGZWFnJOpUwkDv3zbQACQJoqFiJJU7UZrdI0tfMWK4sSf81vbnT37fSUsjloqqClCoMqiVQaJ3aBhYiTZBMEAnhLDDNIQJrUrj+43Xp0MJyYlrfv6FQsggo5DpHrh5CQEq4HIWHaBN4CXR4iFIdFtkSN1f+tR43sMNWCrGrFvQRWjpwsTe4R5VEETaQ9xF2oBCAAxkXAhU6Sk5eGTBsNLfOzWbWkM39avfmO6NzX1dNy8iYuFk1vSFdP6F4It4A0BG0SjCueY1jMlDZ929v2+J3X/Wbbxg2Zb75zikfqmXeP9TBl5McmBdBhID+AuAtpIl++oOUSSEhD9eLyQPGJ2/rmr8/dVmkHfmqbtMtp7Lq6MTX2i2frUyfN4fXlH3T1BAyblCGSQKcMIS8DSQOGLRzv7wdvfmxiEb0qb5iOJYQZa8slFgsT3y/c5H/SDQ+c4p6TZzfPrfWETDRXiXCF7MRv5q4av27ATFdr9fOl7zZGKQw5iMhvIA3QaPRWTu+l/zx1vY+ZfZaK//LYDW89vW9kYiRK9EUQgRWcXHliJoyJe8Xn6rufaN/ZDfspYlK9sKmW1kbttIN6fRotNg1kCrvHrANjizu2l8LkkiOGncPw1K925GfTLw03GOx2jkYzv/Xn5+Mzs91lz07qqrS03O8Ld/9QdPu4/ekXzRePlfLZyY+Xvnxg7uIcsUauT0zfcpdb80SVyPkkHLSkWjU8ZedH3XjY83eXT7KTeaa9R0d6vzybrxRPjez9/Y+7dK0q5ZZsQYQknh3rv8U4WesN/aM2+8pZZEe44vCcsdJOMtSJeshV2fms4zy4esfOa3KP/2H/qcT56JU3EXZJGpsgJoFe1zXYV6YN89CqlQZ+e33jdGnorOGtpINz+kxNDr2wPqI26l8VR53SoND0zfFqfPy/8CrQ6jIQq2Nr7ef7bnwSn88V4uWOS52NH9KRQ7jW4WAtoboYWDofUret1+jbRSPyk/Y7r8o4gOUy6y3ZRJBWuvjV0YmFaXN6FQniNgq55lrjw0rWczMfuGN+J/KLscNGuHLux1oNi5/i/DKGJ9FaBolN2Zym0s2gXl06cfzjzLgvbRgG8n12zlhZabVzubAbBe3QGy2TnTXyBXHmcxFs0OiMUImM/AuTLQDcu/dWde5MGkWtL44e63JpZrs5tE32e+5VFeGa9rAXuG5+cptTcoVXSteWNaQe2M5xlNSWVTe8Z88cAFIq0Zqf+vPfXv3XkUBT330Pj9y1R6m4G2k40pSilLXO95RkhH7sL9Xb359SjRq6LTq36KrewYUDf/3jk0IQsU5ABMiO3w7DkCwbjiMIJAgMArRm3lx8TEysFKsUWkMlruvkswVAgZlYpwArraW0Ll6Pn5ycS3sPV/5QpWIpBID/A3jhiPz8eT8XAAAAAElFTkSuQmCC">
	
</head>

<body>
	<!-- ヘッダー -->
	<div class="headerH1">
		<h1>アカウントを作成</h1>
	</div>

	<!-- エラーメッセージ表示（高さは常に確保） -->
	<div class="errorMessageArea">
		<%
		String error = (String) request.getAttribute("errorMessage");
		if (error != null && !error.trim().isEmpty()) {
		%>
		<div class="errorMessage"><%=error%></div>
		<%
		}
		%>
	</div>

	<!-- アカウント作成フォーム -->
	<div class="form">
		<form id="registUserForm"
			action="<%=request.getContextPath()%>/registUser" method="post">

			<div class="form-group">
				<input type="text" name="username" id="username" required
					placeholder=" "
					oninvalid="this.setCustomValidity('ユーザー名を入力してください')"
					oninput="this.setCustomValidity('')"> <label for="username">ユーザー名</label>
			</div>

			<div class="form-group">
				<input type="email" name="email" id="email" required placeholder=" "
					oninvalid="this.setCustomValidity('メールアドレスを入力してください')"
					oninput="this.setCustomValidity('')"> <label for="email">メールアドレス</label>
			</div>

			<div class="form-group">
				<input type="password" name="password" id="password" required
					placeholder=" "
					oninvalid="this.setCustomValidity('パスワードを入力してください')"
					oninput="this.setCustomValidity('')"> <label for="password">パスワード</label>
			</div>

			<div class="form-group">
				<input type="password" name="confirm_password" id="confirm_password"
					required placeholder=" "
					oninvalid="this.setCustomValidity('パスワードを再入力してください')"
					oninput="this.setCustomValidity('')"> <label
					for="confirm_password">パスワード確認</label>
			</div>

			<!-- アカウント作成ボタン -->
			<div class="buttonContainer">
				<button type="submit" class="button">登録</button>
			</div>
			<script type="module" src="js/init.js"></script>
		</form>
	</div>



	<!-- ログインリンク -->
	<div class="loginLink">
		<a href="<%=request.getContextPath()%>/login">すでにアカウントをお持ちですか？ログイン</a>
	</div>

	<!-- 規約 -->
	<div class="terms">
		<p>
			<span>続行することで、あなたは我々のサービス利用規約<br>およびプライバシーポリシーに同意することになります。
			</span>
		</p>
	</div>
	<script type="module" src="js/init.js"></script>

</body>
</html>