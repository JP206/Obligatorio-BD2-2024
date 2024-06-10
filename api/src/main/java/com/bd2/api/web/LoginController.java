package com.bd2.api.web;

import com.bd2.api.dto.LoginDTO;
import com.bd2.api.repositories.ILoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
class LoginController {
    
    private final ILoginRepository loginRepository;
    
    @Autowired 
    public LoginController(final ILoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    
    @GetMapping()
    public boolean login(@RequestBody LoginDTO loginDTO) {
        return loginRepository.login(loginDTO.getCorreo(), loginDTO.getContrasenia());
    }
}