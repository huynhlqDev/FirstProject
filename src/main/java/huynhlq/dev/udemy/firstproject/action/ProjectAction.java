package huynhlq.dev.udemy.firstproject.action;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProjectAction {

    @GetMapping("")
    public ResponseEntity<?> projectAction() {
        return new ResponseEntity<String>("OK",HttpStatus.OK);
    }
}
