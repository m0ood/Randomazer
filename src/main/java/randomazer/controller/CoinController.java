package randomazer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
@Controller
public class CoinController {
    @GetMapping("/coin")
    public String coin(Map<String,Object> model) {
        int num = (int) ((Math.random() * (3 - 1)) + 1);
        if (num==1)
            model.put("coin", "орел");
        if(num==2)
            model.put("coin", "решка");
        return "coin";
    }
}
