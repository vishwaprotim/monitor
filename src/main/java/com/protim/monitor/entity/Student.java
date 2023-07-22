package com.protim.monitor.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name="student", schema="monitor")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger id;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;
    @Column(nullable = false)
    String firstName;
    String middleName;
    @Column(nullable = false)
    String lastName;
    @Column(nullable = false)
    String marks;
    @Column(nullable = false)
    String addressLine1;
    String addressLine2;
}
