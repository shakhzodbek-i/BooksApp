package corp.king.booksapp.data.repositories;

import java.util.List;

import corp.king.booksapp.models.Volume;

public interface VolumeRepository {

    List<Volume> getVolumeListByCategory(String category);

    Volume getVolumeById(String volumeId);

}
