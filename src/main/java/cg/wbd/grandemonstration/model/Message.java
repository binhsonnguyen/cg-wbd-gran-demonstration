package cg.wbd.grandemonstration.model;

import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class Message {
    private Locale locale;

    public Message(Locale locale) {
        this.locale = locale;
    }

    public String getMessage(String code) {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("message");
        return messageSource.getMessage(code, null, locale);
    }
}
