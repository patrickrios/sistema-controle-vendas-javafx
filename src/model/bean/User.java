package model.bean;

public class User implements Authenticable
{
    private int id;
    private String name;
    private String username;
    private String email;
    private String password;

    @Override
    public void login(String username, String password) {


    }


    @Override
    public void logout() {

    }

    @Override
    public void startSession() {

    }
}
