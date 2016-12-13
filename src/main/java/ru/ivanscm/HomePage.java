package ru.ivanscm;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends BasePage {
	private static final long serialVersionUID = 1L;

	public HomePage(){
		super();
		add(new Label("helloMessage", "Привет викет"));
	}
}
