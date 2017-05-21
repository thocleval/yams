package com.ups.yams.model.rating;

import com.ups.yams.model.music.Album;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;

public class AlbumRating extends Rating {
    @DBRef
    @NotNull
    private Album album;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
