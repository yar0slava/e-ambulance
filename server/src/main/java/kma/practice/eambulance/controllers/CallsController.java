package kma.practice.eambulance.controllers;

import javassist.NotFoundException;
import kma.practice.eambulance.dto.CallDto;
import kma.practice.eambulance.service.CallService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/calls")
public class CallsController {

    private final CallService callService;

    public CallsController(CallService callService) {
        this.callService = callService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CallDto getCall(@PathVariable("id") Long callId) throws NotFoundException {
        return null;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CallDto updateCall(@RequestBody CallDto callDto) {
        return null;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CallDto> getAllCalls(){
        return null;
    }

}
