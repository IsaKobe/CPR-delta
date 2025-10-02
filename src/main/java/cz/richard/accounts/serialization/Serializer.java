package cz.richard.accounts.serialization;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import cz.richard.accounts.Data.Account;

public class Serializer {

    public String serialize(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public Object deserialize(String object, Class clazz){
        Gson gson = new Gson();
        return gson.fromJson(object, clazz);
    }

    public String serializeXML(Object object){
        XStream xmlStream = new XStream();
        return xmlStream.toXML(object);
    }

    public String serialize(ISerializable[] data)
    {
        StringBuilder builder = new StringBuilder();
        createObject(builder, createList("accounts", data));
        builder.deleteCharAt(builder.length()-2);
        return builder.toString();
    }

    String createList(String fieldName, ISerializable[] data){
        StringBuilder listBuilder = new StringBuilder();
        listBuilder.append(String.format("\"%s\": [", fieldName));
        for(ISerializable item : data){
            createObject(listBuilder, item.serialize());
        }
        listBuilder.deleteCharAt(listBuilder.length()-2);
        listBuilder.append("]");
        return listBuilder.toString();
    }

    void createObject(StringBuilder builder, String content){
        builder.append(String.format("""
                {
                    %s
                },
                """, content));
    }
}
