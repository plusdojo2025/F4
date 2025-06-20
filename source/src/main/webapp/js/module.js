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

//目標登録が24時間以内であるかの確認
export function registCheck (formId, overMessage = '合計24時間以内に収めてください', contextPath, registEndpoint){
	const form = document.getElementById(formId);
	if (!form) {
  		console.error(`フォームID "${formId}" が見つかりません`);
  		return;
	}

	form.addEventListener('submit',function(e){
		const exercise =Number(form.querySelector('[name = exercise]').value) ;
		const study = Number(form.querySelector('[name = study]').value);
		const sleep = Number(form.querySelector('[name = sleep]').value);
		const time = exercise+study+sleep;
		
		if(time > 24){
			console.warn("24h間越え");
			alert(overMessage);
			e.preventDefault();
		}
		else{
			console.warn("送るでぇ");
			const formData = new FormData(form);
		    const exercise = formData.get('exercise');
		    const study = formData.get('study');
		    const sleep = formData.get('sleep');
		
			const params = new URLSearchParams();
			params.append('exercise', exercise);
			params.append('study', study);
			params.append('sleep', sleep);
				
			if (!showConfirm('登録しますか？')) {
				console.log('iie');
				e.preventDefault();
				return;
			}
		
		    fetch(`${contextPath}/${registEndpoint}`, {
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
		}
	});
}	


/*
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
*/










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

//パスワードの確認
export function registPwMatch(formId, mismatchMessage = 'パスワードが一致しません', confirmMessage = 'この内容で登録してよろしいですか？') {
    const form = document.getElementById(formId);

    form.addEventListener('submit', function(e) {
        const password = form.querySelector('[name="password"]').value;
        const confirm = form.querySelector('[name="confirm_password"]').value;

        if (password !== confirm) {
            console.warn("パスワード不一致");
            alert(mismatchMessage);
            e.preventDefault(); 
            return;
        }

        // パスワード一致した場合
        const ok = showConfirm(confirmMessage);
        if (!ok) {
            e.preventDefault();
        }
    });
}






