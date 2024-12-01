package page_objects.login;

public interface LoginAgent extends LoginActors{

    @Override
    void navigate();

    @Override
    void login();

    @Override
    void logout();
}
