import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        StringBuffer result = new StringBuffer(""); // to store the final result
        char[] alphabets = new char[26]; // capacity is 26, since there are 26 alphabets
        
        // populating the array with alphabets
        for (int i = 0; i < 26; i++) {
            alphabets[i] = (char) ('a' + i);
        }
        try {
            boolean attempt = true;
            while (attempt) {
                System.out.print("Type \"encrypt\" for encryption process and \"decrypt\" for decryption process: ");
                String process = sc.nextLine().toLowerCase();
                if (process.equals("encrypt")) {
                    System.out.print("Enter the word to be encrypted: ");
                    String word = sc.nextLine().toLowerCase();
                    System.out.print("Enter the shift value: ");
                    int shift = sc.nextInt();
                    sc.nextLine(); // consume the newline
                    for (int i = 0; i < word.length(); i++) {
                        char ch = word.charAt(i);
                        if (Character.isLetter(ch)) {
                            for (int j = 0; j < alphabets.length; j++) {
                                if (word.charAt(i) == alphabets[j]) {
                                    int x = j;
                                    int encrypted_idx = (x + shift) % 26;
                                    result.append(alphabets[encrypted_idx]);
                                }
                            }
                        } else {
                            result.append(ch); // Preserve spaces and special characters
                        }
                    }
                    System.out.println("Encrypted word: " + result.toString());
                    result.setLength(0);

                } else if (process.equals("decrypt")) {
                    System.out.print("Enter the word to be decrypted: ");
                    String word = sc.nextLine().toLowerCase();
                    System.out.print("Enter the shift value: ");
                    int shift = sc.nextInt();
                    sc.nextLine(); // consume the newline
                    for (int i = 0; i < word.length(); i++) {
                        char ch = word.charAt(i);
                        if (Character.isLetter(ch)) {
                            for (int j = 0; j < alphabets.length; j++) {
                                if (word.charAt(i) == alphabets[j]) {
                                    int x = j;
                                    int decrypted_idx = (x - shift + 26) % 26; //adding 26 to shift to handle negative indexes
                                    result.append(alphabets[decrypted_idx]);
                                }
                            }
                        } else {
                            result.append(ch); // Preserve spaces and special characters
                        }
                    }
                    System.out.println("Decrypted word: " + result.toString());
                    result.setLength(0);
                }
                System.out.println();
                System.out.print("Type \"y\" to do again and \"n\": ");
                String choice = sc.nextLine();
                if (choice.equals("n")) {
                    attempt = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
