package feral.translate.users.domain.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignInRequest {

    @Size(min = 5, max = 50, message = "Имя пользователя должно содержать от 5 до 50 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;

    @Size(max = 32, message = "Длина пароля должна быть не более 32 символов")
    @NotBlank(message = "Пароль не может быть пустыми")
    private String password;
}