package ru.ivanscm;

import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import ru.ivanscm.baseLayout.MenuPanel;

/**
 * Created by IvanSCM on 12.12.2016.
 */
public class BasePage extends WebPage {

    private static final ResourceReference CSS = new CssResourceReference(BasePage.class, "style.css");

    private Component menuPanel;
    public Label title;


    public BasePage() {
        menuPanel = new MenuPanel("menuPanel");
        title = new Label("title", "Chat application");
        add(menuPanel);
        add(title);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(CSS));
    }
}
