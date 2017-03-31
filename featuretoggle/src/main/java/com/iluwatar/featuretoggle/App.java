package com.iluwatar.featuretoggle;

import com.iluwatar.featuretoggle.pattern.Service;
import com.iluwatar.featuretoggle.pattern.propertiesversion.PropertiesFeatureToggleVersion;
import com.iluwatar.featuretoggle.user.User;
import com.iluwatar.featuretoggle.user.UserGroup;

import java.util.Properties;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        final Properties properties = new Properties();
        properties.put("enhancedWelcome", true);
        Service service = new PropertiesFeatureToggleVersion(properties);
        final String welcomeMessage = service.getWelcomeMessage(new User("Jamie No Code"));
        System.out.println(welcomeMessage);

        // ---------------------------------------------

        final Properties turnedOff = new Properties();
        turnedOff.put("enhancedWelcome", false);
        Service turnedOffService = new PropertiesFeatureToggleVersion(turnedOff);
        final String welcomeMessageturnedOff = turnedOffService.getWelcomeMessage(new User("Jamie No Code"));
        System.out.println(welcomeMessageturnedOff);

        // --------------------------------------------

        final User paidUser = new User("Jamie Coder");
        final User freeUser = new User("Alan Defect");

        UserGroup.addUserToPaidGroup(paidUser);
        UserGroup.addUserToFreeGroup(freeUser);

        final String welcomeMessagePaidUser = service.getWelcomeMessage(paidUser);
        final String welcomeMessageFreeUser = service.getWelcomeMessage(freeUser);
        System.out.println(welcomeMessageFreeUser);
        System.out.println(welcomeMessagePaidUser);
    }
}
