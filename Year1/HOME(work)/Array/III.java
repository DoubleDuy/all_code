package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class III {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> ageGroups = new HashMap<>();
        Map<String, Integer> genderWithinAgeGroups = new HashMap<>();
        Map<String, Integer> incomeGroups = new HashMap<>();

        while (true) {
            System.out.print("Enter reader's age (or -1 to stop): ");
            int age = scan.nextInt();
            if (age == -1) {
                break;
            }

            System.out.print("Enter reader's gender (M/F): ");
            char gender = scan.next().toUpperCase().charAt(0);

            System.out.print("Enter reader's marital status (Single/Married): ");
            String maritalStatus = scan.next();

            System.out.print("Enter reader's annual income: ");
            double income = scan.nextDouble();

            // Count readers by age groups
            String ageGroup = getAgeGroup(age);
            ageGroups.put(ageGroup, ageGroups.getOrDefault(ageGroup, 0) + 1);

            // Count readers by gender within age groups
            String genderWithinAgeGroup = ageGroup + " " + (gender == 'M' ? "males" : "females");
            genderWithinAgeGroups.put(genderWithinAgeGroup,
                    genderWithinAgeGroups.getOrDefault(genderWithinAgeGroup, 0) + 1);

            // Count readers by income groups
            String incomeGroup = getIncomeGroup(income);
            incomeGroups.put(incomeGroup, incomeGroups.getOrDefault(incomeGroup, 0) + 1);
        }

        // Print results
        System.out.println("\nReaders by Age Groups:");
        printMap(ageGroups);

        System.out.println("\nReaders by Gender within Age Groups:");
        printMap(genderWithinAgeGroups);

        System.out.println("\nReaders by Income Groups:");
        printMap(incomeGroups);
    }

    private static String getAgeGroup(int age) {
        if (age < 20)
            return "Under 20";
        else if (age < 30)
            return "20-29";
        else if (age < 40)
            return "30-39";
        else if (age < 50)
            return "40-49";
        else
            return "50 and older";
    }

    private static String getIncomeGroup(double income) {
        if (income < 30000)
            return "Under 30000";
        else if (income < 50000)
            return "30000-49999";
        else if (income < 70000)
            return "50000-69999";
        else
            return "70000 and up";
    }

    private static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
