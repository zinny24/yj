package com.example.yangjung.restapi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
class Person {

    private Long id;
    private String username;
    private String passwd;

}

@RestController
@RequestMapping("/api/v5")
public class RestV5Controller {

    Map<Long, Person> map = new HashMap<>();
    private Long sequenceNum = 1L;

    @PostMapping("/save")
    public Person savePerson(@RequestBody Person p) {
        p.setId(++sequenceNum);
        map.put(p.getId(), p);

        return p;
    }

    @GetMapping("/view/{id}")
    public Person viewPerson(@PathVariable Long id) {
        return map.get(id);
    }

    @PutMapping("/edit/{id}")
    public Person editPerson(@PathVariable Long id, @RequestBody Person p) {
        Person person = map.get(id);

        if( person != null ) {
            person.setUsername(p.getUsername());
            person.setPasswd(p.getPasswd());
        }
        return person;
    }

}
