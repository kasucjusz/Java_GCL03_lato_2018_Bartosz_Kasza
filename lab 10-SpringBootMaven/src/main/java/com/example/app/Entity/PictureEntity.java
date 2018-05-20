
package com.example.app.Entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class PictureEntity {



    //////co ciekawe, od tego w jakiej kolejnosci sobie zadeklarujemy zmienne w takiej kolejnosci bedzie wypisywac w formacie json

    private int id;
    private String name;
    private File images;
    private String resolution;
    private long sizeInBytes;
    private long created;



    //////brak uzwania application.propertise cos nie dziala


    ////utworzyc przykladowa osobna kalse z odpowiednia adnotacjaj np component

    public PictureEntity(int id, String name) throws IOException {
        this.id=id;
        this.name=name;

        this.images = new File("C:\\Users\\barto\\IdeaProjects\\SpringBootMaven\\src\\main\\resources\\images\\" + this.name + ".jpg");
        this.sizeInBytes = images.length();

        this.created=images.lastModified();
       // this.created=System.currentTimeMillis() / 1000L;


        BufferedImage bufferedImage=ImageIO.read(this.images);
        int width=bufferedImage.getWidth();

        int height=bufferedImage.getHeight();
        this.resolution=width+" x "+height;



    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getImages() {
        return images;
    }

    public void setImages(File images) {
        this.images = images;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }

    public void setSizeInBytes(long sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }
}
