package corp.king.booksapp.model.data.repositories;

import java.util.List;

import corp.king.booksapp.model.data.api.VolumesApi;
import corp.king.booksapp.model.domain.Volume;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VolumesRepositoryImpl implements VolumeRepository {
    private VolumesApi mVolumeRepo;
    private List<Volume> mVolumeList;
    private Volume mVolume;

    public VolumesRepositoryImpl(VolumesApi volumesApi) {
        mVolumeRepo = volumesApi;
    }

    public List<Volume> getVolumeListByCategory(String category) {
        mVolumeRepo.getVolumesByCategory(category).enqueue(new Callback<List<Volume>>() {
            @Override
            public void onResponse(Call<List<Volume>> call, Response<List<Volume>> response) {
                mVolumeList = response.body();
            }

            @Override
            public void onFailure(Call<List<Volume>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return mVolumeList;
    }

    public Volume getVolumeById(String volumeId) {
        mVolumeRepo.getVolume(volumeId).enqueue(new Callback<Volume>() {
            @Override
            public void onResponse(Call<Volume> call, Response<Volume> response) {
                mVolume = response.body();
            }

            @Override
            public void onFailure(Call<Volume> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return mVolume;
    }
}
