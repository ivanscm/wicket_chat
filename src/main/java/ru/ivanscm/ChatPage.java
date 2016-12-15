package ru.ivanscm;

import org.apache.wicket.Application;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import ru.ivanscm.authentication.ChatAuthenticationSession;
import ru.ivanscm.models.ChatMessage;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by IvanSCM on 12.12.2016.
 */
public class ChatPage extends BasePage {

    private Form chatForm;
    private TextField message;

    public static final List<ChatMessage> messages = new ArrayList<ChatMessage>();

    private ListView<ChatMessage> chatMessages;


    @Override
    protected void onConfigure() {
        super.onConfigure();
        AuthenticatedWebApplication app = (AuthenticatedWebApplication) Application.get();
        if (!AuthenticatedWebSession.get().isSignedIn())
            app.restartResponseAtSignInPage();
    }

    public ChatPage() {
        super();
        title.setDefaultModelObject("Chat Page");

        /*java.util.Collections.addAll(messages,
                new ChatMessage("ivan", new Date(), "Привет мир!"),
                new ChatMessage("vasya", new Date(), "Привет Wicket!"),
                new ChatMessage("nikolas", new Date(), "Как дела, ребята?")
        );*/

        chatForm = new Form("chatForm") {
            @Override
            protected void onSubmit() {
                super.onSubmit();

                String userName = ((ChatAuthenticationSession) ChatAuthenticationSession.get()).getUsername();

                messages.add(new ChatMessage(userName, new Date(), message.getValue()));
            }
        };

        chatMessages = new ListView<ChatMessage>("messages", messages) {
            @Override
            protected void populateItem(ListItem<ChatMessage> listItem) {
                listItem.add(new Label("messageUsername", new PropertyModel(listItem.getModel(), "username")));
                listItem.add(new Label("messageText", new PropertyModel(listItem.getModel(), "message")));
                listItem.add(new Label("messageDateTime", new PropertyModel(listItem.getModel(), "printableDate")));
            }
        };

        message = new TextField("message", Model.of(""));

        chatForm.add(message);
        add(chatForm);
        add(chatMessages);
    }
}
