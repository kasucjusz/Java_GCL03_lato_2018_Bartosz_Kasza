package com.example.app.Controller;


import com.example.app.Entity.PictureEntity;
import com.example.app.Service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

@RestController
public class PictureController {

    @Autowired
    private PictureService pictureService;


    @RequestMapping(value="/gallery/picture",method= RequestMethod.GET)
    public Collection<PictureEntity> getAllPictures()
    {
        return this.pictureService.getAllPictures();
    }

    @RequestMapping(value = "/gallery/picture/{id}", method =RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> getPicturesById(@PathVariable("id")int id) throws IOException {
        return pictureService.getPictureById(id);
    }

    @RequestMapping(value="/gallery/picture/{id}", method=RequestMethod.DELETE)
    public String deletePictureById(@PathVariable("id")int id)
    {
        String wynik;
        HashMap<String, String> result=new HashMap<>();
        if(pictureService.pictureDao.mapka.containsKey(id))
        {
            pictureService.removePictureById(id);
            wynik=("result : true");
            return wynik;
        }
        else
        {
            wynik=("result : false");
            return wynik;
        }
    }



}
