package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Json;

public class MyGdxGame extends ApplicationAdapter implements TextInputListener {

    private String text;
    TextInputListener input;
    DataStore data;
    Json json;
    FileHandle file;

    @Override
    public void create() {
        json = new Json();
        data = new DataStore();
        file = new FileHandle("myJSONFile.json");
    }

    @Override
    public void render() {
        if (Gdx.input.isTouched()) {
            Gdx.input.getTextInput(this, "title", "default text", "");
        }
        Gdx.app.log(text, text);
        data.sSentence = text;
        json.toJson(data, file);
    }

    @Override
    public void input(String text) {
        this.text = text;
    }

    @Override
    public void canceled() {
    }
}
