package ru.ivanscm;


import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import ru.ivanscm.authentication.ChatAuthenticationSession;


/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 *
 * @see ru.ivanscm.Start#main(String[])
 */
public class WicketApplication extends AuthenticatedWebApplication {
    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();

        mountPage("/chat", ChatPage.class);
        mountPage("/sign/in", SignInPage.class);

        // add your configuration here
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return ChatAuthenticationSession.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return SignInPage.class;
    }
}
