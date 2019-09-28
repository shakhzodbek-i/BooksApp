package corp.king.booksapp.di;

import corp.king.booksapp.data.api.BookshelfApi;
import corp.king.booksapp.data.api.VolumesApi;
import corp.king.booksapp.data.repositories.BookshelfRepository;
import corp.king.booksapp.data.repositories.BookshelfRepositoryImpl;
import corp.king.booksapp.data.repositories.VolumeRepository;
import corp.king.booksapp.data.repositories.VolumesRepositoryImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class MyLibActivityModule {


    @Provides
    @MyLibActivityScope
    VolumeRepository provideVolumeRepository(VolumesApi volumesApi) {
        return new VolumesRepositoryImpl(volumesApi);
    }

    @Provides
    @MyLibActivityScope
    BookshelfRepository provideBookshelfRepository(BookshelfApi bookshelfApi) {
        return new BookshelfRepositoryImpl(bookshelfApi);
    }
}
