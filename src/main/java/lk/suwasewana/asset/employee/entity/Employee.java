package lk.suwasewana.asset.employee.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.suwasewana.asset.commonAsset.model.Enum.CivilStatus;
import lk.suwasewana.asset.commonAsset.model.Enum.Gender;
import lk.suwasewana.asset.employee.entity.Enum.Designation;
import lk.suwasewana.asset.employee.entity.Enum.EmployeeStatus;
import lk.suwasewana.asset.message.entity.EmailMessage;
import lk.suwasewana.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("Employee")
public class Employee extends AuditEntity {


    @Size(min = 5, message = "Enter your Name ")
    private String name;

    @Size(max = 12, min = 10, message = "NIC number is contained numbers between 9 and X/V or 12 ")
    @Column(unique = true)
    private String nic;

    @Size(max = 10, message = "Mobile number length should be contained 10 and 9")
    private String mobileOne;

    private String mobileTwo;

    @Column(unique = true)
    private String email;

    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NULL", length = 255)
    private String address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Designation designation;

    @Enumerated(EnumType.STRING)
    private CivilStatus civilStatus;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfAssignment;


    @ManyToMany(mappedBy = "employees")
    private List<EmailMessage> emailMessages;

    @Transient
    private List<MultipartFile> files = new ArrayList<>();

    @Transient
    private List<String> removeImages = new ArrayList<>();



}
