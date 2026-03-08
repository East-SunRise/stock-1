package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vo.ResultVO;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public ResultVO<String> hello() {
        return new ResultVO<>(200, "success", "Hello Spring Boot");
    }
}

