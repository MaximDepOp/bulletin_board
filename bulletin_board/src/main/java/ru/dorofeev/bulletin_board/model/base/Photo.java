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
@ToString
public class Photo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "photo_generator")
    @SequenceGenerator(name = "photo_generator", sequenceName = "photo_seq")
    private Long id;

    @NotNull(message = "The field should not be null!")
    @NotBlank(message = "The field should not be empty!")
    private String name;

    @Column(unique = true)
    private String urn;

    @ManyToOne
    private Advertisement advertisement;
}
