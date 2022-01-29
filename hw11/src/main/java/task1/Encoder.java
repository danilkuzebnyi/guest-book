package task1;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoder {

    public void calculateMd5Hash() {
        String sourceFile = "hw11/src/main/resources/links.txt";
        String destinationFile = "hw11/src/main/resources/hashes_sum.txt";
        try (var reader = new BufferedReader(new FileReader(sourceFile));
             var writer = new BufferedWriter(new FileWriter(destinationFile))) {
            String link;
            MessageDigest digest = MessageDigest.getInstance("MD5");
            while ((link = reader.readLine()) != null) {
                digest.update(link.getBytes());
                byte[] hash = digest.digest();
                String linksAndTheirHashes = link + " = " + bytesToHex(hash);
                writer.write(linksAndTheirHashes + "\n");
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
    }

    private String bytesToHex(byte[] bytes) {
        var builder = new StringBuilder();
        for (var b : bytes) {
            builder.append(String.format("%02x", b & 0xff));
        }
        return builder.toString();
    }
}
