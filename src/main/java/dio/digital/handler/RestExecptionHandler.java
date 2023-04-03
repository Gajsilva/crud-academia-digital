package dio.digital.handler;

import dio.digital.error.ResourceNotFoundDetails;
import dio.digital.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExecptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> hanlerResourceNotFoundExecption(ResourceNotFoundException rfnExeption){
        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rfnExeption.getMessage())
                .developerMessage(rfnExeption.getClass().getName())
                .build();
        return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
    }
}
