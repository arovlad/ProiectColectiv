package ro.ubb.dtos;

import ro.ubb.models.LogInResponse;
import ro.ubb.models.RegisterResponse;

public class IntegerResponseDto {
    LogInResponse response;
    RegisterResponse registerResponse;

    public RegisterResponse getRegisterResponse() {
        return registerResponse;
    }

    public void setRegisterResponse(RegisterResponse registerResponse) {
        this.registerResponse = registerResponse;
    }

    public LogInResponse getResponse() {
        return response;
    }

    public void setResponse(LogInResponse response) {
        this.response = response;
    }
}
