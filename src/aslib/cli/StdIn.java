package aslib.cli;

import java.util.Scanner;

/**
 * <p> Contains the functions responsible for capturing certain data type from
 * the command line. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.1
 */
public class StdIn {

    /**
     * <p> Make sure to return a value of boolean type. </p>
     *
     * @return A boolean value.
     */
    public static boolean getBoolean() {
        Scanner scanner = getScanner();

        if (!scanner.hasNextBoolean())
            return getBoolean();

        return scanner.nextBoolean();
    }

    /**
     * <p> Make sure to return a value of boolean type. </p>
     *
     * @param prompt Message that will be displayed.
     * @return A boolean value.
     */
    public static boolean getBoolean(String prompt) {
        Scanner scanner = getScanner();

        System.out.print(prompt);
        if (!scanner.hasNextBoolean())
            return getBoolean(prompt);

        return scanner.nextBoolean();
    }

    /**
     * <p> Make sure to return a value of byte type. </p>
     *
     * @return A byte value.
     */
    public static byte getByte() {
        Scanner scanner = getScanner();

        if (!scanner.hasNextByte())
            return getByte();

        return scanner.nextByte();
    }

    /**
     * <p> Make sure to return a value of byte type. </p>
     *
     * @param prompt Message that will be displayed.
     * @return A byte value.
     */
    public static byte getByte(String prompt) {
        Scanner scanner = getScanner();

        System.out.print(prompt);
        if (!scanner.hasNextByte())
            return getByte(prompt);

        return scanner.nextByte();
    }

    /**
     * <p> Make sure to return a value of char type. </p>
     *
     * @return A char value.
     */
    public static char getChar() {
        Scanner scanner = getScanner();

        if (!scanner.hasNext())
            return getChar();

        return scanner.next().charAt(0);
    }

    /**
     * <p> Make sure to return a value of char type. </p>
     *
     * @param prompt Message that will be displayed.
     * @return A char value.
     */
    public static char getChar(String prompt) {
        Scanner scanner = getScanner();

        System.out.print(prompt);
        if (!scanner.hasNext())
            return getChar(prompt);

        return scanner.next().charAt(0);
    }

    /**
     * <p> Make sure to return a value of double type. </p>
     *
     * @return A double value.
     */
    public static double getDouble() {
        Scanner scanner = getScanner();

        if (!scanner.hasNextDouble())
            return getDouble();

        return scanner.nextDouble();
    }

    /**
     * <p> Make sure to return a value of double type. </p>
     *
     * @param prompt Message that will be displayed.
     * @return A double value.
     */
    public static double getDouble(String prompt) {
        Scanner scanner = getScanner();

        System.out.print(prompt);
        if (!scanner.hasNextDouble())
            return getDouble(prompt);

        return scanner.nextDouble();
    }

    /**
     * <p> Make sure to return a value of float type. </p>
     *
     * @return A float value.
     */
    public static float getFloat() {
        Scanner scanner = getScanner();

        if (!scanner.hasNextFloat())
            return getFloat();

        return scanner.nextFloat();
    }

    /**
     * <p> Make sure to return a value of float type. </p>
     *
     * @param prompt Message that will be displayed.
     * @return A float value.
     */
    public static float getFloat(String prompt) {
        Scanner scanner = getScanner();

        System.out.print(prompt);
        if (!scanner.hasNextFloat())
            return getFloat(prompt);

        return scanner.nextFloat();
    }

    /**
     * <p> Make sure to return a value of int type. </p>
     *
     * @return An int value.
     */
    public static int getInt() {
        Scanner scanner = getScanner();

        if (!scanner.hasNextInt())
            return getInt();

        return scanner.nextInt();
    }

    /**
     * <p> Make sure to return a value of int type. </p>
     *
     * @param prompt Message that will be displayed.
     * @return An int value.
     */
    public static int getInt(String prompt) {
        Scanner scanner = getScanner();

        System.out.print(prompt);
        if (!scanner.hasNextInt())
            return getInt(prompt);

        return scanner.nextInt();
    }

    /**
     * <p> Make sure to return a value of long type. </p>
     *
     * @return A long value.
     */
    public static long getLong() {
        Scanner scanner = getScanner();

        if (!scanner.hasNextLong())
            return getLong();

        return scanner.nextLong();
    }

    /**
     * <p> Make sure to return a value of long type. </p>
     *
     * @param prompt Message that will be displayed.
     * @return A long value.
     */
    public static long getLong(String prompt) {
        Scanner scanner = getScanner();

        System.out.print(prompt);
        if (!scanner.hasNextLong())
            return getLong(prompt);

        return scanner.nextLong();
    }

    /**
     * <p> Make sure to return a value of string type. </p>
     *
     * @return A string value.
     */
    public static String getString() {
        return getScanner().nextLine();
    }

    /**
     * <p> Make sure to return a value of string type. </p>
     *
     * @param prompt Message that will be displayed.
     * @return A string value.
     */
    public static String getString(String prompt) {
        System.out.print(prompt);
        return getScanner().nextLine();
    }

    /**
     * <p> Creates a read to use {@link Scanner} instance. </p>
     *
     * @return An instance of {@link Scanner} class.
     */
    private static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
