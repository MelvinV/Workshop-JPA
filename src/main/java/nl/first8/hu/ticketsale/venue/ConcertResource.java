package nl.first8.hu.ticketsale.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by melvin on 27-5-2017.
 */

@RestController
@RequestMapping("/concert")
@Transactional
public class ConcertResource {

    private final ConcertRepository repository;

    @Autowired
    public ConcertResource(ConcertRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Concert>> getByKeyword(@RequestParam("keywordType") String keywordType, @RequestParam("keyword") final String keyword) {
        try {
            List<Concert> concerts = null;

            switch(keywordType)
            {
                case "1":
                    concerts = repository.findByArtistName(keyword);
                    break;
                case "2":
                    concerts = repository.findByArtistGenre(keyword);
                    break;
                case "3":
                    concerts = repository.findByLocationName(keyword);
                    break;
            }

            return ResponseEntity.ok(concerts);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
