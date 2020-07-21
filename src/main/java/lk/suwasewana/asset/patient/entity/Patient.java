package lk.suwasewana.asset.patient.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.suwasewana.asset.commonAsset.model.Enum.Gender;
import lk.suwasewana.asset.commonAsset.model.Enum.Title;
import lk.suwasewana.util.audit.AuditEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonFilter("Patient")
public class Patient extends AuditEntity {

    @Column(nullable = false, unique = true)
    @NotNull(message = "This code is already add or enter incorrectly")
    private String number;

    @Pattern(regexp = "^([a-zA-Z\\s]{4,})$", message = " This name can not accept, Please check and try again, Name should be included more than four ccharacter")
    private String name;

    @Column(length = 12, unique = true)
    @Pattern(regexp = "^([\\d]{9}[v|V|x|X])$|^([\\d]{12})$", message = "NIC number is contained numbers between 9 and X/V or 12 ")
    private String nic;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Title title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Birthday should be included")
    private LocalDate dateOfBirth;

    @Email(message = "Please provide a valid Email")
    private String email;


    @Min(value = 9, message = "Should be needed to enter valid mobile number")
    private String mobile;


    private String land;


/*
    @OneToMany
    private List<Invoice> invoices = new ArrayList<>();*/


}

