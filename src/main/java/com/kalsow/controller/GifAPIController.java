package com.kalsow.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.kalsow.model.FrameModel;
import com.kalsow.model.GifModel;
import com.kalsow.model.PixelModel;
import com.kalsow.util.GifDecoder;
import com.kalsow.util.GifDecoder.GifImage;
import com.kalsow.util.ImageManipulator;

@RestController()
@RequestMapping("/")
public class GifAPIController {
    

    @GetMapping(value="/test")
    public String getHelloWorld() {
        System.out.println("hi");
        return "Hello World";
    }
    

    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody GifModel postPictureWithMediaType(@RequestParam MultipartFile file) {
        GifImage gif;
        ImageManipulator IM = new ImageManipulator();
        
        try {
            byte[] data = file.getBytes();
            gif = GifDecoder.read(data);
            final int frameCount = gif.getFrameCount();
            GifModel gifModel = new GifModel();
            for (int i = 0; i < 1; i++) {
                FrameModel frameModel = new FrameModel();
                
                final BufferedImage img = gif.getFrame(i);
                frameModel.setFrameNumber(i);
                frameModel.setDelay(gif.getDelay(i));
                int[][] pixels = IM.convertTo2DWithoutUsingGetRGB(img);
                //convert pixels to pixelModel
                List<PixelModel> pixelModelList = IM.getAverageOfPixelsForLEDMatrix(pixels, 20, 20);
                frameModel.setPixelModelList(pixelModelList);
                gifModel.addFrameModelToList(frameModel);

            }
            
            return gifModel;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
       return null; 
    }
    
    private List<PixelModel> convertPixelsToPixelModel(int[][]pixels){
        List<PixelModel> pixelModelList = new ArrayList<>();
        for (int row = 0; row < pixels[0].length; row++) {
           for (int col = 0; col < pixels[1].length; col++) {
               PixelModel pixelModel = new PixelModel();
               pixelModel.setRowLoc(row);
               pixelModel.setColLoc(col);
               pixelModel.setAlpha((pixels[row][col] >> 24) & 0xff);
               pixelModel.setRed((pixels[row][col] >> 16) & 0xff);
               pixelModel.setGreen((pixels[row][col] >> 8) & 0xff);
               pixelModel.setBlue(pixels[row][col] & 0xff);
               pixelModelList.add(pixelModel);
           }
         }
        return pixelModelList;
    }
    
    
    
    
}
