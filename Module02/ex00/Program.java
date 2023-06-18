package ex00;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
///home/ael-hiou/IdeaProjects/JAVA_MODULES/Module02/ex00/signature.txt
import ex00.FileParser;
import ex00.Signatures;
class Program {
    public static void main(String[] args) {
        try{
            FileParser fileParser = FileParser.getInstance("/home/ael-hiou/IdeaProjects/JAVA_MODULES/Module02/ex00/signature.txt");
            Signatures signatures = new Signatures(fileParser.signatures);
            fileParser.readFileAndParse();
            signatures.getSignatures();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}