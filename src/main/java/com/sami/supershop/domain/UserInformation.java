package com.sami.supershop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Getter
@Setter
public class UserInformation extends BaseEntity {
    private String name;
    private Long phone;
    private String email;
    private String address;
    private Date birthday;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
