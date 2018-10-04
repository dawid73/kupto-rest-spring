package cloud.dawid.jsonexample.Fruit;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("{id}")
    public void delFruit(@PathVariable long id) { fruitService.delFruit(id);}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fruit createFruit(@RequestBody Fruit fruit){
        fruitService.createFruit(fruit);
        return fruit;
    }

}
