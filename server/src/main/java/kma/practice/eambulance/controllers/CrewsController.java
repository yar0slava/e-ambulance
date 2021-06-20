package kma.practice.eambulance.controllers;

import javassist.NotFoundException;
import kma.practice.eambulance.dto.CrewDto;
import kma.practice.eambulance.service.CrewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/crews")
public class CrewsController {

    private final CrewService crewService;

    public CrewsController(CrewService crewService) {
        this.crewService = crewService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CrewDto getCall(@PathVariable("id") Long callId) throws NotFoundException {
        return crewService.readById(callId);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CrewDto updateCall(@RequestBody CrewDto crewDto) {
        return crewService.update(crewDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CrewDto saveCall(@RequestBody CrewDto crewDto) {
        return crewService.create(crewDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCall(@PathVariable("id") Long callId) {
        crewService.delete(callId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CrewDto> getAllCalls(){
        return crewService.getAll();
    }
}
