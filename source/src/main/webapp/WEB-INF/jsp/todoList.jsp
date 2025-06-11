<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TODOリスト</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/global.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/todoList.css">
    <link href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <!-- ヘッダー -->
    <div class="headerH2">
        <h2>Todoリスト</h2>
    </div>

    <!-- Todoリストフォーム -->
    <form class="todoForm">
        <input class="input" type="text" placeholder="　Todoリストの追加">
        <button class="button" type="submit">追加</button>
    </form>

    <!-- Todoリスト表示 -->
    <!-- ここをjspで表示する（以下はサンプルです削除可 -->
    <div class="todoList">
        <ul>
            <li>
                <input type="checkbox">
                <label for="todo1">メールチェックと返信（9:00までに対応）</label>
                <button class="deleteButton">
                    <svg width="18" height="20" viewBox="0 0 18 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M17.25 3.5H13.5V2.75C13.5 1.50736 12.4926 0.5 11.25 0.5H6.75C5.50736 0.5 4.5 1.50736 4.5 2.75V3.5H0.75C0.335786 3.5 0 3.83579 0 4.25C0 4.66421 0.335786 5 0.75 5H1.5V18.5C1.5 19.3284 2.17157 20 3 20H15C15.8284 20 16.5 19.3284 16.5 18.5V5H17.25C17.6642 5 18 4.66421 18 4.25C18 3.83579 17.6642 3.5 17.25 3.5ZM6 2.75C6 2.33579 6.33579 2 6.75 2H11.25C11.6642 2 12 2.33579 12 2.75V3.5H6V2.75ZM15 18.5H3V5H15V18.5ZM7.5 8.75V14.75C7.5 15.1642 7.16421 15.5 6.75 15.5C6.33579 15.5 6 15.1642 6 14.75V8.75C6 8.33579 6.33579 8 6.75 8C7.16421 8 7.5 8.33579 7.5 8.75ZM12 8.75V14.75C12 15.1642 11.6642 15.5 11.25 15.5C10.8358 15.5 10.5 15.1642 10.5 14.75V8.75C10.5 8.33579 10.8358 8 11.25 8C11.6642 8 12 8.33579 12 8.75Z" fill="#FF0000"/>
                    </svg>
                </button>
            </li>
        </ul>
    </div>

    <!-- フッター -->
    <!-- <jsp:include page="footerMenu.jsp" /> -->
</body>
</html>