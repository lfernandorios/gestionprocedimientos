package com.chinita.company.gestionprocedimientos.api.shared.web.exception;

public class NotAuthorizedException extends RuntimeException {

    private static final long serialVersionUID = -5644568184780083105L;

    public NotAuthorizedException(String message) {
        super(message);
    }

    public NotAuthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
