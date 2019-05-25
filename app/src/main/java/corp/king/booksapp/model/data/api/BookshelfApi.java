package corp.king.booksapp.model.data.api;

import java.util.List;

import corp.king.booksapp.model.domain.Bookshelf;
import corp.king.booksapp.model.domain.BookshelvesList;
import corp.king.booksapp.model.domain.Volume;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BookshelfApi {

    @GET("/users/{userId}/bookshelves?key=AIzaSyARRU_4PePaSYbUU2piUvEm1mNv4IotS9c")
    Call<BookshelvesList> getBookshelfList(@Path("userId") String userId);

    @GET("/users/{userId}/bookshelves/{shelf}?key=AIzaSyARRU_4PePaSYbUU2piUvEm1mNv4IotS9c")
    Call<Bookshelf> getBookshelf(@Path("userId") String userId, @Path("shelf") String shelf);

    @GET("/users/{userId}/bookshelves/0/volumes?key=AIzaSyARRU_4PePaSYbUU2piUvEm1mNv4IotS9c")
    Call<List<Volume>> getVolumes(String userId);

}