package com.ups.yams.model.like;

import com.ups.yams.model.music.Artist;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class ArtistLike extends Like {
    @DBRef
    private Artist artist;
}
