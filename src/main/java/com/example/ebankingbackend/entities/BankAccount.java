package com.example.ebankingbackend.entities;

import com.example.ebankingbackend.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", length = 4)
public abstract class BankAccount {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private double balance;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @ManyToOne
    private Customer customer;
    @OneToMany (mappedBy ="bankAccount",fetch = FetchType.LAZY)
    private List<AccountOperation> accountOperations;



}
