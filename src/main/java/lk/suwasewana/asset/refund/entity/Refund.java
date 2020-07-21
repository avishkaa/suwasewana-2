package lk.suwasewana.asset.refund.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lk.suwasewana.asset.invoice.entity.Invoice;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonIgnoreProperties annotation is a Jackson annotation. Spring Boot uses Jackson for Serializing and Deserialize Java objects to and from JSON.
@JsonIgnoreProperties(value = "createdAt", allowGetters = true)
//implements Serializable
public class Refund {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
                    CascadeType.DETACH})
    private Invoice invoice;


    @Column(name = "amount", precision = 10, scale = 2)
    private BigDecimal amount;


    @Column(name = "reason", length = 45)
    private String reason;


}
