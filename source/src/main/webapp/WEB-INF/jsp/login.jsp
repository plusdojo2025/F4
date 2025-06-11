<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログイン</title>
    <link rel="stylesheet" href="global.css">
    <link rel="stylesheet" href="login.css">
    <link href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap" rel="stylesheet">

</head>
<body>
    <!-- header -->
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
        <form action="#" method="post">
            <input type="text" class="input" name="email" placeholder="メールアドレス" required>
            <input type="password" class="input" name="password" placeholder="パスワード" required>
        </form>
    </div>

    <!-- ボタン -->
    <div class="buttonContainer">
        <button type="submit" class="button">ログイン</button>
    </div>

    <!-- 登録リンク -->
    <div class="createAccountLink">
        <div class="line">
            <span>または</span>
        </div>
        <a href="#">アカウントを作成する</a>
    </div>
</body>
</html>