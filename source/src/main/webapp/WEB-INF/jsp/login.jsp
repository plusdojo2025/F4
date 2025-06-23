<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ログイン</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/global.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/login.css">
<link
	href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap"
	rel="stylesheet">
</head>
<body>
	<!-- ヘッダー -->
	<div class="headerH1">
		<h1>ようこそ！</h1>
	</div>

	<!-- ログインテキスト -->
	<div class="loginText">
		<p>ログインして良い一日をスタートしましょう！</p>
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


	<!-- ログインフォーム -->
	<%-- <div class="form">
	    <form id="loginForm" action="<%= request.getContextPath() %>/login" method="post">
	        <input type="text" class="input" name="mail" placeholder="メールアドレス" required
	               oninvalid="this.setCustomValidity('メールアドレスを入力してください')"
	               oninput="this.setCustomValidity('')">
	
	        <input type="password" class="input" name="pw" placeholder="パスワード" required
	               oninvalid="this.setCustomValidity('パスワードを入力してください')"
	               oninput="this.setCustomValidity('')">
	
	        <div class="buttonContainer">
	            <button type="submit" class="button">ログイン</button>
	        </div>
	    </form>
	</div> --%>

	<div class="form">
		<form id="loginForm" action="<%=request.getContextPath()%>/login"
			method="post">

			<div class="form-group">
				<input type="text" name="mail" id="mail" required placeholder=" "
					oninvalid="this.setCustomValidity('メールアドレスを入力してください')"
					oninput="this.setCustomValidity('')"> <label for="mail">メールアドレス</label>
			</div>

			<div class="form-group">
				<input type="password" name="pw" id="pw" required placeholder=" "
					oninvalid="this.setCustomValidity('パスワードを入力してください')"
					oninput="this.setCustomValidity('')"> <label for="pw">パスワード</label>
			</div>

			<div class="buttonContainer">
				<button type="submit" class="button">ログイン</button>
			</div>
		</form>
	</div>



	<!-- 登録リンク -->
	<div class="createAccountLink">
		<div class="line">
			<span>または</span>
		</div>
		<a href="<%=request.getContextPath()%>/registUser">アカウントを作成する</a>
	</div>

</body>
</html>