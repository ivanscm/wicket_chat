package ru.ivanscm.authentication;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

/**
 * Created by IvanSCM on 13.12.2016.
 */
public class ChatAuthenticationSession extends AuthenticatedWebSession {
    public ChatAuthenticationSession(Request request) {
        super(request);
    }

    @Override
    protected boolean authenticate(String username, String password) {
        return username.equals(password);
    }

    @Override
    public Roles getRoles() {
        return null;
    }
}
