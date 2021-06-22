package kma.practice.eambulance.controllers;

import kma.practice.eambulance.config.JwtUtil;
import kma.practice.eambulance.database.entities.CredentialsEntity;
import kma.practice.eambulance.dto.LoginResponseDto;
import kma.practice.eambulance.dto.CredentialsDto;
import kma.practice.eambulance.service.impl.CredentialsServiceImpl;
import kma.practice.eambulance.service.impl.CrewServiceImpl;
import kma.practice.eambulance.service.impl.DispatcherServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping()
public class SecurityController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CredentialsServiceImpl credentialsService;
    private final CrewServiceImpl crewService;
    private final DispatcherServiceImpl dispatcherService;

    public SecurityController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, CredentialsServiceImpl credentialsService, CrewServiceImpl crewService, DispatcherServiceImpl dispatcherService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.credentialsService = credentialsService;
        this.crewService = crewService;
        this.dispatcherService = dispatcherService;
    }

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponseDto login(@RequestBody CredentialsDto credentialsDto) throws  Exception{
        authenticate(credentialsDto.getLogin(), credentialsDto.getPassword());
        final UserDetails userDetails = credentialsService.loadUserByUsername(credentialsDto.getLogin());
        final String token = jwtUtil.generateToken(userDetails);

        String authority = ((CredentialsEntity)userDetails).getAuthority();
        System.out.println(authority);

        if(authority.equals("crew")){
            return new LoginResponseDto(authority, token, crewService.getTabNumberByLogin(credentialsDto.getLogin()));
        }else{
            return new LoginResponseDto(authority, token, dispatcherService.getTabNumberByLogin(credentialsDto.getLogin()));
        }
    }

    @PostMapping(value = "/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public CredentialsDto signUp(@RequestBody CredentialsDto credentialsDto) {
        return credentialsService.create(credentialsDto);
    }


    private void authenticate(String username, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException e){
            System.out.println(1);
            throw new Exception("USER_DISABLED", e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS", e);
        }catch (Exception ex){
        }
    }
}