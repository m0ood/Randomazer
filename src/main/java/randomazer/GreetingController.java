package randomazer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import randomazer.domain.Numeric;
import randomazer.repos.NumericRepo;

import java.util.Map;
import java.util.Random;

@Controller
public class GreetingController {
    @Autowired
    private NumericRepo numericRepo;
    @GetMapping
    public String main(Map<String,Object> model) {
        model.put("some", "xd");
        return "main";
    }
    @GetMapping("/greeting")
    public String greeting(Map<String,Object> model) {
        Iterable<Numeric> numerics=numericRepo.findAll();
        model.put("numerics", numerics);
        return "greeting";
    }
    @PostMapping
    public String add (@RequestParam int range1,@RequestParam int range2, Map<String,Object> model)
    {
        int num = (int) ((Math.random() * (range2 - range1)) + range1);
        Numeric numeric= new Numeric();
        String range= String.format(String.valueOf(range1),range2);
        numeric.setValue(num);
        numeric.setRange(range);
        numericRepo.save(numeric);
        Iterable<Numeric> numerics=numericRepo.findAll();
        model.put("numerics", numerics);
        return "greeting";
    }
    @GetMapping("/coin")
    public String coin(Map<String,Object> model) {
        int num = (int) ((Math.random() * (3 - 1)) + 1);
        if (num==1)
             model.put("photo", "орел");
        else
            model.put("photo", "решка");
        return "coin";
    }
}