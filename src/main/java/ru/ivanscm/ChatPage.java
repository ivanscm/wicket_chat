package ru.ivanscm;

import org.apache.wicket.Application;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IvanSCM on 12.12.2016.
 */
public class ChatPage extends BasePage {

    private Form chatForm;
    private TextField username;
    private TextArea message;
    private DropDownChoice dropdown;

    @Override
    protected void onConfigure() {
        super.onConfigure();
        AuthenticatedWebApplication app = (AuthenticatedWebApplication) Application.get();
        if(!AuthenticatedWebSession.get().isSignedIn())
            app.restartResponseAtSignInPage();
    }

    public ChatPage() {
        super();
        title.setDefaultModelObject("Chat Page");

        chatForm = new Form("chatForm") {
            @Override
            protected void onSubmit() {
                super.onSubmit();
            }
        };

        List<String> choice = Arrays.asList("test", "test 2");

        username = new TextField("username", Model.of(""));
        message = new TextArea("message", Model.of(""));
        dropdown = new DropDownChoice("dropdown", new Model(), choice);

        chatForm.add(username);
        chatForm.add(message);
        chatForm.add(dropdown);
        add(chatForm);
    }
}
