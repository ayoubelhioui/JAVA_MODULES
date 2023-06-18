package ex00;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.IOException;
class FileParser{

    public static Map<String, String> signatures;
    private static InputStream inputStream;
    private static String filePath;
    private static FileParser instance;

    private FileParser() {}
    private FileParser(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        this.signatures = new HashMap<>(10);
        this.inputStream = new FileInputStream(filePath);
    }

    public static FileParser getInstance(String filePath) throws FileNotFoundException {
        if (instance == null)
            return (new FileParser(filePath));
        return (instance);
    }

    public void readFileAndParse() throws IOException {
        int i = 0;
        while (true) {
            byte[] extensionBytes = new byte[3];
            inputStream.read(extensionBytes);
            String extension = new String(extensionBytes);
            inputStream.skip(2);
            String sign = new String();
            byte[] signPart = new byte[3];
            i = inputStream.read(signPart);
            while (i != -1 && (char) signPart[2] != '\n') {
                String savior = new String(signPart);
                sign += savior;
                i = inputStream.read(signPart);
            }
            String savior = new String(signPart);
            sign += savior;
            String signature = new String(sign).replaceAll("\n", "");
            signatures.put(extension, signature);
            if (i == -1)
                break ;
        }
//        Iterator<Map.Entry<String, String>> iterator = signatures.entrySet().iterator();
//        while (iterator.hasNext())
//        {
//            Map.Entry<String, String> entry = iterator.next();
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
    }

    protected void finalize() throws Throwable {
        inputStream.close();
    }
}