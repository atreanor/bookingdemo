package alan.bookingdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @RequestMapping("/connect5")
    public String table(){
        int[][] newTable = new int[6][7];
        for (int i=0; i < newTable.length; i++){
            for (int j=0; j < newTable[i].length; j++){
                newTable[i][j] = 0;
                System.out.print("[" + j + "]");
            }
            System.out.print("<br>");
        }
        return "Not sure what's going on here";
    }
}
