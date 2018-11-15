package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;


import java.io.IOException;

public class Client {

    public static void craeteProject() throws IOException {
        String accessToken = getAccessToken("\"LuizaUser\"","\"luiza123456\"");
        System.out.println(accessToken);
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"is_private\":false,\"creation_template\":1,\"name\":\"Luiza_ScrumProject_Test4\",\"description\":\"Luiza_ScrumProject_Test\"}\n");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/projects")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + accessToken)
                //.addHeader("Authorization", "Bearer " + "eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjozMzUwODZ9:1gMoIs:cajgiJgpwxvADeZAwbvy24fUGm4")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        System.out.println(jsonString);
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();

    }
    public static void kanbanStory() throws IOException {
    String accessToken = getAccessToken("\"LuizaUser\"","\"luiza123456\"");
    System.out.println(accessToken);
    OkHttpClient client = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = RequestBody.create(mediaType, "{\"_attrs\":{\"project\":296521,\"subject\":\"\",\"description\":\"\",\"tags\":[],\"points\":{},\"status\":1775557,\"is_archived\":false},\"name\":\"userstories\",\"_dataTypes\":{},\"_modifiedAttrs\":{\"subject\":\"d\",\"description\":\"d7\"},\"_isModified\":true,\"project\":296521,\"subject\":\"d7\",\"description\":\"d7\",\"tags\":[],\"points\":{},\"status\":1775557,\"is_archived\":false,\"is_closed\":false}\n");
    Request request = new Request.Builder()
            .url("https://api.taiga.io/api/v1/userstories")
            .post(body)
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer " + accessToken)
            //.addHeader("Authorization", "Bearer " + "eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjozMzUwODZ9:1gMoIs:cajgiJgpwxvADeZAwbvy24fUGm4")
            .addHeader("cache-control", "no-cache")
            .build();

    Response response = client.newCall(request).execute();
    String jsonString = response.body().string();
        System.out.println(jsonString);
    JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();

}

        public static String getAccessToken (String username, String password) throws IOException {
            OkHttpClient client = new OkHttpClient();

//            String username = "\"LuizaUser\"";
//            String password = "\"luiza123456\"";
            MediaType mediaType = MediaType.parse("application/json");
            String json = "{\"username\":%s,\"password\":%s,\"type\":\"normal\"}";
            RequestBody body = RequestBody.create(mediaType,  String.format(json,username,password));
            Request request = new Request.Builder()
                    .url("https://api.taiga.io/api/v1/auth")
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .build();

            Response response = client.newCall(request).execute();
            String jsonString = response.body().string();
            JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
            return jsonObject.get("auth_token").getAsString();
        }


    public static void main(String[] args) throws IOException {
        craeteProject();
       // kanbanStory();

    }


    }
