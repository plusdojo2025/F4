// 初期化する
import {
    initAddTodo,
    initDeleteButtons,
    initCheckboxes,
    initConfirmOnSubmit,
    registPwMatch,
} from './module.js';

console.log('init.js 読み込まれた');

document.addEventListener('DOMContentLoaded', () => {
    const contextPath = document.body.dataset.contextPath || '';
    const userId = 1;

    // ToDo画面の初期化
    const todoForm = document.getElementById('todoForm');
    if (todoForm) {
        initAddTodo('todoForm', 'todoInput', contextPath, userId);
        initDeleteButtons('deleteButton', contextPath);
        initCheckboxes('checkbox', contextPath);
    }
 
    console.log('📄 DOMContentLoaded: ページ読み込み完了');

    document.getElementById('registUserForm') && (
        console.log('✅ registUserForm: 確認処理を呼び出し'),
        initConfirmOnSubmit('registUserForm', 'この内容ので間違いないですか？')
    );

    document.getElementById('registGoalForm') && (
        console.log('✅ registGoalForm: 確認処理を呼び出し'),
        initConfirmOnSubmit('registGoalForm','入力に間違いはないですか？')
    );

    document.getElementById('logoutForm') && (
        console.log('✅ logoutForm: 確認処理を呼び出し'),
        initConfirmOnSubmit('logoutForm','ログアウトしてもよろしいですか？')
    );

    document.getElementById('registTime') && (
        console.log('✅ registTime: 確認処理を呼び出し'),
        initConfirmOnSubmit('registTime','入力内容は間違いないですか？')
    );

	//ユーザー情報登録画面のパスワード確認の判定
  	document.getElementsById('submit').addEventListListener('click',()=>{
		const registUserForm = document.getElementById('registUserForm');
	  	 if(registUserForm){
			registPwMatch('registUserForm', contextPath);
		}
	}
});
