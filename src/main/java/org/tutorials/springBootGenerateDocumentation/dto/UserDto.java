package org.tutorials.springBootGenerateDocumentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "User DTO Model Information"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    @Schema(
            description = "User first name"
    )
    // User first name should not should be or empty
    @NotEmpty(message = "First name should not be or empty")
    private String firstName;

    @Schema(
            description = "User last name"
    )
    // User last name should not should be or empty
    @NotEmpty(message = "Last name should not be or empty")
    private String lastName;

    @Schema(
            description = "User email"
    )
    // User email should not should be or empty
    // User email should be a valid email address
    @NotEmpty(message = "Email should not be or empty")
    @Email(message = "Email should be a valid email address")
    private String email;
}
