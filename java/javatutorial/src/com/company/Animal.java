package com.company;
import java.util.Scanner;
import java.util.*;

public class Animal {
    /* DATATYPE */
    // static: number shared by all objects of type Animal
    // final: value can't be changed
    public static final double FAVNUMBER=1.618;

    // Variables (Fields) start with a letter, underscore or $
    // Private fields can only be accessed by other methods in the class

    private String name;

    // An integer can hold values from -2 ^ 31 to (2 ^ 31) -1
    private int weight;

    // Booleans have a value of true or false
    private boolean hasOwner=false;

    // Bytes can hold the values between -128 to 127
    private byte age;

    // Longs can hold the values between -2 ^ 63 to (2 ^ 63) - 1
    private long uniqueID;

    // Chars are unsigned ints that represent UTF-16 codes from 0 to 65,535
    private char favoriteChar;

    // Doubles are 64 bit IEEE 754 floating points with decimal values
    private double speed;

    // Floats are 32 bit IEEE 754 floating points with decimal values
    private float height;

    // Static variables have the same value for every object
    // Any variable or function that doesn't make sense for an object to have should be made static
    // protected means that this value can only be accessed by other code in the same package
    // or by subclasses in other packages
    protected static int numberOfAnimals=0;

    // A Scanner object allows you to except user input from the keyboard
    static Scanner userInput = new Scanner(System.in);


    // Any time an Animal object is created this function called the constructor is called
    // to initialize the object
    public Animal() {
        // shorthand for numberOfAnimals = numberOfAnimals + 1
        numberOfAnimals++;

        int sumOfNumbers = 5 + 1;
        System.out.println("5 + 1 = "+ sumOfNumbers);

        int diffOfNumbers = 5 - 1;
        System.out.println("5 - 1 = "+ diffOfNumbers);

        int multOfNumbers = 5 * 1;
        System.out.println("5 * 1 = " + multOfNumbers);

        int divOfNumbers = 5 / 1;
        System.out.println("5 / 1 = " + divOfNumbers);

        int modOfNumbers = 5 % 3;
        System.out.println("5 % 3 = " + modOfNumbers);

        // print is used to print to the screen, but it doesn't end with a newline \n
        System.out.print("Enter the name: \n");

        // hasNextInt, hasNextFloat, hasNextDouble, hasNextBoolean, hasNextByte
        // nextInt , nextFloat, nextDouble
        if(userInput.hasNextLine()) {
            // this refers to the object itself
            this.setName(userInput.nextLine());
        }

        this.setFavoriteChar();
        this.setUniqueID();
    }

    /* USE GETTER AND SETTER METHODS TO PROTECT YOUR DATA */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public long getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(long uniqueID) {
        this.uniqueID = uniqueID;
        System.out.println("Unique ID set to: " + this.uniqueID);
    }

    // Method overloading allows you to accept different input with same method name
    public void setUniqueID() {
        long minNumber = 1;
        long maxNumber = 1000000;

        // You can cast from 1 primitive value into another using (datatype)
        // (byte) (short) (long) (double)
        // (float) (boolean) & (char) don't work
        // (char) stays as a number instead of a character
        this.uniqueID = minNumber + (long) (Math.random() * ((maxNumber - minNumber) + 1));

        // Byte.toString(bigByte); Short.toString(bigShort); Integer.toString(bigInt)
        // Float.toString(bigFloat); Double.toString(bigDouble); Boolean.toString(trueOrFalse);
        String stringNumber = Long.toString(maxNumber);

        int numberString = Integer.parseInt(stringNumber);

        System.out.println("Unique ID set to: " + this.uniqueID);
    }

    public char getFavoriteChar() {
        return favoriteChar;
    }

    public void setFavoriteChar(char favoriteChar) {
        this.favoriteChar = favoriteChar;
    }

    public void setFavoriteChar() {
        int randomNumber = (int) (Math.random() * 126) + 1;

        this.favoriteChar = (char) randomNumber;

        /*
        LOGICAL OPERATOR
            ^ : returns True if there is 1 True and 1 False boolean value
        */

        if(randomNumber == 32) {
            System.out.println("Favorite character set to: Space");
        } else if(randomNumber == 10) {
            System.out.println("Favorite character set to: Newline");
        } else {
            System.out.println("Favorite character set to: " + this.favoriteChar);
        }

        if((randomNumber > 97) && (randomNumber < 122)) {
            System.out.println("Favorite character is a lowercase letter");
        }
        if(((randomNumber > 97) && (randomNumber < 122)) || ((randomNumber > 64) && (randomNumber < 91))) {
            System.out.println("Favorite character is a letter");
        }

        // ternary operator
        int whichIsBigger = (50 > randomNumber) ? 50 : randomNumber;

        switch (randomNumber) {
            case 8:
                System.out.println("Favorite character set to: Backspace");
                break;
            case 9:
                System.out.println("Favorite character set to: Horizontal Tab");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("Favorite character set to: Something weird");
                break;

            default:
                System.out.println("Favorite character set to: " + this.favoriteChar);
                break;
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public static int getNumberOfAnimals() {
        return numberOfAnimals;
    }

    public static void setNumberOfAnimals(int numberOfAnimals) {
        Animal.numberOfAnimals = numberOfAnimals;
    }

    protected static void countTo(int startingNumber) {
        for(int i = startingNumber; i <= 100; i++) {
            if(i == 90) continue;

            System.out.println(i);
        }
    }

    protected static String printNumbers(int maxNumbers) {
        int i = 1;
        while(i < (maxNumbers / 2)) {
            System.out.println(i);
            i++;

            if(i == (maxNumbers/2)) break;
        }

        Animal.countTo(maxNumbers / 2);

        return "End of printNumbers()";
    }

    protected static void guessMyNumber() {
        int number;

        do {
            System.out.println("Guess number up to 100");
            while (!userInput.hasNextInt()) {
                String numberEntered = userInput.next();
                System.out.printf("%s is not a number\n", numberEntered);
            }
            number = userInput.nextInt();
        } while (number != 50);

        System.out.println("Yes the number was 50");
    }

    public String makeSound() {
        return "Grrr";
    }

    public static void speakAnimal(Animal randAnimal) {
        System.out.println("Animal says " + randAnimal.makeSound());
    }

    // public allows other classes to use this method
    // static means only a class can call for this to execute
    // void means it doesn't return a value when it finishes executing
    public static void main(String[] args) {

        Animal theAnimal = new Animal();

        int[] favoriteNumbers = new int[20];

        favoriteNumbers[0] = 100;

        String[] stringArray = {"Random", "Words", "Here"};

        for(String word : stringArray) {
            System.out.println(word);
        }

        // This is a multidimensional array
        String[][][] arrayName = {{{"000"}, {"100"}, {"200"}, {"300"}},
                {{"010"}, {"110"}, {"210"}, {"310"}},
                {{"020"}, {"120"}, {"220"}, {"320"}}};

        for(int i = 0; i < arrayName.length; i++) {
            for(int j = 0; j < arrayName[i].length; j++) {
                for(int k = 0; k < arrayName[i][j].length; k++) {
                    System.out.println("| " + arrayName[i][j][k] + "");
                }
            }
            System.out.println("|");
        }

        String[] cloneOfArray = Arrays.copyOf(stringArray, 3);
        System.out.println(Arrays.toString(cloneOfArray));
        System.out.println(Arrays.binarySearch(cloneOfArray, "Random"));
    }
}
