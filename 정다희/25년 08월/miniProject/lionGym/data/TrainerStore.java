package miniProject.lionGym.data;

import miniProject.lionGym.people.Trainer;
import java.util.List;

/**
 * 트레이너 저장소 인터페이스
 * @author dahee
 * @since 25.08.30
 */
public interface TrainerStore {
    List<Trainer> trainerList();
    void saveTrainer(Trainer trainer);
    void removeTrainer(Trainer trainer);
    Trainer findById(String id);
}
