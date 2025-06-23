<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>時間入力</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/global.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/registTime.css">
<link
	href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap"
	rel="stylesheet">
</head>
<body data-context-path="<%=request.getContextPath()%>">
	<!-- ヘッダー -->
	<div class="headerH2">
		<h2>お疲れさまでした！</h2>
	</div>

	<!-- テキスト -->
	<div class="registText">
		<h3>今日の各時間を入力してください</h3>
	</div>

	<div class="errorMessageArea">
		<div id="messageBox" class="successMessage"></div>
	</div>


	<!-- 目標設定フォーム -->
	<div class="form">
		<form class="registTime" id="registTime">

			<div class="form-group">
				<input type="number" name="exercise" id="time-exercise" required
					placeholder=" " /> <label for="time-exercise">運動時間</label>
			</div>

			<div class="form-group">
				<input type="number" name="study" id="time-study" required
					placeholder=" " /> <label for="time-study">勉強時間</label>
			</div>

			<div class="form-group">
				<input type="number" name="sleep" id="time-sleep" required
					placeholder=" " /> <label for="time-sleep">睡眠時間</label>
			</div>


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