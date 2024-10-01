package com.pluralsight;

import java.util.Scanner;

public class Debug {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        //declaring variables
        double priceOfCarRentalPerDay = 29.99;
        double priceOfTollPerDay = 3.95;
        double priceOfGPSPerDay = 2.95;
        double priceOfRoadsidePerDay = 3.95;
        float underAgeSurgeChargePercent = 0.30f;
        int underAgeCutOffAge = 25;

        //declare variables
        String pickUpDate = PromptUser("Pick up date: ");
        short numberOfDays = PromptForDays("How many days? ");
        boolean needTollTag = PromptForYesOrNo("Need a toll tag? ");
        boolean needGps = PromptForYesOrNo("Need gps? ");
        boolean needRoadSide = PromptForYesOrNo("Need roadside? ");
        byte age = PromptForAge("Enter age ");

        double baseCarRental = numberOfDays * priceOfCarRentalPerDay;

        //variables declared with if statements  ("?" = if ) | " : 0 " = false
        double costOfTollTag = (needTollTag) ? (numberOfDays * priceOfTollPerDay) : 0;
        double costOfGPS = (needGps) ? (numberOfDays * priceOfGPSPerDay) : 0;
        double roadsideFee = (needRoadSide) ? (numberOfDays * priceOfRoadsidePerDay) : 0;
        double optionTotalFee = costOfTollTag + costOfGPS + roadsideFee;
        double underAgeExtraFree = (age < underAgeCutOffAge) ? baseCarRental * underAgeSurgeChargePercent : 0;
        double totalCost = baseCarRental + optionTotalFee + underAgeExtraFree;

        //display results
        System.out.printf("Basic car rental fee: %.2f \n", baseCarRental);
        System.out.printf("Options fee: %.2f\n", optionTotalFee);
        System.out.printf("Under driver surcharge fee: %.2f \n", underAgeExtraFree);
        System.out.printf("_______________________");
        System.out.printf("\nTotal cost: \t%.2f", totalCost);
    }

    public static String PromptUser(String prompt){
        System.out.print(prompt);
        return s.nextLine();
    }

    public static boolean PromptForYesOrNo(String prompt) {
        System.out.print(prompt + " (Y for yes, N for No ) ");
        String answer = s.nextLine();
        return(answer.equals("Y") || answer.equalsIgnoreCase("Yes"));
    }

    public static short PromptForDays(String prompt){
        System.out.print(prompt);
        short number = s.nextShort();
        s.nextLine();
        return number;
    }
    public  static byte PromptForAge(String prompt){
        System.out.print(prompt);
        byte age = s.nextByte();
        s.nextLine();
        return age;
    }

}
