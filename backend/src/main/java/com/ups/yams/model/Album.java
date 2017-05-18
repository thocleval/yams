package com.ups.yams.model;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Document(collection = "albums")
public class Album {

    @Id
    private String id;
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Date releaseDate;

    private String coverPicture;

    @Min(1)
    private int duration;

    private String streamingLink;

    public Album() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
