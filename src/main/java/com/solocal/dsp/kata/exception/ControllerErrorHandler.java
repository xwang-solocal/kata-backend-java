package com.solocal.dsp.kata.exception;

import com.solocal.dsp.kata.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@ControllerAdvice
public class ControllerErrorHandler extends ResponseEntityExceptionHandler {

    public static DateTimeFormatter FORMATTER_DATE_TIMESTAMP = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z").withZone(ZoneId.of("Europe/Paris"));

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleErrorException(Exception exception, WebRequest request) throws Exception {
        log.error("Exception occurred", exception);
        ResponseEntity<Object> responseEntity = handleMcdRuntimeExceptionException(exception, request);
        if (null == responseEntity) {
            responseEntity = super.handleException(exception, request);
        }
        return buildErrorResponse(responseEntity.getStatusCode(), exception, ((ServletWebRequest) request).getRequest());
    }

    private ResponseEntity<Object> handleMcdRuntimeExceptionException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status;
        if (ex instanceof OnelineStoreRuntimeException) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity(null, headers, status);
        }
        return null;
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseEntity<Object> responseEntity = this.handleExceptionInternal(ex, null, headers, status, request);
        return buildErrorResponse(responseEntity.getStatusCode(), ex, ((ServletWebRequest) request).getRequest());
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseEntity<Object> responseEntity = this.handleExceptionInternal(ex, null, headers, status, request);
        return buildErrorResponse(responseEntity.getStatusCode(), ex, ((ServletWebRequest) request).getRequest());

    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseEntity<Object> responseEntity = this.handleExceptionInternal(ex, null, headers, status, request);
        return buildErrorResponse(responseEntity.getStatusCode(), ex, ((ServletWebRequest) request).getRequest());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseEntity<Object> responseEntity = this.handleExceptionInternal(ex, null, headers, status, request);
        return buildErrorResponse(responseEntity.getStatusCode(), ex, ((ServletWebRequest) request).getRequest());
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseEntity<Object> responseEntity = this.handleExceptionInternal(ex, null, headers, status, request);
        return buildErrorResponse(responseEntity.getStatusCode(), ex, ((ServletWebRequest) request).getRequest());
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseEntity<Object> responseEntity = this.handleExceptionInternal(ex, null, headers, status, request);
        return buildErrorResponse(responseEntity.getStatusCode(), ex, ((ServletWebRequest) request).getRequest());
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseEntity<Object> responseEntity = this.handleExceptionInternal(ex, null, headers, status, request);
        return buildErrorResponse(responseEntity.getStatusCode(), ex, ((ServletWebRequest) request).getRequest());
    }

    private ResponseEntity<Object> buildErrorResponse(HttpStatus status, Exception ex, HttpServletRequest request) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .errorCode(status.value())
                        .errorMessage(ex.getMessage())
                        .servicePath(request.getServletPath())
                        .timestamp(ZonedDateTime.now().format(FORMATTER_DATE_TIMESTAMP))
                        .build(), status);
    }

}
