package com.game.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "UserMy")
@Data
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long id;

    @Column(name = "UserID")
    public String userId;

    @Column(name = "AttemptID")
    public int attemptNo;

    @Column(name = "Multiplication")
    public String multiplication;

    @Column(name = "UserAnswer")
    public int userAnswer;

    @Column(name = "Result")
    public Boolean result;

    public User(){

    }

}
