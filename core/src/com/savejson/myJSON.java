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

public class myJSON extends Game {
	SpriteBatch batch;
	Texture img;
        
    Json json;
    JsonValue value;
    JsonReader reader;
    FileHandle file;
    String sJsonString;
	
        DataStore data;
	@Override
	public void create () {
        batch = new SpriteBatch();
        data = new DataStore();    
        json = new Json();
        
        file = new FileHandle("myJSONFile.json");
        data.sName = "James";
        data.nAge = 78;
        ArrayList numberList = new ArrayList();
        numberList.add("2343143");
        numberList.add("3232932232323");
        data.numbers = numberList;
        json.toJson(data,file);
                
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		batch.end();
	}
}
