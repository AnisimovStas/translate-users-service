package feral.translate.users.domain.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpRequest {

    @Size(min = 3, max = 32, message = "Имя пользователя должно содержать от 5 до 50 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;

    @Size(min = 5, max = 32, message = "Адрес электронной почты должен содержать от 5 до 32 символов")
    @NotBlank(message = "Адрес электронной почты не может быть пустыми")
    private String email;

    @Size(max = 32, message = "Длина пароля должна быть не более 32 символов")
    private String password;
}