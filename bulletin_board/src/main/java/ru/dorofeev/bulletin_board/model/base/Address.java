package ru.dorofeev.bulletin_board.model.base;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"locality_id", "street_id", "houseNumber"})
})
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_generator")
    @SequenceGenerator(name = "address_generator", sequenceName = "address_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Locality locality;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Street street;

    private String houseNumber;
}
