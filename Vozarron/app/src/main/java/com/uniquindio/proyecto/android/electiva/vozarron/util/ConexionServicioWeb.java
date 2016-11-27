package com.uniquindio.proyecto.android.electiva.vozarron.util;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Participante;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 * Created by USUARIO WINDOWS on 26/11/2016.
 */
public class ConexionServicioWeb {

    public static ArrayList<Participante> getListaDePartcipantes() {

        ArrayList<Participante> participantes = new ArrayList<>();

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(Utilidades.URL_SERVICIO);
        request.setHeader("content-type", "application/json");

        try {

            Type listType = new TypeToken<ArrayList<Participante>>() {
            }.getType();
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

                @Override
                public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    try {
                        return df.parse(json.getAsString());
                    } catch (ParseException ex) {
                        return null;
                    }
                }
            });

            HttpResponse resp = httpClient.execute(request);
            String respStr = EntityUtils.toString(resp.getEntity());
            Gson gson = gsonBuilder.create();
            participantes = gson.fromJson(respStr, listType);

        } catch (Exception e) {
            Log.v("Listar-WebService", e.getMessage());
            return null;
        }

        return participantes;

    }
}
