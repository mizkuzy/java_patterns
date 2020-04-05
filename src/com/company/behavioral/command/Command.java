package com.company.behavioral.command;

public interface Command {

    void execute();
}

class OpenFileCommand implements Command {

    private FileSystemReceiver fileSystem;

    public OpenFileCommand(FileSystemReceiver fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute() {
        // save previous state in case undo is implemented
        this.fileSystem.openFile();
    }
}

class CloseFileCommand implements Command {

    private FileSystemReceiver fileSystem;

    public CloseFileCommand(FileSystemReceiver fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute() {
        // save previous state in case undo is implemented
        this.fileSystem.closeFile();
    }
}

class WriteFileCommand implements Command {

    private FileSystemReceiver fileSystem;

    public WriteFileCommand(FileSystemReceiver fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute() {
        // save previous state in case undo is implemented
        this.fileSystem.writeFile();
    }
}

class UndoFileOperationCommand implements Command {

    // restore previous state
    @Override
    public void execute() {

    }
}
