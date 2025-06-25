package dev.cat.animal;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {


    private final DogRepository dogRepository;
    private final CatRepository catRepository;

    public PetService(DogRepository dogRepository, CatRepository catRepository) {
        this.dogRepository = dogRepository;
        this.catRepository = catRepository;
    }


    public List<DogDTO> findAllDogs() {
        return dogRepository
                .findAll()
                .stream()
                .map(DtoInterfaceMapper.INSTANCE::toDto)
                .map(d -> (DogDTO) d)
                .toList();
    }

    public List<CatDTO> findAllCats() {
        return catRepository
                .findAll()
                .stream()
                .map(DtoInterfaceMapper.INSTANCE::toDto)
                .map(d -> (CatDTO) d)
                .toList();
    }

}






