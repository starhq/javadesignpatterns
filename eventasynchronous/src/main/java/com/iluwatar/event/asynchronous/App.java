package com.iluwatar.event.asynchronous;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static final String PROP_FILE_NAME = "config.properties";

    boolean interactiveMode = false;

    public static void main(String[] args) {
        App app = new App();

        app.setUp();
        app.run();
    }

    public void setUp() {
        Properties prop = new Properties();

        InputStream inputStream = App.class.getClassLoader().getResourceAsStream(PROP_FILE_NAME);

        if (inputStream != null) {
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                System.out.println(PROP_FILE_NAME + " was not found. Defaulting to non-interactive mode.");
            }
        }

        String property = prop.getProperty("INTERACTIVE_MODE");
        if (property.equalsIgnoreCase("YES")) {
            interactiveMode = true;
        }
    }

    public void run() {
        if (interactiveMode) {
            runInteractiveMode();
        } else {
            quickRun();
        }
    }

    public void quickRun() {
        EventManager eventManager = new EventManager();
        try {
            // Create an Asynchronous event.
            int aEventId = eventManager.createAsync(60);
            System.out.println("Async Event [" + aEventId + "] has been created.");
            eventManager.start(aEventId);
            System.out.println("Async Event [" + aEventId + "] has been started.");

            // Create a Synchronous event.
            int sEventId = eventManager.create(60);
            System.out.println("Sync Event [" + sEventId + "] has been created.");
            eventManager.start(sEventId);
            System.out.println("Sync Event [" + sEventId + "] has been started.");

            eventManager.status(aEventId);
            eventManager.status(sEventId);

            eventManager.cancel(aEventId);
            System.out.println("Async Event [" + aEventId + "] has been stopped.");
            eventManager.cancel(sEventId);
            System.out.println("Sync Event [" + sEventId + "] has been stopped.");

        } catch (MaxNumOfEventsAllowedException | LongRunningEventException | EventDoesNotExistException
                | InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    public void runInteractiveMode() {
        EventManager eventManager = new EventManager();

        Scanner s = new Scanner(System.in);
        int option = -1;
        while (option != 4) {
            System.out.println("Hello. Would you like to boil some eggs?");
            System.out.println("(1) BOIL AN EGG \n(2) STOP BOILING THIS EGG \n(3) HOW ARE MY EGGS? \n(4) EXIT");
            System.out.print("Choose [1,2,3,4]: ");
            option = s.nextInt();

            if (option == 1) {
                s.nextLine();
                System.out.print("Boil multiple eggs at once (A) or boil them one-by-one (S)?: ");
                String eventType = s.nextLine();
                System.out.print("How long should this egg be boiled for (in seconds)?: ");
                int eventTime = s.nextInt();
                if (eventType.equalsIgnoreCase("A")) {
                    try {
                        int eventId = eventManager.createAsync(eventTime);
                        eventManager.start(eventId);
                        System.out.println("Egg [" + eventId + "] is being boiled.");
                    } catch (MaxNumOfEventsAllowedException | LongRunningEventException | EventDoesNotExistException
                            e) {
                        System.out.println(e.getMessage());
                    }
                } else if (eventType.equalsIgnoreCase("S")) {
                    try {
                        int eventId = eventManager.create(eventTime);
                        eventManager.start(eventId);
                        System.out.println("Egg [" + eventId + "] is being boiled.");
                    } catch (MaxNumOfEventsAllowedException | InvalidOperationException | LongRunningEventException
                            | EventDoesNotExistException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Unknown event type.");
                }
            } else if (option == 2) {
                System.out.print("Which egg?: ");
                int eventId = s.nextInt();
                try {
                    eventManager.cancel(eventId);
                    System.out.println("Egg [" + eventId + "] is removed from boiler.");
                } catch (EventDoesNotExistException e) {
                    System.out.println(e.getMessage());
                }
            } else if (option == 3) {
                s.nextLine();
                System.out.print("Just one egg (O) OR all of them (A) ?: ");
                String eggChoice = s.nextLine();

                if (eggChoice.equalsIgnoreCase("O")) {
                    System.out.print("Which egg?: ");
                    int eventId = s.nextInt();
                    try {
                        eventManager.status(eventId);
                    } catch (EventDoesNotExistException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (eggChoice.equalsIgnoreCase("A")) {
                    eventManager.statusOfAllEvents();
                }
            } else if (option == 4) {
                eventManager.shutdown();
            }
        }

        s.close();
    }
}
