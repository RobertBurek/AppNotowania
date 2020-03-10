package pl.info.mojeakcje.maestrodemo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CourseMassegeController {

    @MessageMapping("/maestro")
    @SendTo("/topic/courses")
    public CourseMassage get(CourseMassage courseMassage) {
        return courseMassage;
    }
}
