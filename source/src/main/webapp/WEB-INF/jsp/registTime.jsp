<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>時間入力</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/global.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/registTime.css">
    <link href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <!-- ヘッダー -->
     <div class="headerH2">
         <h2>お疲れさまでした！</h2>
     </div>

    <!-- テキスト -->
     <div class="registText">
        <h3>今日の各時間を入力してください<br>※一日に一度しか入力できません</h3>
     </div>

    <!-- 目標設定フォーム -->
    <!-- こことボタンに処理を書く -->
     <div class="form">
        <form action="#" method="post">
            <input type="number" class="input" name="exercise" placeholder="運動時間" required>
            <input type="number" class="input" name="study" placeholder="勉強時間" required>
            <input type="number" class="input" name="sleep" placeholder="睡眠時間" required>
            
            <!-- 登録ボタン -->
     		<div class="buttonContainer">
        		<button type="submit" class="button">登録</button>
     		</div>
        </form>
     </div>

    

     <!-- フッター -->
    <jsp:include page="footerMenu.jsp" />
</body>
</html>