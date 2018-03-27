package com.droidsmith.hollywooddb.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Favorite.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FavoriteDao favoriteDao();

}
