package dto;

import java.io.Serializable;

public class usersDTO implements Serializable {
    private int id;
    private String user_name;
    private String mail;
    private String pw;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }

    public usersDTO(int id, String user_name, String mail, String pw) {
        this.id = id;
        this.user_name = user_name;
        this.mail = mail;
        this.pw = pw;
    }

    public usersDTO() {
        this.id = 0;
        this.user_name = "";
        this.mail = "";
        this.pw = "";
    }
}