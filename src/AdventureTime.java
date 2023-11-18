import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        File file = new File("inputOneTwo.txt");
        File file1 = new File ("inputThreeFour.txt");
        String first = "inputOneTwo.txt";
        String second = "inputThreeFour.txt";
        int one = challengeOne(first);
        int two = challengeTwo(first);
        int three = challengeThree(second);
        int four = challengeFour(second);
        writeFileAllAnswers("result", one, two, three, four);

    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {

        int linesInFile = countLinesInFile("inputOneTwo.txt");
        int[] array = new int[linesInFile];

        int index = 0;

        File file = new File("inputOneTwo.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            array[index++] = scanner.nextInt();

        }
        int greater = 0;
        for (int i = 1; i<array.length; i++){
            if (array[i]>array[i-1]){
                greater ++;
            }

        }
        return greater;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int linesInFile = countLinesInFile(fileName);
        int[] array = new int[linesInFile];
        int count = 0;
        int one = 0;
        int two = 0;

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int index = 0;
        while (scanner.hasNextInt()) {
            array[index] = scanner.nextInt();
            index++;
        }
        scanner.close();

        for (int i = 0; i < array.length - 4; i++) {
            one = array[i] + array[i + 1] + array[i + 2];
            two = array[i + 1] + array[i + 2] + array[i + 3];
            if (two > one) {
                count++;
            }
        }

        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int linesInFile = countLinesInFile(fileName);
        String[] array = new String[linesInFile];

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int index = 0;
        while (scanner.hasNextLine()) {
            array[index] = scanner.nextLine();
            index++;
        }
        scanner.close();
        System.out.println(array);
        int x = 0;
        int y = 0;
        String test = " ";
        int z = 0;

        for (int i =0; i<array.length; i++) {
            if(array[i].length()==9){
                x+= Integer.parseInt(array[i].substring(array[i].length() - 1));

            }
            else if (array[i].length()==6){
                y+= Integer.parseInt(array[i].substring(array[i].length() - 1));
            }
            else{
                y-= Integer.parseInt(array[i].substring(array[i].length() - 1));

            }

        }
        System.out.println(x);
        System.out.println(y);
        return x*y;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int linesInFile = countLinesInFile(filename);
        String[] array = new String[linesInFile];

        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int index = 0;
        while (scanner.hasNextLine()) {
            array[index] = scanner.nextLine();
            index++;
        }
        scanner.close();
        int x = 0;
        int y = 0;
        String test = " ";
        int z = 0;

        for (int i =0; i<array.length; i++) {
            if(array[i].length()==9){
                x+= Integer.parseInt(array[i].substring(array[i].length() - 1));
                y+=y*x;

            }
            else if (array[i].length()==6){
                y+= Integer.parseInt(array[i].substring(array[i].length() - 1));
            }
            else{
                y-= Integer.parseInt(array[i].substring(array[i].length() - 1));

            }

        }
        System.out.println(x);
        System.out.println(y);
        return x*y;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}