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
@Table(name = "student", schema = "monitor")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger id;

    @Column(name = "date_of_birth", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;

    @Column(name = "f_name", nullable = false)
    String firstName;

    @Column(name = "m_name")
    String middleName;

    @Column(name = "l_name", nullable = false)
    String lastName;

    @Column(nullable = false)
    String marks;

    @Column(name = "addr_line1", nullable = false)
    String addressLine1;

    @Column(name = "addr_line2", nullable = false)
    String addressLine2;
}
