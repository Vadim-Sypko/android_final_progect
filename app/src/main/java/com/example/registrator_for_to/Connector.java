package com.example.registrator_for_to;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

// класс Connector для соединения с сервером
public class Connector {
    private static Socket socket;
    private static DataOutputStream out;
    private static DataInputStream in;
    private static JSONObject jsonObject = new JSONObject();
    private static  String response; // ответ от сервера будем сохранять в переменную response
    public static void connect(){  // медот для соединения с сервером
        try {
            socket = new Socket("10.10.10.132", 9537); // создаем сокет
            in = new DataInputStream(socket.getInputStream()); // поток ввода
            out = new DataOutputStream(socket.getOutputStream()); // поток вывода
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // метод авторизации
    public static boolean auth(String login, String pass) {
        try {
            jsonObject.put("action", "login");
            jsonObject.put("login", login);
            jsonObject.put("pass", pass);
            out.writeUTF(jsonObject.toString()); // отправляем на сервер
            response = in.readUTF(); // получаем ответ от сервера
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.equals("success");
    }
}

