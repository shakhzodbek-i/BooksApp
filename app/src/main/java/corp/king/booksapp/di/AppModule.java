package corp.king.booksapp.di;

import android.content.Context;


import javax.inject.Singleton;

import corp.king.booksapp.App;
import dagger.Module;
import dagger.Provides;

/**
 * Модуль, предоставляющий зависимости в масштабах приложения
 */
@Module
public class AppModule {

    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

//    @Provides
//    @Singleton
//    SharedPreferencesHelper provideSharedPreferencesHelper(App app) {
//        return new SharedPreferencesHelper(app);
//    }

}
