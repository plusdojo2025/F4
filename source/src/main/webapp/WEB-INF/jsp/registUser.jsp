<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>アカウント作成</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/global.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/registUser.css">
    <link href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <!-- ヘッダー -->
    <div class="headerH1">
        <h1>アカウントを作成</h1>
    </div>

    <!-- アカウント作成フォーム -->
    <div class="form">
        <form action="#" method="post">
            <input type="text" class="input" name="username" placeholder="ユーザー名" required>
            <input type="email" class="input" name="email" placeholder="メールアドレス" required>
            <input type="password" class="input" name="password" placeholder="パスワード" required>
            <input type="password" class="input" name="confirm_password" placeholder="パスワード確認" required>
        </form>
    </div>

    <!-- アカウント作成ボタン -->
    <div class="buttonContainer">
        <button type="submit" class="button">サインアップ</button>
    </div>

    <!-- ログインリンク -->
    <div class="loginLink">
        <a href="#">すでにアカウントをお持ちですか？ログイン</a>
    </div>
    
    <!-- 規約 -->
    <div class="terms">
        <p><span>続行することで、あなたは我々のサービス利用規約<br>およびプライバシーポリシーに同意することになります。</span></p>
    </div>
</body>
</html>