package org.project.curriculum.pojo;

/**
 * @Auther: hzy
 * @Date: 2022/2/8 13:49
 * @Description:
 */

public class user {
    private Integer id;
    private String account;
    private String password;

    public user() {
    }

    public user(int id, String account, String password) {
        this.id = id;
        this.account = account;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
