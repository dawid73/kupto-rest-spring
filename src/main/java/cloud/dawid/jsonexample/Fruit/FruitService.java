package cloud.dawid.jsonexample.Fruit;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class FruitService {

    private final FruitRepository fruitRepository;

    public List<Fruit> findAll() {return fruitRepository.findAll();}

    @Transactional
    public void delFruit(@NonNull long id) throws EntityNotFoundException {
        if(!fruitRepository.existsById(id))
            throw new EntityNotFoundException("Nie owoca z takim id: "  + id);
        fruitRepository.deleteById(id);
    }

    @Transactional
    public void createFruit(@NonNull Fruit fruit){
        fruitRepository.save(fruit);
    }


}
