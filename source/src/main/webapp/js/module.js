// js/todoModule.js

// 確認アラート
export function showConfirm(message = '本当に削除しますか？') {
    return window.confirm(message);
}

// ToDo追加処理
// ToDo追加処理
export function initAddTodo(formId, inputId, contextPath, userId) {
    const form = document.getElementById(formId);
    const input = document.getElementById(inputId);
    const messageBox = document.getElementById('messageBox'); // エラーメッセージ表示用

    form.addEventListener('submit', function (e) {
        e.preventDefault();
        const todoText = input.value.trim();

        // エラーメッセージをリセット
        if (messageBox) messageBox.textContent = '';

        // 入力が空の場合
        if (!todoText) {
            if (messageBox) messageBox.textContent = '入力してください。';
            return;
        }

        // 50文字を超えている場合
        if (todoText.length > 50) {
            if (messageBox) messageBox.textContent = '50文字以内で入力してください。';
            return;
        }

        fetch(`${contextPath}/addTodo`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: new URLSearchParams({ todoText, id: userId })
        })
        .then(res => {
            if (!res.ok) throw new Error('追加エラー');
            location.reload(); // 成功時リロード
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
export function registCheck(formId, overMessage = '合計24時間以内に収めてください', contextPath, registEndpoint) {
	const form = document.getElementById(formId);
	if (!form) {
		console.error(`フォームID "${formId}" が見つかりません`);
		return;
	}

	form.addEventListener('submit', function (e) {

		const exercise = Number(form.querySelector('[name=exercise]').value);
		const study = Number(form.querySelector('[name=study]').value);
		const sleep = Number(form.querySelector('[name=sleep]').value);
		const total = exercise + study + sleep;

		if (total > 24) {
			alert(overMessage);
			e.preventDefault(); // ここは常に止めておかないとエラー送信される
			return;
		}

		if (!showConfirm('登録しますか？')) {
			e.preventDefault(); // これも止める
			return;
		}

		// 非同期を使わないパターン（registGoal のとき）
		if (registEndpoint === 'registGoal') {
			// ↓↓ 通常送信させる（fetch も preventDefault もしない）
			return; 
		}

		// 非同期処理：ここから先は fetch による送信
		e.preventDefault();

		const formData = new FormData(form);
		const params = new URLSearchParams(formData);

		fetch(`${contextPath}/${registEndpoint}`, {
			method: 'POST',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			body: params.toString()
		})
			.then(res => {
				if (!res.ok) throw new Error('登録エラー');
				return res.text();
			})
			.then(() => {
				const messageBox = document.getElementById('messageBox');
				if (messageBox) {
					messageBox.innerText = '登録が完了しました！\n評価を確認してみましょう';
					messageBox.style.display = 'block';
				}
				form.reset();
			})
			.catch(err => {
				console.error('登録失敗:', err);
				alert('登録に失敗しました。再度お試しください。');
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