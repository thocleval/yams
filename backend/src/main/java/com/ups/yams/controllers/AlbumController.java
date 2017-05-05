package com.ups.yams.controllers;

import com.ups.yams.model.Album;
import com.ups.yams.repository.AlbumMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/albums")
public class AlbumController {

    @Autowired
    AlbumMongoRepository albumMongoRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    void addAlbum(@ModelAttribute Album album) {
        albumMongoRepository.save(album);
    }
}
