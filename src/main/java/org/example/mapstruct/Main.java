package org.example.mapstruct;

import org.example.mapstruct.dto.PersonCustomDTO;
import org.example.mapstruct.dto.PersonDefaultDTO;
import org.example.mapstruct.entites.Person;
import org.example.mapstruct.mapper.PersonMapper;

//Mapstruct funciona con interfaces.
public class Main {

    /* Mapstruct - Defautl */
    /*public static void main(String[] args) {

        Person person = new Person(1L, "Santiago", "Perez", "santy@gmail.com", (byte) 25, 'M');
        System.out.println(person);

                                          //Se define la instancia y despues se llama al metodo.
        PersonDefaultDTO personDefaultDTO = PersonMapper.INSTANCE.personToPersonDefaultDTO(person);
        System.out.println(personDefaultDTO);
    }*/

    /* Mapstruct - Custom */
    public static void main(String[] args) {

        Person person = new Person(1L, "Santiago", "Perez", "santy@gmail.com", (byte) 25, 'M');
        System.out.println(person);

        PersonCustomDTO personCustomDTO = PersonMapper.INSTANCE.personToPersonCustomDTO(person);
        System.out.println(personCustomDTO);
    }
}
