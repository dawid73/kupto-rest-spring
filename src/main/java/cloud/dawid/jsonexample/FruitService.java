package cloud.dawid.jsonexample;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class FruitService {

    private final FruitRepository fruitRepository;

    public List<Fruit> findAll() {return fruitRepository.findAll();}

}
