package sirma_business.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

// This class provides centralized exception handling for all controllers
@RestControllerAdvice
public class ProjectControllerHandler {

    //Exception Handler for MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProjectResponse> methodArgumentNotValidException(MethodArgumentNotValidException exception) {

        //Extract error messages from the exception and map then to a list
        List<String> errorMessages = exception.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .toList();

        //create a response object and set error messages, exception message  and timestamp
        ProjectResponse response = new ProjectResponse();
        response.setError_messages(errorMessages);
        response.setException_message(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setTimestamp(LocalDateTime.now());

        // Return the response entity with the response object with HTTP status code
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);


    }

    //Exception Handler for ProjectNotFoundException
    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<String> handleProjectNotFoundException(ProjectNotFoundException ex) {
        // Return the response entity with the exception message and HTTP status code
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
