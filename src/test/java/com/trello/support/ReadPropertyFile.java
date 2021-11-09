package com.trello.support;

import com.trello.api.rest.service.TrelloApiService;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class ReadPropertyFile {

    public TrelloApiService trelloApiService = new TrelloApiService();

    private static Properties properties;

    public static InputStream readFile(String fileName) {
        InputStream inputStream = ReadPropertyFile.class.getClassLoader().getResourceAsStream(fileName);
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

    public static String getBaseUrl() {
        return streamFile().getProperty("URL");
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
}
