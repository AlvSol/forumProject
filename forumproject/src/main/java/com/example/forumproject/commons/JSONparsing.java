package com.example.forumproject.commons;

import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONparsing {

    public List<String> getBannedWord() {

        List<String> bannedList = new ArrayList<>();
        try {
            //Class<?> cls = Class.forName("JSONparsing.class");
            //ClassLoader classLoader = cls.getClassLoader();
            //JsonReader reader = new JsonReader(new FileReader(classLoader.getResource("links.json").getFile()));
            JsonReader reader = new JsonReader(new FileReader("src/main/java/com/example/forumproject/commons/bannedWords.json"));
            reader.beginArray();
            while (reader.hasNext()) {
                String value = reader.nextString();
                bannedList.add(value);
            }
            reader.endArray();
            reader.close();

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return bannedList;
    }
}
