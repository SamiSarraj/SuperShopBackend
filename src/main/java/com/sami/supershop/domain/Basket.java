package com.sami.supershop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Basket extends BaseEntity {
private String status;
@OneToOne
@JoinColumn
private User user;
@OneToOne
@JoinColumn(name = "wallet_id")
private Wallet wallet;

}
