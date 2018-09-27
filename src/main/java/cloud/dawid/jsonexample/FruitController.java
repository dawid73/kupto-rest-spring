package cloud.dawid.jsonexample;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/fruits")
@NoArgsConstructor
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }

    @GetMapping("/all")
    public List<Fruit> allFruits(){
        return fruitService.findAll();
    }


}
