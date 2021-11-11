package support;

import org.apache.commons.lang3.RandomStringUtils;

public class HelperMethods {

    public static String randomString(int numberOfRandomCharacters) {
        return RandomStringUtils.randomAlphanumeric(numberOfRandomCharacters);
    }

}
