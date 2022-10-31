/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pws.b.takehome1;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author David
 */
@Controller
public class myController {
    @RequestMapping("/Login")
    //@ResponseBody
    public String getLogin (@RequestParam (value="inputNama") String getNama,
                        @RequestParam (value="inputTanggal") String getTanggal,
                        @RequestParam (value="inputFoto") MultipartFile getFoto,
                        Model model)
            throws IOException{
        byte[] img = getFoto.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imglink ="data:image/png;base64,".concat(base64Image);
        model.addAttribute("kirimanNama",getNama);
        model.addAttribute("kirimanTanggal", getTanggal);
        model.addAttribute("kirimanFoto", imglink);
        
        return "main";
    }    
}

