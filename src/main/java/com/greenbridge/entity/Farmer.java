package com.greenbridge.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "farmers")
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer farmerId;
    private String firstName;
    private String lastName;
    private String userName;
    private Integer age;
    private String gender;
    private String password;
    private String mobileNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "farmer")
    private List<Crop> crops;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "farmer")
    private List<Role> role;


    public Farmer(String firstName, String lastName, Integer age, String gender, String password, String mobileNumber, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }
}
