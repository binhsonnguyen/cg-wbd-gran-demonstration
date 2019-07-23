package cg.wbd.grandemonstration.model;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class Message {
    private static Message defaultMessage;
    private static Map<Locale, Message> messages;

    static {
        messages = new HashMap<>();
        defaultMessage = new EnglishMessage();
        messages.put(Locale.ENGLISH, defaultMessage);
        messages.put(Locale.FRENCH, new FrenchMessage());
    }

    public static Message getInstance(Locale locale) {
        Message instance = messages.get(locale);
        return instance == null ? defaultMessage : instance;
    }

    public abstract String getCustomerName();

    public abstract String getCustomerEmail();

    public abstract String getCustomerAddress();

    public abstract String getCustomerFields();

    public abstract String getCustomerGlobal();

    static private class EnglishMessage extends Message {
        public String getCustomerName() {
            return "Name must not be empty, max 128 characters";
        }

        public String getCustomerEmail() {
            return "Email must not be empty, right syntax, max 128 characters";
        }

        public String getCustomerAddress() {
            return "Address must be max 256 characters";
        }

        public String getCustomerFields() {
            return "There are field error(s)";
        }

        public String getCustomerGlobal() {
            return "Email exists";
        }
    }

    static private class FrenchMessage extends Message {
        public String getCustomerName() {
            return "(In french) Name must not be empty, max 128 characters";
        }

        public String getCustomerEmail() {
            return "(In french) Email must not be empty, right syntax, max 128 characters";
        }

        public String getCustomerAddress() {
            return "(In french) Address must be max 256 characters";
        }

        public String getCustomerFields() {
            return "(In french) There are field error(s)";
        }

        public String getCustomerGlobal() {
            return "(In french) Email exists";
        }
    }
}
