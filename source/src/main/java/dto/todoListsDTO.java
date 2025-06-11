package dto;

public class todoListsDTO{
    private int todo_list_id;
    private int id;
    private String list_content;
    private boolean checkbox;


    public todoListsDTO(int id, String list_content){
        this.id = id;
        this.list_content = list_content;
        this.checkbox = false;//初期値false
    }

    //以下それぞれのゲッタ　セッタ
    public int getTodo_list_id() {
        return todo_list_id;
    }

    public void setTodo_list_id(int todo_list_id) {
        this.todo_list_id = todo_list_id;
    }

    public int getId() {
        return id;//userのID
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getList_content() {
        return list_content;
    }

    public void setList_content(String list_content) {
        this.list_content = list_content;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }

}


