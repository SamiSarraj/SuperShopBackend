package com.sami.supershop.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User extends BaseEntity{

    private String username;    // username need to be not nullable
    private String password; //password need to be hashed and not nullable
    @JsonIgnore
    @ManyToOne
    private Role role;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private UserInformation userInformation;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Basket basket;
    //one to one with role //need to be not nullable
    //one to one with user information // can be nullable
}
