import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([@|#]{1})([A-Za-z]{3,})(\\1)(\\1)([A-Za-z]{3,})(\\1)");
        String text = scan.nextLine();
        Matcher matcher = pattern.matcher(text);

        List< String > words = new ArrayList<>();
        int wordCnt = 0;
        int mirrorWordsCnt = 0;
        while (matcher.find()){
            String firstWord = matcher.group(2);
            String secondWord = matcher.group(5);
            String reversedSecondWord = "";



            for (int i = secondWord.length()-1; i >= 0 ; i--) {
                char symbol = secondWord.charAt(i);
                reversedSecondWord += symbol;


            }
            if (firstWord.equals(reversedSecondWord)){
                words.add(String.format("%s <=> %s",firstWord,secondWord));
                mirrorWordsCnt++;

            }








            wordCnt++;
        }if (wordCnt ==0){
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");

        }else {
            System.out.println(String.format("%d word pairs found!",wordCnt));
            if (mirrorWordsCnt ==0){
                System.out.println("No mirror words!");
            }else {
                System.out.println("The mirror words are:");


                System.out.println(String.join(", ",words));

            }
        }
    }
}
