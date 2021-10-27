package tonder.service.context;


public interface UserContext {

    void setUsername(String username);

    String getUsername();

    Boolean isAdmin();

    void setIsAdmin(Boolean isAdmin);
}
