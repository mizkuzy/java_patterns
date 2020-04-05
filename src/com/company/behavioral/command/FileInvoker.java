package com.company.behavioral.command;

public class FileInvoker {
    public Command command;

    public FileInvoker(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }
}
