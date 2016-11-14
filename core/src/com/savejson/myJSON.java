package com.savejson;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import java.util.ArrayList;
import java.util.Scanner;

public class myJSON extends Game {

    SpriteBatch batch;
    Texture img;
    Json json;
    JsonValue value;
    JsonReader reader;
    FileHandle file;
    String sJsonString;
    String result;
    DataStore data;

    @Override
    public void create() {
        batch = new SpriteBatch();
        data = new DataStore();
        json = new Json();
        Scanner sin = new Scanner(System.in);
        reader = new JsonReader();
        file = new FileHandle("myJSONFile.json");
        System.out.println("Enter a sentence");
        data.sSentence = sin.nextLine();
        System.out.println("Enter a word");
        data.sWord = sin.next();
        System.out.println("Enter a number");
        data.sNum = sin.next();

        json.toJson(data, file);
        while (true) {
            System.out.println("Would you like to view the number, the word, or the sentence? Enter 0 to exit");
                if (sin.next().equals("number")) {
                    result = reader.parse(file).get("sNum").asString();
                } else if (sin.next().equals("word")) {
                    result = reader.parse(file).get("sWord").asString();
                } else if (sin.next().equals("sentence")) {
                    result = reader.parse(file).get("sSentence").asString();
                }
                System.out.println(result);
            
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        batch.end();
    }
}
