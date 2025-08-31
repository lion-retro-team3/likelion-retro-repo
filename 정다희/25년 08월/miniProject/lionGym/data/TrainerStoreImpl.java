package miniProject.lionGym.data;

import miniProject.lionGym.people.Trainer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 트레이너 저장소 구현체
 * @author dahee
 * @since 25.08.30
 */
public class TrainerStoreImpl implements TrainerStore{
    private final Map<String, Trainer> trainerMap = new LinkedHashMap<>();

    @Override
    public List<Trainer> trainerList() {
        return new ArrayList<>(trainerMap.values());
    }

    @Override
    public void saveTrainer(Trainer trainer) {
        trainerMap.put(trainer.getId(), trainer);
    }

    @Override
    public void removeTrainer(Trainer trainer) {
        trainerMap.remove(trainer.getId());
    }

    @Override
    public Trainer findById(String id) {
        if(id != null) {
            return trainerMap.get(id);
        } else {
            return null;
        }
    }
}
