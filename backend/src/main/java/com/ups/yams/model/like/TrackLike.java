package com.ups.yams.model.like;

import com.ups.yams.model.music.Track;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;

public class TrackLike extends Like {
    @DBRef
    @NotNull
    private Track track;

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
