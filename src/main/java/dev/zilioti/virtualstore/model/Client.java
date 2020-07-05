package dev.zilioti.virtualstore.model;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "idclient")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String password;

    public Client(){}

    public Client(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Client(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void cleanPassword(){
        setPassword(null);
    }

}
