package model.bean;

public class Session
{
    private int id;
    private User user;
    private boolean logged;
    private boolean keepLogin;

    public Session(User user, boolean keepLogin)
    {
        this.user = user;
        this.logged = true;
        this.keepLogin = keepLogin;
    }

    public void destroy()
    {
        this.logged = false;
    }
}
