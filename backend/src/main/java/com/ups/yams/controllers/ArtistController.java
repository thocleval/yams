package com.ups.yams.controllers;

import com.ups.yams.model.Artist;
import com.ups.yams.repository.ArtistMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/artist")
public class ArtistController {

    @Autowired
    ArtistMongoRepository artistMongoRepository;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public @ResponseBody void addArtist(@ModelAttribute Artist artist) {
        artistMongoRepository.save(artist);
    }

    @RequestMapping(value = "{artistId}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteArtist(@PathVariable("artistId") String artistId) {
        Artist artist = artistMongoRepository.findOne(artistId);
        if (artist != null) {
            artistMongoRepository.delete(artist);
        }
    }

    @RequestMapping(value = "{artistId}", method = RequestMethod.POST)
    public @ResponseBody void updateArtist(@PathVariable("artistId") String artistId, @ModelAttribute("Artist") Artist artist) {
        if (artistMongoRepository.exists(artistId)) {
            artist.setId(artistId);
            artistMongoRepository.save(artist);
        }
    }

    @RequestMapping(value = "{artistId}", method = RequestMethod.GET)
    public @ResponseBody Artist getArtist(@PathVariable("artistId") String artistId) {
        return artistMongoRepository.findOne(artistId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Artist> getArtists() {
        return artistMongoRepository.findAll();
    }
}
