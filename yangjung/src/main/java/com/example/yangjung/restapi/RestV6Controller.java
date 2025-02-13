package com.example.yangjung.restapi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
class Movie {
    private Long id;
    private String title;
    private String genre;
    private Integer releaseYear;
}


@RestController
@RequestMapping("/api/v6")
public class RestV6Controller {

    Map<Long, Movie> map = new HashMap<>();

    @PostMapping("/save")
    public String saveMovie(@RequestBody Movie movie) {
        map.put(movie.getId(), movie);
        return "saved, Movie";
    }

    //개별 영화 정보 - @GetMapping("/view/{id}")
    @GetMapping("/view")
    public Map<Long, Movie> getAllMovies() {

        return map;
    }

    @PutMapping("/edit/{id}")
    public String editMovie(@PathVariable Long id,
                            @RequestBody Movie m) {
        map.put(id, m);

        return "Edit Completed...";
    }


    @DeleteMapping("/delete/{id}")
    public String delMovie(@PathVariable Long id) {
        map.remove(id);
        return "Delete, Completed...";
    }

}
