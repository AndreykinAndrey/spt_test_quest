package test.back.quest;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import test.back.quest.model.ApiError;
import test.back.quest.model.DocumentError;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionTranslator {


    /**
     * Тут перехватываем ошибки валидации полей проверяемых JSON
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleConstraintViolationException(MethodArgumentNotValidException ex){

        List<DocumentError> docErrors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            System.out.println(((FieldError) error).getField());
            System.out.println(error.getDefaultMessage());
            docErrors.add(new DocumentError(((FieldError) error).getField(), error.getDefaultMessage()));

        });

        return ResponseEntity.badRequest().body(new ApiError("Document fields not valid", docErrors));
    }


    /**
     * Тут перехватываем все остальные ошибки. В том числе некорректный формат JSON
     */
    @ExceptionHandler
    public ResponseEntity<?> handleConstraintViolationException(Exception exception){
        return ResponseEntity.badRequest().body(new ApiError(exception.getMessage(), null));
    }
}
