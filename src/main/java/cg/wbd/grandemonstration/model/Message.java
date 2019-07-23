package cg.wbd.grandemonstration.model;

public class Message {
    private static Message singleton;

    private Message() {
    }

    public static Message getInstance() {
        if (singleton == null) {
            singleton = new Message();
        }
        return singleton;
    }

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
