package com.capgemini.go.excpetion;

import java.sql.SQLException;
// import javax.servlet.http.HttpServletRequest;
// import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RetailerErrorAdvice {

    @ExceptionHandler({ RetailerExcpetion.class, SQLException.class, NullPointerException.class })
    public ResponseEntity<ErrorInfo> handle1(RetailerExcpetion ce) {
        ErrorInfo error = new ErrorInfo(ce.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}