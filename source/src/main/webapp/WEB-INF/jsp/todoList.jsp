<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TODOリスト</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/global.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/todoList.css">
<link
	href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap"
	rel="stylesheet">
<link rel="icon" type="image/svg+xml" href="data:image/svg+xml,%3Csvg%20xmlns%3D%22http%3A//www.w3.org/2000/svg%22%20width%3D%2224%22%20height%3D%2224%22%3E%3Cpath%20fill%3D%22%2323727B%22%20d%3D%22M0%200h24v24H0V0Z%22/%3E%3Cpath%20fill%3D%22%23284A53%22%20d%3D%22M7.063.734%209.476.727%2012%20.75l2.523-.023%202.415.007%202.214.007C21%201%2021%201%2023%203c.227%201.88.227%201.88.195%204.133l-.02%202.441-.05%202.551-.027%202.574c-.024%202.1-.06%204.2-.098%206.301l-4-1%201-3-1-3%201-2-4%201V9h-3V6c-2.799%202.528-4.458%204.204-5%208H5v2H3l1%205H1c-.054-2.959-.094-5.916-.125-8.875l-.05-2.55-.02-2.442-.032-2.254C1.25.93%203.663.745%207.063.734Z%22/%3E%3Cpath%20fill%3D%22%23F9FAF8%22%20d%3D%22M0%200h24v24H0V0Zm1%203C.707%204.92.707%204.92.77%207.098l.005%202.427.037%202.537.002%202.55C.447%2018.624.447%2018.624%202%2022c1.477.099%202.958.13%204.438.133l2.71.004L12%2022.125l2.852.012%202.71-.004%202.504-.004c1.94.084%201.94.084%202.934-1.129.127-2.99.185-5.947.188-8.938l.037-2.537.005-2.427.013-2.234C23.16%202.754%2023.16%202.754%2021%201%2019.098.691%2019.098.691%2016.937.734L14.524.727%2012%20.75%209.477.727%207.062.734%204.848.741C2.753.846%202.753.846%201%203Z%22/%3E%3Cpath%20fill%3D%22%2306303C%22%20d%3D%22M3%203h17l-4%206h-3V6c-2.799%202.528-4.458%204.204-5%208H5v2H3l1%205H2L3%203Z%22/%3E%3Cpath%20fill%3D%22%237DB0A3%22%20d%3D%22m14%2012%202%203%202-1-1%208H5l1-5h2v-2l6-3Z%22/%3E%3Cpath%20fill%3D%22%23F3F4EF%22%20d%3D%22M0%2021h24v3H0v-3Z%22/%3E%3Cpath%20fill%3D%22%2321717A%22%20d%3D%22M15%2012h5c1.125%205.75%201.125%205.75%200%208l2%202h-5v-7l-2%201v-4Z%22/%3E%3Cpath%20fill%3D%22%23ABC7AF%22%20d%3D%22m15%2018-1%204H6c.313-1.938.313-1.938%201-4%203.29-1.097%204.713-.8%208%200Z%22/%3E%3Cpath%20fill%3D%22%23063946%22%20d%3D%22M5%208h2l1%206H5v2H3l1%205H2c-.125-5.75-.125-5.75%201-8h2V8Z%22/%3E%3Cpath%20fill%3D%22%23156B78%22%20d%3D%22m12%204%202%203-1%202%203%201-8%204c.375-2.438.375-2.438%201-5l2-1c.652-2.025.652-2.025%201-4Z%22/%3E%3Cpath%20fill%3D%22%23358D91%22%20d%3D%22m17%207%201%203c-6.286%204.429-6.286%204.429-10%205l2-3h2l1-2h3l1-3Z%22/%3E%3Cpath%20fill%3D%22%235BA09A%22%20d%3D%22m14%2012%202%203%202-1-1%208h-1v-5h-2v-2l-2-1%202-2Z%22/%3E%3Cpath%20fill%3D%22%23032A36%22%20d%3D%22M21%2011h1v10l-3-1%201-3-1-3%202-3Z%22/%3E%3C/svg%3E">
	
</head>
<body data-context-path="<%=request.getContextPath()%>">
	<!-- header -->
	<div class="headerH2">
		<h2>Todoリスト</h2>
	</div>

	<!-- Todoリストフォーム -->
	
	<form class="todoForm" id="todoForm">
		<div class="todoForm-wrapper">
			<div class="todoForm-group">
				<input type="text" id="todoInput" name="todoText" required
					placeholder=" " /> <label for="todoInput">Todoリスト追加</label>
			</div>
			<button type="submit" class="todoForm-button">追加</button>
		</div>
	</form>




	<!-- Todoリスト表示 -->
	<div class="todoList">
		<ul>
			<c:choose>
				<c:when test="${not empty todoList}">
					<c:forEach var="todo" items="${todoList}">
						<li><input type="checkbox" class="checkbox"
							data-id="${todo.todo_list_id}" ${todo.checkbox ? "checked" : ""}>
							<label>${todo.list_content}</label>
							<button class="deleteButton" data-id="${todo.todo_list_id}"
								id="deleteButton">
								<svg width="18" height="20" viewBox="0 0 18 20" fill="none"
									xmlns="http://www.w3.org/2000/svg">
								<path fill-rule="evenodd" clip-rule="evenodd"
										d="M17.25 3.5H13.5V2.75C13.5 1.50736 12.4926 0.5 11.25 0.5H6.75C5.50736 0.5 4.5 1.50736 4.5 2.75V3.5H0.75C0.335786 3.5 0 3.83579 0 4.25C0 4.66421 0.335786 5 0.75 5H1.5V18.5C1.5 19.3284 2.17157 20 3 20H15C15.8284 20 16.5 19.3284 16.5 18.5V5H17.25C17.6642 5 18 4.66421 18 4.25C18 3.83579 17.6642 3.5 17.25 3.5ZM6 2.75C6 2.33579 6.33579 2 6.75 2H11.25C11.6642 2 12 2.33579 12 2.75V3.5H6V2.75ZM15 18.5H3V5H15V18.5ZM7.5 8.75V14.75C7.5 15.1642 7.16421 15.5 6.75 15.5C6.33579 15.5 6 15.1642 6 14.75V8.75C6 8.33579 6.33579 8 6.75 8C7.16421 8 7.5 8.33579 7.5 8.75ZM12 8.75V14.75C12 15.1642 11.6642 15.5 11.25 15.5C10.8358 15.5 10.5 15.1642 10.5 14.75V8.75C10.5 8.33579 10.8358 8 11.25 8C11.6642 8 12 8.33579 12 8.75Z"
										fill="#FF0000" />
							</svg>
							</button></li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<li class="liText">まだ何も追加されていません．．．</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>


	<!-- フッター -->
	<jsp:include page="footerMenu.jsp" />

	<script type="module" src="js/init.js"></script>




</body>
</html>