import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;


public class Copy implements Screen {

    Texture background;
    Sprite backgroundSprite;
    SpriteBatch spriteBatch;
    Table table;
    Stage stage;

    TextureAtlas menuAtlas;
    Skin menuSkin;

    Label info;
    BitmapFont mainFont;
    Label lblUsername, lblPassword;
    TextField txtUsername, txtPassword;


    @Override
    public void render(float delta) {

        spriteBatch.begin();
        backgroundSprite.draw(spriteBatch);
        spriteBatch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void show() {

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        mainFont = new BitmapFont(Gdx.files.internal("data/fonts/main.fnt"), false);
        mainFont.setColor(1, 1, 1, 1);
        background = new Texture("data/images/background.png");
        background.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        backgroundSprite = new Sprite(background);
        backgroundSprite.setPosition(0, 0);

        spriteBatch = new SpriteBatch();
        table = new Table();

        menuSkin = new Skin();
        menuAtlas = new TextureAtlas("data/packs/menu.pack");

        menuSkin.addRegions(menuAtlas);

        LabelStyle infoStyle = new LabelStyle(mainFont, Color.WHITE);

        info = new Label("Hello there and welcome.", infoStyle);
        info.setBounds(110, 355, 585, 90);
        info.setAlignment(2);

        lblUsername = new Label("Username:", infoStyle);
        lblPassword = new Label("Password:", infoStyle);


        TextFieldStyle txtStyle = new TextFieldStyle();
        txtStyle.background = menuSkin.getDrawable("textbox");
        txtStyle.font = mainFont;

        txtUsername = new TextField("", txtStyle);
        txtPassword = new TextField("", txtStyle);
        txtPassword.setPasswordMode(true);
        txtPassword.setPasswordCharacter('*');
        txtUsername.setMessageText("test");

        txtUsername.setTextFieldListener(new TextFieldListener() {

            @Override
            public void keyTyped(TextField textField, char key) {
                    Gdx.app.log("Skillaria", "" + key);
            }
        });

        txtPassword.setTextFieldListener(new TextFieldListener() {

            @Override
            public void keyTyped(TextField textField, char key) {

                    Gdx.app.log("Skillaria", "" + key);
            }
        });

        table.add(lblUsername).pad(2);
        table.row();
        table.add(txtUsername).pad(2);
        table.row().pad(10);
        table.add(lblPassword).pad(2);
        table.row();
        table.add(txtPassword).pad(2);
        table.setBounds(110, 225, 585, 200);

        stage.addActor(info);
        stage.addActor(table);
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        background.dispose();
        stage.dispose();
        menuSkin.dispose();
        menuAtlas.dispose();
        mainFont.dispose();

    }


}