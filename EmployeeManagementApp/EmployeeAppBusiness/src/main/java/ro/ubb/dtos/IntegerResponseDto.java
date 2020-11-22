package ro.ubb.dtos;

import ro.ubb.models.LogInResponse;

public class IntegerResponseDto {
    LogInResponse response;

    public LogInResponse getResponse() {
        return response;
    }

    public void setResponse(LogInResponse response) {
        this.response = response;
    }
}
