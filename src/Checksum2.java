import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Checksum2 {

    public static int numbers[][] = new int[16][16];

    public static void main (String... args) throws IOException {
        lesen();
        int checksum = newChecksum();
        System.out.println(checksum);


    }

    private static void lesen() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/InputNumbers.txt")));
        String line = null;
        int lineNumber = 0;
        while((line = reader.readLine()) != null){
            String[] splitted = line.split("\t");
            for (int i = 0; i < splitted.length; i++) {
                numbers[lineNumber][i] = Integer.parseInt(splitted[i]);

            }
            lineNumber++;

        }
    }

    private static int newChecksum() {
        int checksum = 0;
        int num1;
        int num2;

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                num1 = numbers[i][j];
                for (int k = j + 1; k < 16; k++) {
                    num2 = numbers[i][k];
                    if (num1 > num2) {
                        if (num1 % num2 == 0) {
                            checksum += num1 / num2;
                            break;
                        }
                    } else {
                        if (num2 % num1 == 0) {
                            checksum += num2 / num1;
                            break;
                        }
                    }


                }
            }
            num1 = 0;
            num2 = 0;
        }

        return checksum;
    }
}
