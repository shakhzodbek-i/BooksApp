package corp.king.booksapp.model.data.repositories;

import java.util.List;

import corp.king.booksapp.model.domain.Volume;

public interface VolumeRepository {

    List<Volume> getVolumeListByCategory(String category);

    Volume getVolumeById(String volumeId);

}
