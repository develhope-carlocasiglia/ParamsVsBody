package co.develhope.Calendar.controller;

import co.develhope.Calendar.model.Calendar;
import co.develhope.Calendar.model.CalendarDTO;
import co.develhope.Calendar.model.User;
import co.develhope.Calendar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    UserService userService;

    @PostMapping("/create-user-with-params")
    public ResponseEntity createUserWithParams(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(userService.createUserWithParams(name, email, password));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/create-user-with-body")
    public ResponseEntity createUserWithBody(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.createUserWithBody(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/create-calendar-with-body-and-parameters")
    public ResponseEntity createCalendarWithBodyAndParameters(@RequestBody Calendar calendar, @RequestParam int userId) {
        try {
            // TODO inserire il calendario nel database DOPO AVERLO COLLEGATO all'utente
            return ResponseEntity.ok("qui dentro chiamo il service");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/create-calendar-with-dto")
    public ResponseEntity createCalendarWithDTO(@RequestBody CalendarDTO calendar) {
        try {
            System.out.println(calendar.getMessage());
            // Calendar calendarEntity = new Calendar();
            // calendarEntity.setName(calendar.getName());
            // ...
            // TODO inserire il calendario nel database DOPO AVERLO COLLEGATO all'utente
            return ResponseEntity.ok("qui dentro chiamo il service");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
