package textfield.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;

public class MyGdxGame extends ApplicationAdapter {

    DataStore data;
    Json json;
    JsonReader reader;
    FileHandle file;
    TextFieldStyle textstyle;
    Skin textboxskin;
    TextField text;
    BitmapFont font;
    Stage stage;
    Table table;
    Texture texCur;
    TextureAtlas atlas;
    TextFieldListener tfl;
    String sText;
    SpriteBatch batch;
    Boolean bDraw = false;

    @Override
    public void create() {
        data = new DataStore();
        json = new Json();
        file = new FileHandle("myjson.json");
        reader = new JsonReader();
        
        batch = new SpriteBatch();

        stage = new Stage();
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        textboxskin = new Skin();
        textstyle = new TextFieldStyle();
        table = new Table();
        atlas = new TextureAtlas(Gdx.files.internal("Buttons.pack"));
        texCur = new Texture(Gdx.files.internal("cursor.png"));

        textboxskin.addRegions(atlas);


        textstyle.background = textboxskin.getDrawable("ButtonUp");
        textstyle.font = font;
        textstyle.cursor = new TextureRegionDrawable(new TextureRegion(texCur));

        textstyle.fontColor = Color.BLACK;

        text = new TextField("", textstyle);
        text.setWidth(200);
        text.setHeight(60);
        text.setX(200);
        text.setY(200);
        text.setTextFieldListener(new TextFieldListener() {
            @Override
            public void keyTyped(TextField textField, char key) {
            }
        });
        text.setAlignment(Align.center);
        stage.addActor(text);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, "Press T to open the text field and en"
                + "ter to close and save the text", 10, 400);
        batch.end();
        if (bDraw) {
            stage.draw();
        }
        if (Gdx.input.isKeyJustPressed(Keys.T)){
            bDraw = true;
        }
        if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
            bDraw= false;
            data.sInput = text.getText();
            json.toJson(data, file);
            text.setMessageText("");
            System.out.println(reader.parse(file).get("sInput").asString());

        }

    }
}
