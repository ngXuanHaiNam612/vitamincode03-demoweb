package com.vitamincode03.demoweb.service;

import com.vitamincode03.demoweb.dto.request.AuthenticationDtoRequest;
import com.vitamincode03.demoweb.dto.response.AuthenticationDtoResponse;

public interface AuthenticationService {

    AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request);
}
