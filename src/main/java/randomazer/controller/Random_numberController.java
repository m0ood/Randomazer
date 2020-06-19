package randomazer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import randomazer.domain.Numeric;
import randomazer.domain.User;
import randomazer.repos.NumericRepo;

import java.util.Map;
@Controller
public class Random_numberController {
    @Autowired
    private NumericRepo numericRepo;
    @GetMapping("/random_number")
    public String random_number(Map<String,Object> model, @AuthenticationPrincipal User user) {
        Iterable<Numeric> numerics = numericRepo.findByAuthor(user);
        model.put("numerics", numerics);
        model.put("numeric", "0");
        return "random_number";
    }
    @PostMapping("/random_number")
    public String random_number_post(@AuthenticationPrincipal User user , @RequestParam int range1, @RequestParam int range2, Map<String,Object> model) {
        int num = (int) ((Math.random() * (range2 - range1)) + range1);
        String range = range1+"-"+range2;
        Numeric numeric = new Numeric();
        numeric.setValue(num);
        numeric.setRange(range);
        numeric.setAuthor(user);
        numericRepo.save(numeric);
        Iterable<Numeric> numerics = numericRepo.findByAuthor(user);
        model.put("numerics", numerics);
        model.put("numeric", num);
        return "random_number";
    }
}
