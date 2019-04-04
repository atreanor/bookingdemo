package alan.bookingdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ViewController {

    @RequestMapping
    public String index(Model model) {
	// model attributes to define environment
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Alan Treanor");
        model.addAttribute("mode", "production");
        return "index";
    }
}
