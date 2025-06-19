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
<body data-context-path="<%= request.getContextPath() %>">
    <!-- ヘッダー -->
     <div class="headerH2">
         <h2>お疲れさまでした！</h2>
     </div>

    <!-- テキスト -->
     <div class="registText">
        <h3>今日の各時間を入力してください</h3>
     </div>
     
     <div class="errorMessageArea">
        <%
		    String error = (String) request.getAttribute("errorMessage");
		    if (error != null && !error.trim().isEmpty()) {
		%>
    		<div class="errorMessage"><%= error %></div>
		<%
		    }
		%>
    </div>

    <!-- 目標設定フォーム -->
     <div class="form">
        <form class="registTime" id="registTime">
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
    <script type="module" src="js/init.js"></script>
    
</body>
</html>