package com.pojo;

//PW这个库的代码
public class PW {
    public String passwords;
    public String url;
    public Integer id;

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PW{" +
                "passwords='" + passwords + '\'' +
                ", url='" + url + '\'' +
                ", id=" + id +
                '}';
    }
}
