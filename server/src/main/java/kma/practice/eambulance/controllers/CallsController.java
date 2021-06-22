package kma.practice.eambulance.controllers;

import javassist.NotFoundException;
import kma.practice.eambulance.dto.CallDto;
import kma.practice.eambulance.service.CallService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
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
        return callService.readById(callId);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CallDto updateCall(@RequestBody CallDto callDto) {
        return callService.update(callDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CallDto saveCall(@RequestBody CallDto callDto) {
        return callService.create(callDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCall(@PathVariable("id") Long callId) {
        callService.delete(callId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CallDto> getAllCalls(){
        return callService.getAll();
    }

    @GetMapping("/crew/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CallDto> getCallsByCrew(@PathVariable("id") Long crewTabNumber){
        return callService.findByCrew(crewTabNumber);
    }
}
