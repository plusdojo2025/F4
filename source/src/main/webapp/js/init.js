
//初期化する

import {
    initAddTodo,
    initDeleteButtons,
    initCheckboxes
} from './module.js';

document.addEventListener('DOMContentLoaded', () => {
    const contextPath = document.body.dataset.contextPath; // アプリのルートパス現在は/F4が入っている
    const userId = 1; // セッション管理で動的に取得すべき

    //関数呼び出し（引数）
    initAddTodo('todoForm', 'todoInput', contextPath, userId);
    initDeleteButtons('deleteButton', contextPath);
    initCheckboxes('checkbox', contextPath);
});
 