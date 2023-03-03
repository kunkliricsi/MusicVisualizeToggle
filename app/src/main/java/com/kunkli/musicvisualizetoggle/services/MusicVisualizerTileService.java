package com.kunkli.musicvisualizetoggle.services;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

import java.util.Locale;

public class MusicVisualizerTileService extends TileService {

    // Called when the user adds your tile.
    @Override
    public void onTileAdded() {
        super.onTileAdded();
    }

    // Called when your app can update your tile.
    @Override
    public void onStartListening() {
        super.onStartListening();

        updateTile();
    }

    // Called when your app can no longer update your tile.
    @Override
    public void onStopListening() {
        super.onStopListening();
    }

    // Called when the user taps on your tile in an active or inactive state.
    @Override
    public void onClick() {
        super.onClick();
        boolean isVisualizerOn = isVisualizerOn();
        setVisualizer(!isVisualizerOn);
        updateTile();
    }

    // Called when the user removes your tile.
    @Override
    public void onTileRemoved() {
        super.onTileRemoved();
    }

    private void updateTile() {

        Tile tile = this.getQsTile();
        boolean isActive = isVisualizerOn();

        String newLabel;
        int newState;

        // Change the tile to match the service status.
        if (isActive) {
            newState = Tile.STATE_ACTIVE;
        } else {
            newState = Tile.STATE_INACTIVE;
        }

        // Change the UI of the tile.
        tile.setState(newState);

        // Need to call updateTile for the tile to pick up changes.
        tile.updateTile();
    }

    private boolean isVisualizerOn() {
        try {
            ContentResolver contentResolver = getContentResolver();
            int musicEnalbe = Settings.Global.getInt(contentResolver, "led_effect_music_enalbe");
            return musicEnalbe > 0;
        } catch (Settings.SettingNotFoundException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    private void setVisualizer(boolean status) {
        ContentResolver contentResolver = getContentResolver();
        Settings.Global.putInt(contentResolver, "led_effect_music_enalbe", status ? 1 : 0);
    }
}