package com.ups.yams.controllers;

import com.ups.yams.model.Artist;
import com.ups.yams.model.UserDataObject;
import com.ups.yams.repository.ArtistMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/artist")
public class ArtistController {

    @Autowired
    ArtistMongoRepository artistMongoRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody void addArtist(@ModelAttribute Artist artist) {
        artistMongoRepository.save(artist);
    }
}
