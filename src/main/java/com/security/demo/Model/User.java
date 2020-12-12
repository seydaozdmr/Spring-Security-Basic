package com.security.demo.Model;

import javax.persistence.*;
import java.util.List;

//Spring JPA özelliklerini User ve Role sınıflarında kullanıyorum.
//Entity ve Table annotations özelliklerini kullanıyorum.
//Mysql veri tabanında bu sınıfları tablo haline getiriyorum
//tablolara arasında Manytomany ilişkisi var bunu Hibernate otomatik olarak veritabanında oluşturuyor.
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private boolean active;

    //Rolleri liste olarak oluşturdum.
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns = {@JoinColumn(name="USER_ID",referencedColumnName = "ID")},
    inverseJoinColumns = {@JoinColumn(name = "ROLE_ID",referencedColumnName = "ID")})
    private List<Role> roles;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


}
