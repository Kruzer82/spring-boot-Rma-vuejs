package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.model.Seller;
import de.jonashackt.springbootvuejs.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "")
class ExceptionNotFound extends RuntimeException {
    public ExceptionNotFound() {
        super();
    }
}

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "")
class ExceptionBadGateway extends RuntimeException {
    public ExceptionBadGateway() {
        super();
    }
}
