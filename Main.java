
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final DecimalFormat df = new DecimalFormat("0.00");

        //Start of application, letting them know this is a temperature converter, and how to
        //properly input the temp. Application will run by asking the type of temp they want to convert FROM
        //then ask the number, and then what they want to convert TO
        System.out.println("Hello world!");
        System.out.printf("Welcome to my very first self application, a temperature Converter!\n\n");

        //starting scanner, opening for user input
        Scanner scanner = new Scanner(System.in);
        System.out.printf("To start, please type what temperature you want to convert FROM \nF for Fahrenheit, C for Celsius, and K for Kelvin: ");
        String tempConvertingFROM = scanner.nextLine();

        //change the letter to the full name

        try {
            if (tempConvertingFROM.equalsIgnoreCase("F")) {
                tempConvertingFROM = "Fahrenheit";
            } else if (tempConvertingFROM.equalsIgnoreCase("K")) {
                tempConvertingFROM = "Kelvin";
            } else if (tempConvertingFROM.equalsIgnoreCase("C")) {
                tempConvertingFROM = "Celsius";
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.printf("You have input an incorrect value, please restart the application and choose from the list.");
            System.exit(0);
        }

        // confirming what we are converting FROM
        System.out.printf("\n**** Perfect! We will be converting FROM " + tempConvertingFROM + " ****\n");

        //Asking to put the number they want to convert
        System.out.printf("Please type in the number of the temperature you would you to convert: ");
        double temperatureNumber = Double.parseDouble(scanner.nextLine());

        //confirming the temp number
        System.out.printf("\n**** Alright, we will be converting " + temperatureNumber + " degrees " + tempConvertingFROM + " ****");

        //Getting what temp they want to convert TO
        System.out.println("\n\nFinally, please type in what temperature you would like to convert TO");
        System.out.println("F for Fahrenheit, C for Celsius, and K for Kelvin: ");
        String tempConvertingTO = scanner.nextLine();

        //implement logic to make sure its case-insensitive and a valid field

        try {
            if (tempConvertingTO.equalsIgnoreCase("F")) {
                tempConvertingTO = "Fahrenheit";
            } else if (tempConvertingTO.equalsIgnoreCase("K")) {
                tempConvertingTO = "Kelvin";
            } else if (tempConvertingTO.equalsIgnoreCase("C")) {
                tempConvertingTO = "Celsius";
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.printf("You have input an incorrect value, please restart the application and choose from the list.");
            System.exit(0);
        }


        //Conversion logic and equations
    double finalTotal = 0.0;

        if(tempConvertingFROM.equalsIgnoreCase(tempConvertingTO)){
            System.out.println("\nYou choose the same type of temperature, please restart and choose two DIFFERENT temperature types");
            System.exit(0);
        } else if (tempConvertingFROM.contains("F") && tempConvertingTO.contains("C")){
            // F -> Csubtract 32 and multiply by .5556 (or 5/9).
            finalTotal = (temperatureNumber - 32) * 0.5556;
        } else if (tempConvertingFROM.contains("F") && tempConvertingTO.contains("K")){
            // F -> K To convert Fahrenheit degrees into Kelvins, (°F − 32) × 5/9 + 273.15 = K.
            finalTotal = ((temperatureNumber - 32) * 0.5556 + 273.15);
        } else if (tempConvertingFROM.contains("C") && tempConvertingTO.contains("F")){
            // C -> F     (°C × 9/5) + 32 = °F.
            finalTotal = (temperatureNumber * 1.8) + 32;
        } else if (tempConvertingFROM.contains("C") && tempConvertingTO.contains("K")){
            // C -> K     °C + 273.15 = K
            finalTotal = temperatureNumber + 273.15;
        } else if (tempConvertingFROM.contains("K") && tempConvertingTO.contains("F")){
            // K -> F   (K − 273.15) × 9/5 + 32 = °F.
            finalTotal = (temperatureNumber - 273.15) * 1.8 + 32;
        } else if (tempConvertingFROM.contains("K") && tempConvertingTO.contains("C")){
            // K -> C      K − 273.15 = °C
            finalTotal = temperatureNumber - 273.15;
        }



        //Final calculation and displaying + Thanking the user for using the temperature and how to restart it
        System.out.println("**** " + df.format(temperatureNumber) + " degrees " + tempConvertingFROM + " is equal to " + df.format(finalTotal) + " degrees " + tempConvertingTO + "! ****");
        System.out.println("\n");
        System.out.println("Thank you for using the temperature converter! \nPlease restart the application if you would like to use it again!");
    }
}