package ru.ivanscm.baseLayout;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import ru.ivanscm.ChatPage;
import ru.ivanscm.HomePage;

/**
 * Created by IvanSCM on 12.12.2016.
 */
public class MenuPanel extends Panel {

    private BookmarkablePageLink homePageLink;
    private BookmarkablePageLink chatPageLink;

    public MenuPanel(String id) {
        super(id);

        homePageLink = new BookmarkablePageLink("homeLink", HomePage.class);

        chatPageLink = new BookmarkablePageLink("chatLink", ChatPage.class);

        add(homePageLink);
        add(chatPageLink);


    }
}
