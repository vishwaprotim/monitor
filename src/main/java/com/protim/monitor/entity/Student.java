package com.protim.monitor.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
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

    @Schema(description = "Unique id of the Student. Generated automatically", requiredMode = RequiredMode.NOT_REQUIRED, hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger id;

    @Schema(description = "Student's date of the birth in YYYY-MM-DD format", requiredMode = RequiredMode.REQUIRED, example = "1993-03-15")
    @Column(name = "date_of_birth", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;

    @Schema(description = "Student's first name", requiredMode = RequiredMode.REQUIRED, example = "Vishwa")
    @Column(name = "f_name", nullable = false)
    String firstName;

    @Schema(description = "Student's middle name", requiredMode = RequiredMode.NOT_REQUIRED, example = "Protim")
    @Column(name = "m_name")
    String middleName;

    @Schema(description = "Student's last name", requiredMode = RequiredMode.REQUIRED, example = "Banerjee")
    @Column(name = "l_name", nullable = false)
    String lastName;

    @Schema(description = "Student's marks", requiredMode = RequiredMode.REQUIRED, example = "30.5")
    @Column(nullable = false)
    String marks;

    @Schema(description = "Student's address line#1", requiredMode = RequiredMode.REQUIRED, example = "BXXXX Hillside View Apartments")
    @Column(name = "addr_line1", nullable = false)
    String addressLine1;

    @Schema(description = "Student's address line#2", requiredMode = RequiredMode.NOT_REQUIRED, example = "Hinjewadi, Pune, Maharashtra")
    @Column(name = "addr_line2", nullable = false)
    String addressLine2;
}
