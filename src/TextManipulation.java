import java.util.*;
import java.io.*;
public class TextManipulation {
    public String convertToUpperCase(String string){

        return string.toUpperCase();
    }

    public String convertToLowerCase(String string){
        return string.toLowerCase();
    }

    public boolean isAnagram(String a, String b){
        a = a.toLowerCase();
        b = b.toLowerCase();

        int aLength = a.length();
        int bLength = b.length();

        if(aLength != bLength){
            return false;
        }

        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        Arrays.sort(aChar);
        Arrays.sort(bChar);

        for(int i = 0 ; i < aLength ; ++i){
            if(aChar[i] != bChar[i]){
                return false;
            }
        }

        return true;
    }

    public String reverseString(String a){
        char[] aChar = a.toCharArray();
        String reverseText = "";
        for(int i = a.length() - 1 ; i >= 0 ; --i){
            reverseText = reverseText + aChar[i];
        }
        return reverseText;
    }

    public String caesarCipherCode(String input, int cipherShift) {
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";
        String cipherCode = "";

        for (int i = 0; i < input.length(); i++) {

            char charInput = (input.toLowerCase()).charAt(i);

            if (Character.isLetterOrDigit(charInput)) {
                int index = alphabet.indexOf(charInput);
                if (index >= 0) {
                    int newIndex = (index + cipherShift) % alphabet.length();

                    if (newIndex < 0) {
                        newIndex += alphabet.length();
                    }

                    char cipherChar = alphabet.charAt(newIndex);
                    cipherCode += cipherChar;
                } else {
                    cipherCode += charInput;
                }
            } else {
                cipherCode += charInput;
            }
        }

        return cipherCode;
    }

    public String caesarCipherDecode(String input, int cipherShift) {
        return caesarCipherCode(input, -cipherShift);
    }


    public static void main(String[] args){
        TextManipulation textmani = new TextManipulation();
        String a = textmani.caesarCipherCode("zhello",3);
        System.out.println(a);
    }
}
