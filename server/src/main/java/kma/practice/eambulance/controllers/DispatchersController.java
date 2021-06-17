package kma.practice.eambulance.controllers;

import javassist.NotFoundException;
import kma.practice.eambulance.dto.DispatcherDto;
import kma.practice.eambulance.service.DispatcherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispatchers")
public class DispatchersController {

    private final DispatcherService dispatcherService;

    public DispatchersController(DispatcherService dispatcherService) {
        this.dispatcherService = dispatcherService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DispatcherDto getCall(@PathVariable("id") Long callId) throws NotFoundException {
        return dispatcherService.readById(callId);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public DispatcherDto updateCall(@RequestBody DispatcherDto dispatcherDto) {
        return dispatcherService.update(dispatcherDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public DispatcherDto saveCall(@RequestBody DispatcherDto dispatcherDto) {
        return dispatcherService.create(dispatcherDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCall(@PathVariable("id") Long callId) {
        dispatcherService.delete(callId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<DispatcherDto> getAllCalls(){
        return dispatcherService.getAll();
    }

}
