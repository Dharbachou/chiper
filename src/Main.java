import java.util.ArrayList;
import java.util.List;

public class Main {

    private final static String pathDirectory = "location fold with files";
    private final static String nameFileWithCode = "Code.txt";
    private final static String nameFileWithKey = "Key.txt";
    private final static String nameFileWithText = "Text.txt";
    private final static String regexForText = "[^A-Z]";
    private final static String regexForKey = "[^0-9 ]";


    public static void main(String[] args) {
        String s = new String(encrypt());
        System.out.println(s);
        WorkFile.writeToFile(pathDirectory+nameFileWithCode, s);
        String s1 = new String(decrypt());
        System.out.println(s1);
    }

    private static char[] encrypt(){
        String s = WorkFile.readFromFile(pathDirectory+nameFileWithText).toUpperCase().replaceAll(regexForText, "");
        String str = WorkFile.readFromFile(pathDirectory+nameFileWithKey).replaceAll(regexForKey, "");
        List<Integer> key = parse(str);
        char[] temp = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            temp[i] = (char) (65 + key.get(replace(s.charAt(i))));
        }
        return temp;
    }

    private static char[] decrypt(){
        String s = WorkFile.readFromFile(pathDirectory+nameFileWithCode).toUpperCase().replaceAll(regexForText, "");
        String str = WorkFile.readFromFile(pathDirectory+nameFileWithKey).replaceAll(regexForKey, "");
        List<Integer> key = parse(str);
        List<Integer> list = new ArrayList<>();
        char[] temp = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            temp[i] = (char) (65 + key.indexOf(replace(s.charAt(i))));
        }
        return temp;
    }

    private static List<Integer> parse(String s){
        String strArr[] = s.split(" ");
        List<Integer> numArr = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            numArr.add(Integer.parseInt(strArr[i]));
        }
        return numArr;
    }

    private static int replace(int num){
        int a = 12;
        return num - 65;
    }
}
