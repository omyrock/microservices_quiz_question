package com.QuestionService.Error;



import java.util.List;

public class ErrorResponse {
   private String message;
   private List<String> listOfError;

    public String getMessage() {
        return message;
    }

    public List<String> getListOfError() {
        return listOfError;
    }

    public ErrorResponse(String message, List<String> listOfError) {
        this.message = message;
        this.listOfError = listOfError;
    }
}
