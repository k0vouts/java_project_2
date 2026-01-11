package pl.vistula.firstapi.shared.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ErrorMessageResponse {
    private String message;
}
