package cn.com.ssm.exception;

public class CustomerException extends Exception {

    private String massage;

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public CustomerException(String massage){
        this.massage = massage;
    }
}
