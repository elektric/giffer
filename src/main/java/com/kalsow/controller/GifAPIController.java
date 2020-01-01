package com.kalsow.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.kalsow.util.GifDecoder;
import com.kalsow.util.ImageManipulator;
import com.kalsow.util.GifDecoder.GifImage;

@RestController()
@RequestMapping("/")
public class GifAPIController {
    

    @GetMapping(value="/test")
    public String getHelloWorld() {
        System.out.println("hi");
        return "Hello World";
    }
    

    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody int[][] postPictureWithMediaType(@RequestParam MultipartFile file) {
        GifImage gif;
        ImageManipulator IM = new ImageManipulator();
        
        try {
            byte[] data = file.getBytes();
            gif = GifDecoder.read(data);
//            final int width = gif.getWidth();
//            final int height = gif.getHeight();
//            final int background = gif.getBackgroundColor();
//            final int frameCount = gif.getFrameCount();
//            for (int i = 0; i < frameCount; i++) {
//                final BufferedImage img = gif.getFrame(i);
//                final int delay = gif.getDelay(i);
//                ImageIO.write(img, "png", new File("c:\\temp\\" + "frame_" + i + ".png"));
//            }
            final BufferedImage img = gif.getFrame(0);
            int[][] pixels = IM.convertTo2DWithoutUsingGetRGB(img);
            return pixels;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
       return null;
       
    }
    
    
    
    
}
