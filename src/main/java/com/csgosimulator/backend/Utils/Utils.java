package com.csgosimulator.backend.Utils;

import lombok.Getter;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.bind.MissingServletRequestParameterException;

@Getter
public final class Utils {

    public static JSONObject jsonifyParamsMissing(MissingServletRequestParameterException exception) throws JSONException {
        var response = new JSONObject();
        response.put("messsage", exception.getMessage());
        response.put("Param Name", exception.getParameterName());
        response.put("Param Type", exception.getParameterType());
        return response;
    }
}