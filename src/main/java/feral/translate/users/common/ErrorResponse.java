package feral.translate.users.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {
    private String errorMessage;
}
