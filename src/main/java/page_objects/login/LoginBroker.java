package page_objects.login;

public interface LoginBroker extends LoginActors {

    @Override
    void navigate();

    @Override
    void login();

    @Override
    void logout();
}
