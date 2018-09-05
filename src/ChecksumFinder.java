import java.io.*;

public class ChecksumFinder {

    public static int numbers[][] = new int[16][16];

    public static void main (String args[]) throws IOException {
        lesen();
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                System.out.print(numbers[i][j] + "  \t");
            }
            System.out.println();
        }
        int output = checksumFinder();
        System.out.println(output);


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
        //return (Integer[])zahlen.toArray(new Integer[zahlen.size]);
    }

    private static int checksumFinder() {
        int biggest, smallest;
        int[] difference = new int[16];
        for (int i = 0; i < 16; i++) {
            biggest = numbers[i][0];
            smallest = biggest;
            for (int j = 1; j < 16; j++) {
                if (numbers[i][j] < smallest) {
                    smallest = numbers[i][j];
                }
                if (numbers[i][j] > biggest) {
                    biggest = numbers[i][j];
                }
            }
            difference[i] = biggest - smallest;
            System.out.println(difference[i]);

        }
        int checksum = 0;
        for (int i = 0; i < 16; i++) {
            checksum += difference[i];
        }
        return checksum;
    }
}
