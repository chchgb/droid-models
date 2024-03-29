package com.nofatclips.androidtesting.guitree;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.nofatclips.androidtesting.model.WidgetState;
import com.nofatclips.androidtesting.xml.ElementWrapper;
import com.nofatclips.androidtesting.xml.XmlGraph;

public abstract class TestCaseInteraction  extends ElementWrapper {
	
	public TestCaseInteraction () {
		super();
	}
	
	public TestCaseInteraction (Element e) {
		super (e);
	}
	
	public TestCaseInteraction (XmlGraph g, String tag) {
		super (g, tag);
	}

	public TestCaseInteraction (Document d, String tag) {
		super (d, tag);
	}

	public WidgetState getWidget() {
		return new TestCaseWidget ((Element)getElement().getChildNodes().item(0));
	}

	public void setWidget(WidgetState newChild) {
		Element oldChild = getWidget().getElement();
		if (oldChild != null)
			getElement().removeChild(oldChild);
		getElement().appendChild(newChild.getElement());
	}

	public String getWidgetName() {
		return getWidget().getName();
	}

	public void setWidgetName(String n) {
		getWidget().setName(n);
	}

	public String getWidgetType() {
		return getWidget().getType();
	}

	public void setWidgetType(String t) {
		getWidget().setType(t);
	}

	public String getWidgetId() {
		return getWidget().getId();
	}

	public void setWidgetId(String id) {
		getWidget().setId(id);
	}

}
