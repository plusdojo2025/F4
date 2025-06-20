<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>本日の評価</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/global.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/resultDefault.css">
    <link href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap" rel="stylesheet">
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