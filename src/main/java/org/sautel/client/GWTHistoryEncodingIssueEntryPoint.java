package org.sautel.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.RootPanel;

public class GWTHistoryEncodingIssueEntryPoint implements EntryPoint {
  private static final String EXPECTED_TOKEN = "%3A%40";

  public void onModuleLoad() {
    Anchor anchor = new Anchor("Click me to change hash");
    anchor.setHref("#%253A%40");
    anchor.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        // Delaying to let history detect hash change
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
          public void execute() {
            String token = History.getToken();
            if (!EXPECTED_TOKEN.equals(token)) {
              Window.alert("Token is " + token + " and should be " + EXPECTED_TOKEN);
            } else {
              Window.alert("The token is right. Try with Firefox");
            }
          }
        });
      }
    });
    RootPanel.get().add(anchor);
  }
}
