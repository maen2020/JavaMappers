package org.example.modelMapper;


import org.example.modelMapper.dto.PersonCustomDTO;
import org.example.modelMapper.dto.PersonDefaultDTO;
import org.example.modelMapper.entites.Person;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.lang.reflect.Type;

public class Main {

    /* Model Mapper Default  */
    /*public static void main(String[] args) {

        //Declarar un objeto de la entidad.
        Person person = new Person(1L, "Santiago", "Perez", "santy@gmail.com", (byte) 25, 'M');
        System.out.println(person);

        //Mapeo cuando los atributos se llaman igual.
        ModelMapper modelMapper = new ModelMapper();
        PersonDefaultDTO personDefaultDTO = modelMapper.map(person, PersonDefaultDTO.class);
        System.out.println(personDefaultDTO);
    }*/

    /* Madel Mapper Custom */
    public static void main(String[] args){

        //Declarar un objeto de la entidad.
        Person person = new Person(1L, "Santiago", "Perez", "santy@gmail.com", (byte) 25, 'M');
        System.out.println(person);

        /* Se define el tipo de Mapa personalizado.
        * Clase emisora -> calse receptora.
        */
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Person, PersonCustomDTO> propertyMapper = modelMapper.createTypeMap(Person.class, PersonCustomDTO.class);
        propertyMapper.addMapping(Person::getId, PersonCustomDTO::setIdDTO);
        propertyMapper.addMapping(Person::getName, PersonCustomDTO::setNameDTO);
        propertyMapper.addMapping(Person::getLastName, PersonCustomDTO::setEmailDTO);
        propertyMapper.addMapping(Person::getAge, PersonCustomDTO::setAgeDTO);
        propertyMapper.addMapping(Person::getGender, PersonCustomDTO::setGenderDTO);
        PersonCustomDTO personCustomDTO = propertyMapper.map(person);
        System.out.println(personCustomDTO);
    }
}