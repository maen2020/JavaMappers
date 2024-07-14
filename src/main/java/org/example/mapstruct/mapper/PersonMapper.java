package org.example.mapstruct.mapper;

import org.example.mapstruct.dto.PersonCustomDTO;
import org.example.mapstruct.dto.PersonDefaultDTO;
import org.example.mapstruct.entites.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//En esta interfaz se crea el mapeo personalizado.
@Mapper
public interface PersonMapper {

    /* Mapstruct - Default */
    //Instancia que posteriromente se va a llamar.
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    //Convertir un objeto person a un personDefaultDTO.
    PersonDefaultDTO personToPersonDefaultDTO(Person person);

    /* Mapstruct - Custom */
    /*
    * source (Person person) = Atributo de donde sale.
    * target (PersonDefaultDTO)= Atributo a donde llega.
    * */
    @Mapping(source = "id", target = "idDTO")
    @Mapping(source = "name", target = "nameDTO")
    @Mapping(source = "lastName", target = "lastNameDTO")
    @Mapping(source = "email", target = "emailDTO")
    @Mapping(source = "age", target = "ageDTO")
    @Mapping(source = "gender", target = "genderDTO")
    PersonCustomDTO personToPersonCustomDTO(Person person);
}