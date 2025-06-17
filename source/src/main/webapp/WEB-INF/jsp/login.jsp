<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログイン</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/global.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/login.css">
    <link href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap" rel="stylesheet">
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

    <!-- ログインフォーム -->
     <!-- こことボタンに処理を記入 -->
    <div class="form">
        <form action="/F4/login" method="post">
            <input type="text" class="input" name="mail" placeholder="メールアドレス" required>
            <input type="password" class="input" name="pw" placeholder="パスワード" required>
            <!-- ボタン -->
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
        <a href="/F4/registUser">アカウントを作成する</a>
    </div>
</body>
</html>