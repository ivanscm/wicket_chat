package ru.ivanscm;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

import java.lang.reflect.Method;

/**
 * Created by IvanSCM on 12.12.2016.
 */
public class ChatPage extends BasePage {

    private Form chatForm;
    private TextField username;
    private TextArea message;

    public ChatPage() {
        super();
        title.setDefaultModelObject("Chat Page");

        chatForm = new Form("chatForm") {
            @Override
            protected void onSubmit() {
                super.onSubmit();
            }
        };

        username = new TextField("username", Model.of(""));
        message = new TextArea("message", Model.of(""));

        chatForm.add(username);
        chatForm.add(message);
        add(chatForm);
    }
}
