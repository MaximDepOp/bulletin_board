package ru.dorofeev.bulletin_board.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @Transient
    private final String regexNumberPhone = "^7\\d{10}$";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq")
    private Long id;

    @NotNull(message = "The field should not be null!")
    @NotBlank(message = "The field should not be empty!")
    @Email(message = "The email should be valid")
    @Column(unique = true)
    private String login;

    @NotNull(message = "The field should not be null!")
    @NotBlank(message = "The field should not be empty!")
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    @JsonIgnore
    private Set<Role> roles;

    @NotNull(message = "The field should not be null!")
    @NotBlank(message = "The field should not be empty!")
    private String username;

    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull(message = "The field should not be null!")
    @NotBlank(message = "The field should not be empty!")
    @Pattern(regexp = regexNumberPhone, message = "The phone number must be valid")
    private String phoneNumber;
}
