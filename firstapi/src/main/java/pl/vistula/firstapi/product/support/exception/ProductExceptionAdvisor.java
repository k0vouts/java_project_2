package pl.vistula.firstapi.product.support.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.vistula.firstapi.product.exception.ProductNotFoundException;
import pl.vistula.firstapi.shared.api.response.ErrorMessageResponse;

@ControllerAdvice
public class ProductExceptionAdvisor {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessageResponse> handleProductNotFoundException(ProductNotFoundException exception) {
        ErrorMessageResponse errorResponse = new ErrorMessageResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}