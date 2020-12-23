package com.sami.supershop.domain;

import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Role extends BaseEntity {
    private String roleDescription;
    private String roleValue;
}
