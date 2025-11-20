package cz.richard.accounts.serialization;

import com.google.gson.*;
import com.thoughtworks.xstream.XStream;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Serializer {

    static Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .setPrettyPrinting()
            .create();

    static public String serialize(Object object){
        try {
            return gson.toJson(object);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }

    static public Object deserialize(String object, Class clazz){
        return gson.fromJson(object, clazz);
    }
}
