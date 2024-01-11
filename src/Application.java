import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileNameValidation fileNameValidation = new FileNameValidation();
        Alphabet alphabet = new Alphabet();
        Encryption encryption = new Encryption(alphabet);
        Decryption decryption = new Decryption(alphabet);
        BruteForce bruteForce = new BruteForce(alphabet);
        FilesProcessor filesProcessor = new FilesProcessor();
        System.out.println("""
                Welcome in my Cryptoanalyzer!
                You can choose the operating mode:
                Write 1, if you want to use text encryption
                Write 2, if you want to use text decryption
                Write 3, if you want to use Brute force""");
        int choose = new Scanner(System.in).nextInt();
        switch (choose) {
            case 1 -> {
                System.out.println("You choose text encryption" +
                        "\nWrite the path to read the file: ");
                String filePathRead = scanner.nextLine();
                System.out.println("Write the path to write the file:");
                String filePathWrite = scanner.nextLine();
                System.out.println("Write key:");
                int key = Integer.parseInt(scanner.nextLine());
                fileNameValidation.validateForReading(filePathRead);
                fileNameValidation.validateForWriting(filePathWrite);
                List<String> srcStrings = filesProcessor.readFile(filePathRead);
                for (String srcString : srcStrings) {
                    String encryptLine = encryption.encrypt(srcString, key);
                    filesProcessor.appendToFile(filePathWrite, encryptLine);
                }
                System.out.println("Done!");
            }
            case 2 -> {
                System.out.println("You choose text decryption" +
                        "\nWrite the path to read the file: ");
                String filePathRead = scanner.nextLine();
                System.out.println("Write the path to write the file:");
                String filePathWrite = scanner.nextLine();
                System.out.println("Write key:");
                int key = Integer.parseInt(scanner.nextLine());
                fileNameValidation.validateForReading(filePathRead);
                fileNameValidation.validateForWriting(filePathWrite);
                List<String> srcStrings = filesProcessor.readFile(filePathRead);
                for (String srcString : srcStrings) {
                    String encryptLine = decryption.decrypt(srcString, key);
                    filesProcessor.appendToFile(filePathWrite, encryptLine);
                }
                System.out.println("Done!");
            }
            case 3 -> {
                System.out.println("You choose Brute force" +
                        "\nWrite the path to read the file: ");
                String filePathRead = scanner.nextLine();
                System.out.println("Write the path to write the file:");
                String filePathWrite = scanner.nextLine();
                List<String> srcStrings = filesProcessor.readFile(filePathRead);

                boolean isYes = false;
                String decryptCryptLine = null;
                while (!isYes) {
                    for (int key = 1; key < alphabet.getSize(); key++) {
                        for (String srcString : srcStrings) {
                            decryptCryptLine = bruteForce.bruteForce(srcString, key);
                            System.out.println("It is ok?\nWrite - yes or no!");
                            System.out.println(decryptCryptLine);
                        }
                        String line = scanner.nextLine();
                        if (line.contains("yes")) {
                            break;
                        }
                    }
                    isYes = true;
                    filesProcessor.appendToFile(filePathWrite, decryptCryptLine);
                }
                System.out.println("Done!");

            }
            default -> {
                System.out.println("You choose something wrong!" + "\nTry to run the program again");
            }
        }
    }
}
