package com.example.frankja.livewallpaper;

import android.graphics.Movie;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.SurfaceHolder;



import java.io.IOException;
import android.os.Handler;

public class GIFWallpaperService extends WallpaperService {

    Movie movie;



    @Override
    public WallpaperService.Engine onCreateEngine() {
        try{
            Movie movie = Movie.decodeStream(
                    getResources().getAssets().open("daytime.gif"));
            return new GIFWallpaperEngine(movie);

        }catch(IOException e){
            Log.d("GIF", "Could not load asset");
            return null;
        }
    }

    private class GIFWallpaperEngine extends WallpaperService.Engine {

        private final int frameDuration = 20;
        private SurfaceHolder holder;
        private Movie movie;
        private boolean visible;
        private Handler handler;

        public GIFWallpaperEngine(Movie movie) {
            this.movie = movie;
            handler = new Handler();
        }
    }
}
