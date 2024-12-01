package auxiliary;

import driver_factory.DriverManager;
import enums.TestVariables;
import enums.product.DateTime;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class StaticAuxiliary {

    public static Map<TestVariables, String> getRelation(){
        HashMap<TestVariables, String> relationKey = new HashMap<>();
        relationKey.put(TestVariables.FIRST_NAME, getRandomFirstName());
        relationKey.put(TestVariables.LAST_NAME, getRandomLastName());
        relationKey.put(TestVariables.GENDER, getRandomGender());
        relationKey.put(TestVariables.DATE_OF_BIRTH, getRandomDate());
        relationKey.put(TestVariables.SSN, generateSSN());
        relationKey.put(TestVariables.LEGAL_STATUS, getRandomLegalStatus());
        return relationKey;
    }

    // Method to generate random first name
    private static String getRandomFirstName() {
        // List of predefined first names
        List<String> firstNames = Arrays.asList(
                "John", "Alice", "David", "Sophia", "James", "Olivia",
                "Michael", "Isabella", "William", "Emma", "Ethan", "Mia",
                "Alexander", "Ava", "Daniel", "Emily", "Henry", "Grace"
        );
        // Create a Random object
        Random random = new Random();

        // Select a random name from the list
        return firstNames.get(random.nextInt(firstNames.size()));
    }

    // Method to generate random last name
    private static String getRandomLastName() {
        List<String> lastNames = Arrays.asList(
                "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia",
                "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez",
                "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor",
                "Moore", "Jackson", "Martin"
        );

        Random random = new Random();
        return lastNames.get(random.nextInt(lastNames.size()));
    }

    // Method to generate random gender (Male/Female)
    private static String getRandomGender() {
        List<String> genders = Arrays.asList("Male", "Female");

        Random random = new Random();
        return genders.get(random.nextInt(genders.size()));
    }

    // Method to generate a random date in "dd/MM/yyyy" format
    private static String getRandomDate() {
        // Define the range for the random date (e.g., between 1970-01-01 and 2024-12-31)
        LocalDate startDate = LocalDate.of(1970, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);

        // Generate a random number of days between the start and end dates
        long randomDays = ThreadLocalRandom.current().nextLong(startDate.toEpochDay(), endDate.toEpochDay());

        // Generate the random date
        LocalDate randomDate = LocalDate.ofEpochDay(randomDays);

        // Define the date format as "dd/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Return the formatted date
        return randomDate.format(formatter);
    }

    private static String generateSSN() {
        Random random = new Random();

        // Generate first part: 001 to 899 (excluding 666)
        int part1;
        do {
            part1 = random.nextInt(899) + 1;
        } while (part1 == 666);

        // Generate second part: 01 to 99
        int part2 = random.nextInt(99) + 1;

        // Generate third part: 0001 to 9999
        int part3 = random.nextInt(9999) + 1;

        // Format the SSN as XXX-XX-XXXX
        return String.format("%03d-%02d-%04d", part1, part2, part3);
    }

    // Method to generate random first name
    private static String getRandomLegalStatus() {
        // List of predefined first names
        List<String> legalStatus = Arrays.asList(
                "Employment Authorization Document", "Immigrant Visa (1-551 language)",
                "Refugee Travel Document", "Nonimmigrant Student Status(1-20)",
                "1-94", "Arrival/Departure Record(I-94/I94A)",
                "Temporary I-55 Stamp", "Others", "Reentry Permit", "Resident (Green Card)",
                "Citizen"
        );
        // Create a Random object
        Random random = new Random();

        // Select a random name from the list
        return legalStatus.get(random.nextInt(legalStatus.size()));
    }

    public static String getCurrentDate(DateTime dateTime){
        SimpleDateFormat formatter = new SimpleDateFormat(dateTime.label);
        Date date = new Date();
        return formatter.format(date);
    }

    public static File getFileFromPath(String path){
        return new File(path);
    }

    public static WebElement highLight(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red !important;')",
                webElement);
        return webElement;
    }
}
