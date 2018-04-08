import java.io.*;

public class WorkFile {
    public static void writeToFile(String nameFile, String text){
        try(FileWriter writer = new FileWriter(nameFile, false)){
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static String readFromFile(String nameFile) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader( new FileReader(nameFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        try {
            while( ( line = reader.readLine() ) != null ) {
                stringBuilder.append( line );
                stringBuilder.append( ls );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
