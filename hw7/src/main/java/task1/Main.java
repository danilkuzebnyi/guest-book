package task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Zipping zipping = new Zipping();
        zipping.addFilesInDirectoryToList();
        zipping.doZip();
    }
}
