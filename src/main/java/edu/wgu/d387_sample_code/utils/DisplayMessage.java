package edu.wgu.d387_sample_code.utils;

import java.util.ResourceBundle;
import java.util.Locale;

public class DisplayMessage {
    private ResourceBundle bundle;

    public DisplayMessage(Locale locale) {
        bundle = ResourceBundle.getBundle("language", locale);
    }

    public String getWelcomeMessage(){
        return bundle.getString("welcome");
    }

}
