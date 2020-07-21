package lk.suwasewana.asset.labTest.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.suwasewana.asset.invoice.entity.InvoiceHasLabTest;
import lk.suwasewana.asset.labTest.entity.Enum.Department;
import lk.suwasewana.asset.labTest.entity.Enum.LabtestDoneHere;
import lk.suwasewana.asset.labTestParameter.entity.LabTestParameter;
import lk.suwasewana.asset.medicalPackage.entity.MedicalPackage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("LabTest")
public class LabTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false, length = 6, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", precision=10, scale=2)
    private BigDecimal price;

    @Column(name = "sample_collecting_tube", nullable = false, length = 20)
    private String sampleCollectingTube;

    @Column(name = "department", nullable = false)
    @Enumerated(EnumType.STRING)
    private Department department;


    @Enumerated(EnumType.STRING)
    private LabtestDoneHere labtestDoneHere;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "labTest", fetch = FetchType.EAGER)
    private List<InvoiceHasLabTest>  invoiceHasLabTests= new ArrayList<>();

    @ManyToMany(mappedBy = "labTests",fetch=FetchType.LAZY)
    private List<MedicalPackage> medicalPackages = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "labtest_has_parameter",
            joinColumns = @JoinColumn(name = "labtest_id"),
            inverseJoinColumns = @JoinColumn(name = "labtest_parameter_id"))
    private List<LabTestParameter> labTestParameters = new ArrayList<>();

}
