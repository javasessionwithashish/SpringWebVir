package io.virinchi.springweb.Controller;

import io.virinchi.springweb.Model.VirImgTable;
import io.virinchi.springweb.Repository.ImageRepository;
import io.virinchi.springweb.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Controller
public class GalleryController {

    @Autowired
    private ImageRepository imageRepository;


    @GetMapping("/gallery")
    public String galleryGet(Model m)
    {
        m.addAttribute("totalImages",imageRepository.findAll());
        return "galleryPage";
    }



    @PostMapping("/galleryPost")
    public String galleryPostReq(@RequestParam("image")MultipartFile image, Model m)
    {
        VirImgTable vit= new VirImgTable();

        try {
            byte[] imgBytes = image.getBytes();
            String imgString= Base64.getEncoder().encodeToString(imgBytes);
            vit.setImage(imgString);
            imageRepository.save(vit);
        }
catch (Exception e)
{
    e.printStackTrace();
}
m.addAttribute("totalImages",imageRepository.findAll());
        return "galleryPage";
    }
}
