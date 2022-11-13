/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwstugas.IdCard;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author USER DJOGJA
 */
@Controller
public class controller {
    
    @ResponseBody
    @RequestMapping ("/IdCard")
    
    public String IdCard (@RequestParam("Name")String text,
                          @RequestParam("Photo") MultipartFile file,
                          @RequestParam("Born") @DateTimeFormat (pattern="yyyy-MM-dd")Date date)
                            throws IOException, ParseException {
        
         SimpleDateFormat Born = new SimpleDateFormat("EE/dd-MMMM-yyyy");
             String newBorn = Born.format(date);
             
             String blob = Base64.encodeBase64String(file.getBytes());
             return text+"<br><img width=400' src='data:image/jpeg;base64, "+blob+" '/><br>"+ newBorn;
    }
    
}
