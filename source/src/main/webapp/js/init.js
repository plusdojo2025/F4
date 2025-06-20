// 初期化する
import {
    initAddTodo,
    initDeleteButtons,
    initCheckboxes,
    initConfirmOnSubmit,
    registPwMatch,
    registCheck
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

   /* document.getElementById('registGoalForm') && (
        console.log('✅ registGoalForm: 確認処理を呼び出し'),
        initConfirmOnSubmit('registGoalForm','入力に間違いはないですか？')
    );*/

    document.getElementById('logoutForm') && (
        console.log('✅ logoutForm: 確認処理を呼び出し'),
        initConfirmOnSubmit('logoutForm','ログアウトしてもよろしいですか？')
    );
    
    document.getElementById('registTime') && (
        console.log('✅ registTime: 確認処理を呼び出し'),
/*        initRegistTime('registTime', contextPath)
*/        registCheck('registTime','合計24時間以内に収めてください', contextPath, 'registTime')

    );
  
	document.getElementById('registUserForm') && (
		console.log('✅ registUserForm: 処理を呼び出し'),
		registPwMatch(
	        'registUserForm',
	        'パスワードが一致しません。もう一度確認してください。',
	        '入力内容に間違いはありませんか？'
	   	)
	);
	
	document.getElementById('registGoalForm') && (
		console.log('✅ registGoalForm: 内容確認処理を呼び出し'),
/*		registGoalCheck('registGoalForm','合計24時間以内に収めてください','入力に間違いはないですか？')
*/		registCheck('registGoalForm','合計24時間以内に収めてください', contextPath, 'registGoal')
		);

});
