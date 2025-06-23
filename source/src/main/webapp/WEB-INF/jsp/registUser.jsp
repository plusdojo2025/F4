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