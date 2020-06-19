package randomazer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import randomazer.domain.Numeric;
import randomazer.repos.NumericRepo;

import javax.persistence.GenerationType;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private NumericRepo numericRepo;
    @GetMapping("/")
    public String home(Map<String,Object> model) {
        return "home";
    }
    @GetMapping("/login")
    public String login(Map<String,Object> model) {
        return "login";
    }
    @GetMapping("/main")
    public String main(Map<String,Object> model) {
        return "main";
    }
    @GetMapping("/random_number")
    public String random_number(Map<String,Object> model) {
            Iterable<Numeric> numerics = numericRepo.findAll();
            model.put("numerics", numerics);
            model.put("numeric", "0");
        return "random_number";
    }
    @PostMapping("/random_number")
    public String random_number_post(@RequestParam int range1,@RequestParam int range2, Map<String,Object> model) {
        int num = (int) ((Math.random() * (range2 - range1)) + range1);
        String range = range1+"-"+range2;
        Numeric numeric = new Numeric();
        numeric.setValue(num);
        numeric.setRange(range);
        numericRepo.save(numeric);
        Iterable<Numeric> numerics = numericRepo.findAll();
        model.put("numerics", numerics);
        model.put("numeric", num);
        return "random_number";
    }
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