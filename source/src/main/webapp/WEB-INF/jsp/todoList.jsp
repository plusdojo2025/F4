<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TODOリスト</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/global.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/todoList.css">
<link
	href="https://fonts.googleapis.com/css2?family=Manrope:wght@400;500;700&display=swap"
	rel="stylesheet">
</head>
<body>
	<!-- header -->
	<div class="headerH2">
		<h2>Todoリスト</h2>
	</div>

	<!-- Todoリストフォーム -->
	<form class="todoForm" id="todoForm">
		<input class="input" type="text" id="todoInput" name="todoText"
			placeholder="　Todoリストの追加">
		<button class="button" type="submit">追加</button>
	</form>

	<!-- Todoリスト表示 -->
	<div class="todoList">
		<ul>
			<c:forEach var="todo" items="${todoList}">
				<li>
					<input type="checkbox" class="checkbox" data-id="${todo.todo_list_id}"  ${todo.checkbox ? "checked" : ""} >
        			<label>${todo.list_content}</label>
					<button class="deleteButton" data-id="${todo.todo_list_id}">
						<svg width="18" height="20" viewBox="0 0 18 20" fill="none"
							xmlns="http://www.w3.org/2000/svg">
                      	     <path fill-rule="evenodd"
								clip-rule="evenodd"
								d="M17.25 3.5H13.5V2.75C13.5 1.50736 12.4926 0.5 11.25 0.5H6.75C5.50736 0.5 4.5 1.50736 4.5 2.75V3.5H0.75C0.335786 3.5 0 3.83579 0 4.25C0 4.66421 0.335786 5 0.75 5H1.5V18.5C1.5 19.3284 2.17157 20 3 20H15C15.8284 20 16.5 19.3284 16.5 18.5V5H17.25C17.6642 5 18 4.66421 18 4.25C18 3.83579 17.6642 3.5 17.25 3.5ZM6 2.75C6 2.33579 6.33579 2 6.75 2H11.25C11.6642 2 12 2.33579 12 2.75V3.5H6V2.75ZM15 18.5H3V5H15V18.5ZM7.5 8.75V14.75C7.5 15.1642 7.16421 15.5 6.75 15.5C6.33579 15.5 6 15.1642 6 14.75V8.75C6 8.33579 6.33579 8 6.75 8C7.16421 8 7.5 8.33579 7.5 8.75ZM12 8.75V14.75C12 15.1642 11.6642 15.5 11.25 15.5C10.8358 15.5 10.5 15.1642 10.5 14.75V8.75C10.5 8.33579 10.8358 8 11.25 8C11.6642 8 12 8.33579 12 8.75Z"
								fill="#FF0000" />
                        </svg>
					</button>
				</li>
			</c:forEach>
		</ul>
	</div>

	<!-- フッター -->
	<jsp:include page="footerMenu.jsp" />
	
	<script>
	// 確認アラート関数
    function showConfirm(message = '本当に削除しますか？') {
        return window.confirm(message);
    }
	
	//追加
    document.getElementById('todoForm').addEventListener('submit', function (e) {
        e.preventDefault(); // フォームの通常送信を防止

        const input = document.getElementById('todoInput');
        const todoText = input.value.trim();
        
        if (!todoText) return; // 空欄チェック

        //追加のリクエストを送信
        fetch('<%=request.getContextPath()%>/addTodo', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: new URLSearchParams({
                todoText: todoText,
                id: 1 //ユーザーIDは仮。ログインユーザーIDで置き換える。セッション
            })
        })
        .then(response => {
            if (!response.ok) throw new Error('エラー');
            location.reload(); // 成功後に画面をリロード
        })
        .catch(error => {
            console.error('追加に失敗:', error);
        });
    });
    
    
    //削除
    document.addEventListener('DOMContentLoaded', function () {
        document.querySelectorAll('.deleteButton').forEach(button => {
            button.addEventListener('click', function (e) {
                e.preventDefault();// デフォルトのボタン動作をキャンセル
                
             	// data-id 属性からTodoidを取得
                const todoId = this.getAttribute('data-id');
                
             // 確認ダイアログを表示
                if (!showConfirm('このToDoを削除しますか？')) return;
                
                // 削除リクエストを送信
                fetch('<%=request.getContextPath()%>/deleteTodo', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                    body: new URLSearchParams({ todo_list_id: todoId })
                })
                .then(response => {
                    if (response.ok) {
                        // 成功時はリストから削除
                        this.closest('li').remove();
                    } else {
                        alert('削除に失敗しました');
                    }
                })
                .catch(error => {
                    console.error('削除通信エラー:', error);
                    alert('削除に失敗しました');
                });
            });
        });
    });

    
 	// チェックボックスの状態変更時にサーバーへ更新リクエストを送信
    document.querySelectorAll(".checkbox").forEach(cb => {
        cb.addEventListener("change", () => {
          const todoId = cb.dataset.id;		// data-id 属性からtodoidを取得
          const checked = cb.checked;		// チェック状態（true/false）

          // チェック状態の更新リクエストを送信
          fetch('<%=request.getContextPath()%>/updateCheckbox', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: new URLSearchParams({
              todoId: todoId,
              checked: checked
            })
          })
          .then(response => {
            if (!response.ok) {
              throw new Error('サーバーエラー');
            }
            //console.log("チェック状態更新成功");
          })
          .catch(error => {
            console.error("チェック状態の更新に失敗:", error);
            //alert("チェック状態の更新に失敗しました");
          });
        });
      });

</script>

</body>
</html>