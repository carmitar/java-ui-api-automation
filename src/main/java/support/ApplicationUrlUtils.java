package support;



import jdk.nashorn.internal.objects.annotations.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationUrlUtils {

    private static Properties properties;

    public static InputStream readFile(String fileName) {
        InputStream inputStream = ApplicationUrlUtils.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            System.out.println("Sorry, unable to find " + fileName);
        }
        return inputStream;
    }

    private static Properties streamFile() {
        if (properties != null) {
            return properties;
        }
        properties = new Properties();
        try (InputStream inputStream = readFile("application.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getBaseUrlApi() {
        return streamFile().getProperty("URL_API");
    }

    public static String getBaseUrlUi() {
        return streamFile().getProperty("URL_UI");
    }

    public static String getKey() {
        return streamFile().getProperty("KEY");
    }

    public static String getToken() {
        return streamFile().getProperty("TOKEN");
    }

    public static String getDefaultList() {
        return streamFile().getProperty("DEFAULT_LIST");
    }

    public static String getBoardId() {
        return streamFile().getProperty("BOARD_ID");
    }

    public static String getIdOrganization() {
        return streamFile().getProperty("ID_ORGANIZATION");
    }

    public static String getCreateBoardAPI() {
        return streamFile().getProperty("ID_ORGANIZATION");
    }

    public static String getUsername() {
        return streamFile().getProperty("USERNAME");
    }

    public static String getPassword() {
        return streamFile().getProperty("PASSWORD");
    }

    public static String getDriverName() {
        return streamFile().getProperty("DRIVER_NAME_CHROME");
    }
}
