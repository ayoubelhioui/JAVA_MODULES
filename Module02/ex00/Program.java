package ex00;
import java.io.File;
import java.io.FileNotFoundException;
import ex00.FileParser;

class Program {
    public static void main(String[] args) {
        try{
            FileParser fileParser = FileParser.getInstance("/home/ael-hiou/IdeaProjects/JAVA_MODULES/Module02/ex00/signature.txt");
            fileParser.parse();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}