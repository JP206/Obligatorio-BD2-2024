package com.bd2.api.repositories;

import com.bd2.api.dto.LoginResponseDTO;

public interface ILoginRepository {

    public LoginResponseDTO login(String correo, String contrasenia);
}
