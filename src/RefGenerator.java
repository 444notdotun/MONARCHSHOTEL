import java.security.SecureRandom;

public class RefGenerator {


        char []UPPERCASE_LETTERS = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char [] LOWER_CASE={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        SecureRandom randomNumber=new SecureRandom();
        char newWord;
        String new_word_formed;
        int count = 0;

        public  String script(String words) {
            for (int i = 0; i < words.length(); i++) {
                char word = words.charAt(count);
                if (word == 'A') {
                    newWord = UPPERCASE_LETTERS[randomNumber.nextInt(UPPERCASE_LETTERS.length)];
                } else if (word == '@') {
                    newWord = LOWER_CASE[randomNumber.nextInt(LOWER_CASE.length)];
                } else if (word == '#') {
                    newWord = (char) randomNumber.nextInt(10);
                } else if (word == '-') {
                    newWord = '-';
                }
                new_word_formed += newWord;
                count++;
            }

            return new_word_formed;
        }

    }


