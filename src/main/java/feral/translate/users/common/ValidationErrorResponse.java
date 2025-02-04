package feral.translate.users.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ValidationErrorResponse {
    private String errorMessage;
    private List<ValidationError> errors;
}
