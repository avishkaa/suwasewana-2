package lk.suwasewana.asset.invoice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lk.suwasewana.asset.collectingCenter.entity.CollectingCenter;
import lk.suwasewana.asset.discountRatio.entity.DiscountRatio;
import lk.suwasewana.asset.doctor.entity.Doctor;
import lk.suwasewana.asset.invoice.entity.Enum.InvoicePrintOrNot;
import lk.suwasewana.asset.invoice.entity.Enum.PaymentMethod;
import lk.suwasewana.asset.medicalPackage.entity.MedicalPackage;
import lk.suwasewana.asset.patient.entity.Patient;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(value = {"createdAt", "updatedAt","balance","discountAmount","bankName","cardNumber"}, allowGetters = true)
public class Invoice {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number", nullable = false, unique = true)
    private Integer number;

    @Column(name = "payment_method", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;


    @Column(name = "totalprice", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalprice;


    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "discountAmount",  precision = 10, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "amountTendered", precision = 10, scale = 2)
    private BigDecimal amountTendered;

    @Column(name = "balance", precision = 10, scale = 2)
    private BigDecimal balance;

    @Column(name = "bank_name")
    private String bankName;


    @Column(name = "card_number")
    private Integer cardNumber;


    @Column(name = "remarks", length = 150)
    private String remarks;

    @Enumerated(EnumType.STRING)
    private InvoicePrintOrNot invoicePrintOrNot;

    @Column(name = "created_at", nullable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @Column(nullable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime invoicedAt;


    @ManyToOne
    private Patient patient;

    @ManyToOne
    private CollectingCenter collectingCenter;

    @ManyToOne
    private DiscountRatio discountRatio;


    @ManyToOne
    private MedicalPackage medicalPackage;

    @ManyToOne
    private Doctor doctor;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceHasLabTest> invoiceHasLabTests = new ArrayList<>();

}
