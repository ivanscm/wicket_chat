package ru.ivanscm.baseLayout;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import ru.ivanscm.ChatPage;
import ru.ivanscm.HomePage;
import ru.ivanscm.SignInPage;
import ru.ivanscm.authentication.ChatAuthenticationSession;

import org.apache.wicket.markup.html.basic.Label;

/**
 * Created by IvanSCM on 12.12.2016.
 */
public class MenuPanel extends Panel {

    private BookmarkablePageLink homePageLink;
    private BookmarkablePageLink chatPageLink;
    private BookmarkablePageLink logInPageLink;
    private Link logOutLink;
    private Label username;

    private boolean isAuth;

    public MenuPanel(String id) {
        super(id);

        this.isAuth = AuthenticatedWebSession.get().isSignedIn();

        homePageLink = new BookmarkablePageLink("homeLink", HomePage.class);
        chatPageLink = new BookmarkablePageLink("chatLink", ChatPage.class);

        logInPageLink = new BookmarkablePageLink("logInLink", SignInPage.class);
        logOutLink = new Link("logOutLink") {
            @Override
            public void onClick() {
                AuthenticatedWebSession.get().invalidate();
                setResponsePage(getApplication().getHomePage());
            }
        };

        logOutLink.setVisible(this.isAuth);
        logInPageLink.setVisible(!this.isAuth);

        String userName = ((ChatAuthenticationSession)ChatAuthenticationSession.get()).getUsername();

        username = new Label("username", userName);

        add(homePageLink);
        add(chatPageLink);

        add(logInPageLink);
        add(logOutLink);

        add(username);

    }
}
