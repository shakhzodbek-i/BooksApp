package corp.king.booksapp.di;

import android.content.Context;


import javax.inject.Singleton;

import corp.king.booksapp.App;
import corp.king.booksapp.utility.SharedPreferencesHelper;
import corp.king.booksapp.model.data.api.BookshelfApi;
import corp.king.booksapp.model.data.api.VolumesApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Модуль, предоставляющий зависимости в масштабах приложения
 */
@Module
public class AppModule {

    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferencesHelper provideSharedPreferencesHelper(App app) {
        return new SharedPreferencesHelper(app);
    }

    @Provides
    @Singleton
    VolumesApi provideVolumesApi(){
        return new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/v1/volumes")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VolumesApi.class);
    }

    @Provides
    @Singleton
    BookshelfApi provideBookshelfApi(){
        return new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/v1")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BookshelfApi.class);
    }

}
