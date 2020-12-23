package com.sami.supershop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Blob;

@Entity
@Getter
@Setter
public class Picture extends BaseEntity {
    private Blob photo;
    @ManyToOne
    private Product product;
}
