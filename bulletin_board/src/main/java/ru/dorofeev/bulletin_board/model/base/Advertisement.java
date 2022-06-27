package ru.dorofeev.bulletin_board.model.base;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Advertisement implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "advertisement_generator")
    @SequenceGenerator(name = "advertisement_generator", sequenceName = "advertisement_seq")
    private Long id;

    @NotNull(message = "The field should not be null!")
    @NotBlank(message = "The field should not be empty!")
    private String name;

    @NotNull(message = "The field should not be null!")
    private Date create_date;

    @ManyToOne
    private Subcategory subcategory;

    private String description;

    @Min(0)
    private BigDecimal price;

    @ManyToOne
    private Locality locality;

    @ManyToOne
    private Street street;

    private String houseNumber;
}
