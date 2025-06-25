package dev.cat.animal;

import dev.cat.customer.mapper.OrderMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface DtoInterfaceMapper {

    DtoInterfaceMapper INSTANCE = Mappers.getMapper(DtoInterfaceMapper.class);

    default DtoInterface toDto(AnimalInterface domain) {
        if (domain instanceof Dog) {
            return maptoDogDTO((Dog) domain);
        }
        else if (domain instanceof Cat) {
            return maptoCatDTO((Cat) domain);
        }
        return null;
    }

    DogDTO maptoDogDTO(Dog domain);

    CatDTO maptoCatDTO(Cat domain);

}
