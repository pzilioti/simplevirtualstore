package dev.zilioti.virtualstore.response;

public class GenericResponse {

    private String status;
    private String message;

    public GenericResponse(){
        this.status = "Generic Status";
        this.message = "Generic Message";
    }
    public GenericResponse(String status, String message){
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
