package model.bean;

public interface Authenticable
{
    void login(String name,String password);
    void logout();
    void startSession();
}
