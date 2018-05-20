package com.example.app.Service;

import com.example.app.Dao.PictureDao;
import com.example.app.Entity.PictureEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.http.*;

import java.io.IOException;
import java.util.Collection;
@Service
public class PictureService {


    @Autowired
    public PictureDao pictureDao;

    public Collection<PictureEntity> getAllPictures()
    {
        return this.pictureDao.getAllPictures();
    }
    public Page<PictureEntity> findPage(Pageable pageable)
    {
        return (Page<PictureEntity>) pictureDao.getAllPictures();

    }

    public ResponseEntity<byte[]> getPictureById(int id) throws IOException {
        return this.pictureDao.getPictureById(id);


    }

    public void removePictureById(int id)
    {
        this.pictureDao.removePictureById(id);
    }




}
