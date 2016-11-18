package edu.orangecoastcollege.sbadajoz.ic22;

import java.util.Scanner;

/*
Badajoz, Seve
CS A170
November 18, 2016

IC22
 */
public class AppointmentScheduler {
    public static void main(String[] args) {
        String[] schedule = new String[6];
        Scanner input = new Scanner(System.in);
        int full = 0, time;
        while(full != 6) {
            System.out.println("\nPlease enter an empty time to add an appoinment to");
            try {
                time = input.nextInt();
                
                if(time > 6 || time < 1) System.out.println("Please enter a time between 1 and 6");
                else{
                    if(!(schedule[time - 1] == (null))) throw new TimeInUseException("This time slot is already filled by " + schedule[time - 1]);
                    input.nextLine();
                    System.out.println("Enter the appoinment holder's name");
                    schedule[time - 1] = input.nextLine();
                    full ++;
                }
            }
            catch(TimeInUseException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Schedule is filled, here is the schedule for the day: ");
        for (int i = 0; i < schedule.length; i++) {
            System.out.println(i + 1 + ":00 PM - " + schedule[i]);
        }


    }
}
