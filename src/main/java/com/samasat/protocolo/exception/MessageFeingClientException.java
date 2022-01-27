package com.samasat.protocolo.exception;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageFeingClientException {
    
    public String MessageFeingClientException(String message) {
        System.out.println("ERRORMESSAGE "+message);
        List<String> errorMessages = new ArrayList<>();
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(message);
        while (m.find()) {
            errorMessages.add(m.group(1));
        }
        if (errorMessages.size() >= 4) {
            JSONObject errorJson = new JSONObject(errorMessages.get(4));
            return errorJson.getString("descripcion");
        } else {
            return "";
        }
    }
}
