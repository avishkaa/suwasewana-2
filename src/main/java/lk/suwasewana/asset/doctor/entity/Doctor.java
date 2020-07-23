package lk.suwasewana.asset.doctor.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lk.suwasewana.asset.commonAsset.model.Enum.Gender;
import lk.suwasewana.asset.commonAsset.model.Enum.Title;
import lk.suwasewana.asset.consultation.entity.Consultation;
import lk.suwasewana.util.audit.AuditEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Doctor extends AuditEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    @Enumerated(EnumType.STRING)
    private Title title;

    @Column(name = "name", length = 45)
    private String name;


    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(fetch = FetchType.EAGER)
    private Consultation consultation;


    @Column(name = "slmc_number", unique = true)
    private Integer slmcNumber;


    @Column(name = "mobile")
    private String mobile = "No mobile number";


    @Column(name = "land", length = 10)
    private String land;


    @Email(message = "Please provide valid email")
    @Column(name = "email", length = 45)
    private String email;






/*    @OneToMany(mappedBy = "doctor")
    private List<Invoice> invoices = new ArrayList<>();*/

}