

package com.example.app.Dao;

import com.example.app.Entity.PictureEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.http.*;
import org.springframework.data.domain.*;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;




@Repository
public class PictureDao {

    public static Map<Integer,PictureEntity> mapka;




    static{

        mapka=new HashMap<Integer, PictureEntity>() {
            {
                try {
                    put(1, new PictureEntity(1, "Bartek"));
                    put(2, new PictureEntity(2, "Rafal"));
                    put(3,new PictureEntity(3, "Lukasz"));
                    put(4, new PictureEntity(4, "Pysk"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

    }



    public Collection<PictureEntity> getAllPictures()
    {
        return this.mapka.values();
    }



    public ResponseEntity<byte[]> getPictureById(int id) throws IOException{
        String name=mapka.get(id).getName();
        File imagePath=new File("C:\\Users\\barto\\IdeaProjects\\SpringBootMaven\\src\\main\\resources\\images\\"+name+".jpg");

        byte[]image= Files.readAllBytes(imagePath.toPath());
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return  new ResponseEntity<>(image, headers,HttpStatus.OK);
    }

    public void removePictureById(int id)
    {
        this.mapka.remove(id);
    }
    public int nextIndex = mapka.size() + 1;

    /////////////ew dorobi sie jeszcze dodawanie foty


}
