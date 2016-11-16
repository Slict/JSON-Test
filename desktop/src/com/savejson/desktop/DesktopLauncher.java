package com.savejson.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import JSON.myJSON;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1280;
        config.height = 720;
        config.fullscreen = false;
        config.forceExit = true;
        config.vSyncEnabled = false;
        new LwjglApplication(new myJSON(), config);
    }
}
