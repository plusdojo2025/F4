// js/todoModule.js

// 確認アラート
export function showConfirm(message = '本当に削除しますか？') {
    return window.confirm(message);
}

// ToDo追加処理
export function initAddTodo(formId, inputId, contextPath, userId) {
    const form = document.getElementById(formId);
    const input = document.getElementById(inputId);

    form.addEventListener('submit', function (e) {
        e.preventDefault();
        const todoText = input.value.trim();
        if (!todoText) return;

        fetch(`${contextPath}/addTodo`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: new URLSearchParams({ todoText, id: userId })
        })
        .then(res => {
            if (!res.ok) throw new Error('追加エラー');
            location.reload();
        })
        .catch(err => {
            console.error('追加失敗:', err);
        });
    });
}

// ToDo削除処理
export function initDeleteButtons(buttonClass, contextPath) {
    document.querySelectorAll(`.${buttonClass}`).forEach(button => {
        button.addEventListener('click', function (e) {
            e.preventDefault();
            const todoId = this.getAttribute('data-id');
            if (!showConfirm('このToDoを削除しますか？')) return;

            fetch(`${contextPath}/deleteTodo`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                body: new URLSearchParams({ todo_list_id: todoId })
            })
            .then(res => {
                if (res.ok) {
                    this.closest('li').remove();
                } else {
                    alert('削除に失敗しました');
                }
            })
            .catch(err => {
                console.error('削除通信エラー:', err);
                alert('削除に失敗しました');
            });
        });
    });
}

// チェック状態変更処理
export function initCheckboxes(checkboxClass, contextPath) {
    document.querySelectorAll(`.${checkboxClass}`).forEach(cb => {
        cb.addEventListener("change", () => {
            const todoId = cb.dataset.id;
            const checked = cb.checked;

            fetch(`${contextPath}/updateCheckbox`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                body: new URLSearchParams({ todoId, checked })
            })
            .then(res => {
                if (!res.ok) throw new Error('更新エラー');
            })
            .catch(err => {
                console.error('チェック状態更新失敗:', err);
            });
        });
    });
}

// 時間登録処理
export function initRegistTime(formId, contextPath) {
    const form = document.getElementById(formId);
    if (!form) {
  		console.error(`フォームID "${formId}" が見つかりません`);
  		return;
	}
    form.addEventListener('submit', function (e) {
        e.preventDefault();
        const formData = new FormData(form);
        const exercise = formData.get('exercise');
        const study = formData.get('study');
        const sleep = formData.get('sleep');

		const params = new URLSearchParams();
		params.append('exercise', exercise);
		params.append('study', study);
		params.append('sleep', sleep);
		
		if (!showConfirm('登録しますか？')) return;
		
        fetch(`${contextPath}/registTime`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: params.toString()
        })
        .then(res => {
            if (!res.ok) throw new Error('登録エラー');
            location.reload();
        })
        .catch(err => {
            console.error('登録失敗:', err);
        });
    });
}

//確認の表示
export function initConfirmOnSubmit(formId, message = "実行しますか？"){
	const form = document.getElementById(formId);
	if(form) {
		form.addEventListener('submit', (e) => {
			const confirmed = showConfirm(message);
			if (!confirmed) {
				e.preventDefault()
			}
		})
	}
}
/*
export function registPwMatch(registUserForm){ 
	form.addEventListener('submit',function(e){
		const password = document.getElementsByName(password).values;
		const confirm = document.getElementsByName(confirm_password).values;
		if(password != confirm){
			console.log("不一致");
			e.preventDefault();
		}
	});
}*/

export function registPwMatch(formId,message) {
    const form = document.getElementById(formId);
    
    form.addEventListener('submit', function(e) {
        const password = form.querySelector('[name="password"]').value;
        const confirm = form.querySelector('[name="confirm_password"]').value;

        if (password !== confirm) {
			showConfirm(message);
            console.log("不一致");
            e.preventDefault(); // 送信を止める
        }
    });
}





