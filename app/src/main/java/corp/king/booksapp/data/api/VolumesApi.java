package corp.king.booksapp.data.api;

import java.util.List;

import corp.king.booksapp.models.Volume;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface VolumesApi {
    @GET("/{volumeId}")
    Call<Volume> getVolume(@Path("volumeId") String volumeId);

    @GET("?q={category}")
    Call<List<Volume>> getVolumesByCategory(@Path("category") String category);

    @GET("?q={searchText}")
    Call<List<Volume>> searchVolumes(@Path("searchText") String searchText);
}