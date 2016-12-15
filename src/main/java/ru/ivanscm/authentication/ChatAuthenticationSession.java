package ru.ivanscm.authentication;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

/**
 * Created by IvanSCM on 13.12.2016.
 */
public class ChatAuthenticationSession extends AuthenticatedWebSession {

    private String username;
    private boolean isAuth;

    public ChatAuthenticationSession(Request request) {
        super(request);
        this.isAuth = false;
    }

    @Override
    protected boolean authenticate(String username, String password) {
        this.isAuth = username.equals(password);

        if (this.isAuth) {
            this.username = username;
        }

        return this.isAuth;
    }

    @Override
    public Roles getRoles() {
        return null;
    }

    @Override
    public void signOut(){
        super.signOut();
        username = null;
    }

    public String getUsername() {
        if (this.isAuth) {
            return this.username;
        }
        return "Guest";
    }
}
