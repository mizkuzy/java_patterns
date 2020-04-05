package com.company.behavioral.command;

public class FileSystemReceiverUtil {

    public static FileSystemReceiver getFileSystemReceiver() {
        String osName = System.getProperty("os.name");

        System.out.println("Used OS: " + osName);

        if (osName.contains("Windows")) {
            return new WindowsFileSystemReceiver();
        } else {
            return new UnixFileSystemReceiver();
        }
    }
}
