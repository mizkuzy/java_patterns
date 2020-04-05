package com.company.behavioral.chain_of_responsibility.error_handler;

public abstract class AbstractErrorHandler {
    private AbstractErrorHandler nextErrorHandler;

    protected String keyWord;

    public void setNextErrorHandler(AbstractErrorHandler nextErrorHandler) {
        this.nextErrorHandler = nextErrorHandler;
    }

    public AbstractErrorHandler getNextErrorHandler() {
        return nextErrorHandler;
    }

    public void processMessage(Message message) {
        if (message.getText().toLowerCase().contains(this.keyWord)) {
            System.out.println(String.format(
                    "%s processed %s issue: %s",
                    this.getClass().getSimpleName(), message.getPriority(), message.getText()));
        } else if (this.getNextErrorHandler() != null) {
            this.getNextErrorHandler().processMessage(message);
        }
    }
}

class EmailErrorHandler extends AbstractErrorHandler {

    public EmailErrorHandler() {
        this.keyWord = "email";
    }
}

class FaxErrorHandler extends AbstractErrorHandler {

    public FaxErrorHandler() {
        this.keyWord = "fax";
    }
}
