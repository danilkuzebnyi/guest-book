package task1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipping {
    List<File> files;

    public void addFilesInDirectoryToList() {
        try (Stream<Path> stream = Files.walk(Paths.get("hw7\\src\\main\\resources"))) {
            files = stream.
                    filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public void doZip() throws IOException {
        try (ZipOutputStream imagesZip = new ZipOutputStream(new FileOutputStream("images.zip"));
             ZipOutputStream audiosZip = new ZipOutputStream(new FileOutputStream("audios.zip"));
             ZipOutputStream videosZip = new ZipOutputStream(new FileOutputStream("videos.zip"))) {
            for (File file : files) {
                if (file.toString().endsWith(".mp3")
                        || file.toString().endsWith(".wav")
                        || file.toString().endsWith(".wma")) {
                    audiosZip.putNextEntry(new ZipEntry(file.getName()));
                    FileInputStream input1 = new FileInputStream(file.getPath());
                    audiosZip.write(input1.readAllBytes());
                    System.out.println("Adding file '" + file.getName() + "' to zip");
                    input1.close();
                } else if (file.toString().endsWith(".mp4")
                        || file.toString().endsWith(".avi")
                        || file.toString().endsWith(".flv")) {
                    videosZip.putNextEntry(new ZipEntry(file.getName()));
                    FileInputStream input2 = new FileInputStream(file.getPath());
                    videosZip.write(input2.readAllBytes());
                    System.out.println("Adding file '" + file.getName() + "' to zip");
                    input2.close();
                } else if (file.toString().endsWith(".png") || file.toString().endsWith(".gif")
                        || file.toString().endsWith(".jpg") || file.toString().endsWith(".jpeg")) {
                    imagesZip.putNextEntry(new ZipEntry(file.getName()));
                    FileInputStream input3 = new FileInputStream(file.getPath());
                    imagesZip.write(input3.readAllBytes());
                    System.out.println("Adding file '" + file.getName() + "' to zip");
                    input3.close();
                }
            }
            imagesZip.closeEntry();
            audiosZip.closeEntry();
            videosZip.closeEntry();
        }
    }

}
