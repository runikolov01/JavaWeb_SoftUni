package bg.softuni.Pathfinder.model.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserRegisterDTO {
    @NotEmpty
    @NotNull
    private String username;

    @NotEmpty
    @Size(min = 5)
    private String fullName;

    @Min(0)
    @Max(90)
    private Integer age;

    @Email
    private String email;

    @Size(min = 5)
    private String password;

    private String confirmPassword;
}