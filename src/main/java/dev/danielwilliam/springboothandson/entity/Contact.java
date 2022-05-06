package dev.danielwilliam.springboothandson.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "First name cannot be blank.")
    private String firstName;

    private String lastName;

    @NotEmpty(message = "Phone number is mandatory.")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Please enter a valid phone number.")
    private String phoneNumber;

    @NotEmpty(message = "Email id is mandatory.")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Please enter a valid email id.")
    private String emailId;

}
