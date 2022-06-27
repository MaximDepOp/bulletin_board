package ru.dorofeev.bulletin_board.model.base;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subcategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_object_generator")
    @SequenceGenerator(name = "type_object_generator", sequenceName = "type_object_seq")
    private Long id;

    @NotNull(message = "The field should not be null!")
    @NotBlank(message = "The field should not be empty!")
    @Column(unique = true)
    private String name;

    @ManyToOne
    private Category category;
}