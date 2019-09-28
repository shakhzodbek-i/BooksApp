package corp.king.booksapp.di;


import corp.king.booksapp.presentation.views.MyLibActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Привязывает все субкомпоненты внутри приложения
 */
@Module
public abstract class BuildersModule {

    @MyLibActivityScope
    @ContributesAndroidInjector(modules = MyLibActivityModule.class)
    abstract MyLibActivity bindMyLibActivity();
}
