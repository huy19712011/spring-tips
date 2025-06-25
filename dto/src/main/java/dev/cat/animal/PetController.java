package dev.cat.animal;

import dev.cat.employee.EmployeeDTO;
import dev.cat.employee.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/dogs")
    public List<DogDTO> findAllDogs() {
        return petService.findAllDogs();
    }

    @GetMapping("/cats")
    public List<CatDTO> findAllCats() {
        return petService.findAllCats();
    }

}
