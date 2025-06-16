<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>目標設定</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/global.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/registGoal.css">
    <link href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <!-- ヘッダー -->
     <div class="headerH2">
         <h2>目標設定</h2>
     </div>

    <!-- 目標設定 -->
     <div class="goalSettingText">
        <h1>今週の目標を決めましょう</h1>
     </div>

    <!-- 目標設定フォーム -->
     <div class="form">
        <form action="/F4/registGoalServlet" method="post">
            <input type="number" class="input" name="exercise" placeholder="一日の運動時間　(推奨1時間)" required>
            <input type="number" class="input" name="study" placeholder="一日の勉強時間　(1~3時間が効果的)" required>
            <input type="number" class="input" name="sleep" placeholder="一日の睡眠時間　(理想は6時間以上)" required>
            
            <!-- テキスト -->
     		<div class="goalSettingTextH3">
        		<h3>あなたのペースで頑張りましょう！</h3>
     		</div>

    		<!-- 警告文 -->
     		<div class="goalSettingWarning">
        		<ul>
            		<li>3つの目標を足した際に<span>24時間以内</span>に<br>収まるようにしてください</li>
            		<li>単位は<span>時間</span>で設定してください</li>
        		</ul>
     		</div>

    		<!-- 目標設定ボタン -->
     		<div class="buttonContainer">
        		<button type="submit" class="button">完了</button>
     		</div>
        </form>
     </div>
</body>
</html>