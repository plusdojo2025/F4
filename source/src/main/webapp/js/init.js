// 初期化する
import {
    initAddTodo,
    initDeleteButtons,
    initCheckboxes,
    initRegistTime,
    initLogoutConfirm,
    initCheckForm
} from './module.js';

/*console.log('init.js 読み込まれた');
*/
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
    
    // 登録画面の初期化
    const registForm = document.getElementById('registTime');
    if (registForm) {
        initRegistTime('registTime', contextPath);
    } 
    
    // ✅ ログアウト確認処理の追加
  	initLogoutConfirm('logoutForm');    
  	
    
  	 

});
