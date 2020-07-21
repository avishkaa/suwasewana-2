package lk.suwasewana.asset.labTestParameter.entity;


import lk.suwasewana.asset.invoice.entity.InvoiceHasLabTest;
import lk.suwasewana.asset.labTest.entity.LabTest;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ResultTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 7)
    private String result;

    @Column(length = 7)
    private String absoluteCount;

    @ManyToOne
    @JoinColumn(name = "invoice_has_lab_test_id")
    private InvoiceHasLabTest invoiceHasLabTest;

    @ManyToOne
    @JoinColumn(name = "labtest_id")
    private LabTest labTest;

    @ManyToOne
    @JoinColumn(name = "labtest_parameter_id")
    private LabTestParameter labTestParameter;


}
