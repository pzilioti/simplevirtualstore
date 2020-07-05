package dev.zilioti.virtualstore.model;

import javax.persistence.*;

@Entity
@Table(name = "user_authetication")
public class UserAuthentication {

    @Id
    @Column(name = "iduser_authetication")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name_user;
    private String token;

    public UserAuthentication(){}

    public UserAuthentication(String name_user, String token){
        this.name_user = name_user;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
