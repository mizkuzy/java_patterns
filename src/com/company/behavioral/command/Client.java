package com.company.behavioral.command;

public class Client {

    public static void main(String[] args) {

        // create the receiver
        FileSystemReceiver fileSystemReceiver = FileSystemReceiverUtil.getFileSystemReceiver();

        // create the command and associate with the receiver
        OpenFileCommand openFileCommand = new OpenFileCommand(fileSystemReceiver);
        // create the invoker and associate with the command
        FileInvoker openFileInvoker = new FileInvoker(openFileCommand);
        // perform action
        openFileInvoker.execute();

        CloseFileCommand closeFileCommand = new CloseFileCommand(fileSystemReceiver);
        // create the invoker and associate with the command
        FileInvoker closeFileInvoker = new FileInvoker(closeFileCommand);
        // perform action
        closeFileInvoker.execute();

        WriteFileCommand writeFileCommand = new WriteFileCommand(fileSystemReceiver);
        // create the invoker and associate with the command
        FileInvoker writeFileInvoker = new FileInvoker(writeFileCommand);
        // perform action
        writeFileInvoker.execute();
    }
}
