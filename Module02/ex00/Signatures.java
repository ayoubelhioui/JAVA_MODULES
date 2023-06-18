package ex00;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

class Signatures {
        private Scanner standardInputScanner;
        private InputStream inputFile;
        private Map<String, String> signatures;

        private Signatures() {}
        public Signatures(Map<String, String> signatures) {
            this.signatures = signatures;
            this.standardInputScanner = new Scanner(System.in);
        }

        private void readFromStandardInput() throws FileNotFoundException, IOException {
            System.out.print("->");
            String filePath;
            filePath = this.standardInputScanner.next();
            while (!filePath.equals("42"))
            {
                this.extractSignature(filePath);
                filePath = this.standardInputScanner.next();
            }
        }

        private void extractSignature(String filePath) throws FileNotFoundException, IOException {
            this.inputFile = new FileInputStream(filePath);
            byte[] signature = new byte[4];
            inputFile.read(signature);
            StringBuilder signatures = new StringBuilder();
            for (byte bomByte : signature) {
                signatures.append(String.format("%02X", bomByte));
            }
            System.out.println("Signature: " + signature);
            this.inputFile.close();
        }

        public void getSignatures() throws FileNotFoundException, IOException{
            this.readFromStandardInput();
        }
}