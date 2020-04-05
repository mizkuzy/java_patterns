package com.company.behavioral.chain_of_responsibility.error_handler;

public class Client {

    private AbstractErrorHandler errorHandler;

    public AbstractErrorHandler getErrorHandler() {
        return errorHandler;
    }

    public Client() {
        AbstractErrorHandler eh1 = new FaxErrorHandler();
        AbstractErrorHandler eh2 = new EmailErrorHandler();

        eh1.setNextErrorHandler(eh2);

        this.errorHandler = eh1;
    }

    public static void main(String[] args) {
        Client issueRaiser = new Client();
        AbstractErrorHandler errorHandler = issueRaiser.getErrorHandler();

        Message m1 = new Message("Fax ist kaput", MessagePriority.HIGH);
        Message m2 = new Message("Email is incorrect", MessagePriority.NORMAL);
        Message m3 = new Message("E-mail is incorrect", MessagePriority.NORMAL); // this was not handled but the program did not broken
        errorHandler.processMessage(m1);
        errorHandler.processMessage(m2);
        errorHandler.processMessage(m3);
    }
}
