package org.example.orikaMapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.example.orikaMapper.dto.PersonCustomDTO;
import org.example.orikaMapper.entites.Person;

public class Main {

    /* Orika Mapper es demasiado configurable. */
    /* Orika Mapper Default
    /* public static void main(String[] args){

        Person person = new Person(1L, "Santigo", "Perez", "santy@gmail.com", (byte) 25, 'M');
        System.out.println(person);

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Person.class, PersonDefaultDTO.class);

        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        PersonDefaultDTO personDefaultDTO = mapperFacade.map(person, PersonDefaultDTO.class);
        System.out.println(personDefaultDTO);
    }*/

    /* Orika Mapper Custom */
    public static void main(String[] args){

        Person person = new Person(1L, "Santigo", "Perez", "santy@gmail.com", (byte) 25, 'M');
        System.out.println(person);

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Person.class, PersonCustomDTO.class)
                .field("id", "idDTO")
                .field("name", "nameDTO")
                .field("lastName", "lastNameDTO")
                .field("email", "emailDTO")
                .field("age", "ageDTO")
                .field("gender", "genderDTO")
                .byDefault()
                .register();

        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        PersonCustomDTO personCustomDTO = mapperFacade.map(person, PersonCustomDTO.class);
        System.out.println(personCustomDTO);
    }
}