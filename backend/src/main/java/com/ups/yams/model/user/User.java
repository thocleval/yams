package com.ups.yams.model.user;

import com.ups.yams.model.like.Like;
import com.ups.yams.model.like.TrackLike;
import com.ups.yams.model.music.Track;
import com.ups.yams.model.rating.Rating;
import com.ups.yams.model.rating.TrackRating;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String password;

    private String profilePicture;

    @DBRef
    private List<Like> likes;

    @DBRef
    private List<Rating> ratings;

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String coverPicture) {
        this.profilePicture = coverPicture;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void rate(Track track, int value){
        TrackRating ratingToAdd = new TrackRating();
        ratingToAdd.setTrack(track);
        ratingToAdd.setValue(value);
        ratings.add(ratingToAdd);
    }

    public void unRate(Track track){
        Rating ratingToRemove = null;
        for(Rating rating: ratings){
            if(rating instanceof TrackRating){
                if(((TrackRating) rating).getTrack() == track){
                    ratingToRemove = rating;
                }
            }
        }
        if(ratingToRemove != null){
            ratings.remove(ratingToRemove);
        }
    }

    public void like(Track track){
        TrackLike likeToAdd = new TrackLike();
        likeToAdd.setTrack(track);
        likes.add(likeToAdd);
    }

    public void unLike(Track track){
        Like LikeToRemove = null;
        for(Like like: likes){
            if(like instanceof TrackLike){
                if(((TrackLike) like).getTrack() == track){
                    LikeToRemove = like;
                }
            }
        }
        if(LikeToRemove != null){
            likes.remove(LikeToRemove);
        }
    }
}
