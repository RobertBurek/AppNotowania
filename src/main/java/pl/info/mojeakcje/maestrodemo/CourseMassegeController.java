package pl.info.mojeakcje.maestrodemo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pl.info.mojeakcje.modele.Spolka;

@Controller
public class CourseMassegeController {

//    @MessageMapping("/maestro")
//    @SendTo("/topic/courses")
//    public CourseMassage get(CourseMassage courseMassage) {
//        return courseMassage;
//    }

    @MessageMapping("/maestro")
    @SendTo("/topic/courses")
    public Spolka get(Spolka spolka) {
        return spolka;
    }
}
