package com.ups.yams.model.user

import com.ups.yams.model.like.Like
import com.ups.yams.model.like.TrackLike
import com.ups.yams.model.music.Track
import com.ups.yams.model.rating.Rating
import com.ups.yams.model.rating.TrackRating
import com.ups.yams.repository.TrackLikeMongoRepository
import com.ups.yams.repository.TrackMongoRepository
import com.ups.yams.repository.TrackRatingMongoRepository
import com.ups.yams.repository.UserMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
class UserITest extends Specification {
    @Autowired UserMongoRepository userMongoRepository
    @Autowired TrackMongoRepository trackMongoRepository
    @Autowired TrackRatingMongoRepository trackRatingMongoRepository
    @Autowired TrackLikeMongoRepository trackLikeMongoRepository

    def "test save repository"() {
        given: "an user"
        Track track = new Track(name: "track 1", trackNumber: 1, duration: 12)
        Track track2 = new Track(name: "track 2", trackNumber: 2, duration: 12)
        ArrayList<Rating> ratings = new ArrayList<>()
        TrackRating rating = new TrackRating(track: track, value: 3)
        TrackRating rating2 = new TrackRating(track: track2, value: 5)
        ratings.add(rating)
        ratings.add(rating2)


        Track track3 = new Track(name: "track 3", trackNumber: 3, duration: 12)
        Track track4 = new Track(name: "track 4", trackNumber: 4, duration: 12)
        ArrayList<Like> likes = new ArrayList<>()
        TrackLike like = new TrackLike(track:  track3)
        TrackLike like2 = new TrackLike(track:  track4)
        likes.add(like)
        likes.add(like2)

            User user = new User(name: "name", email: "aaaaa@bbbb.com", password: "abcdefg12345", profilePicture: "photo.jpg", likes: likes, ratings: ratings)

        when: "the user is saved"
        trackMongoRepository.save(track)
        trackMongoRepository.save(track2)
        trackMongoRepository.save(track3)
        trackMongoRepository.save(track4)
        trackRatingMongoRepository.save(rating)
        trackRatingMongoRepository.save(rating2)
        trackLikeMongoRepository.save(like)
        trackLikeMongoRepository.save(like2)
        userMongoRepository.save(user)

        then: "the user has an id"

        user.getId() != null
        track.getId() != null
        track2.getId() != null
        track3.getId() != null
        track4.getId() != null
        rating.getId() != null
        rating2.getId() != null
        like.getId() != null
        like2.getId() != null
    }

    def "test add rating"() {
        given: "an user and a track"
        Track track = new Track(name: "track 1", trackNumber: 1, duration: 12)
        Track track2 = new Track(name: "track 2", trackNumber: 2, duration: 12)
        ArrayList<Rating> ratings = new ArrayList<>()
        TrackRating rating = new TrackRating(track: track, value: 3)
        TrackRating rating2 = new TrackRating(track: track2, value: 5)
        ratings.add(rating)
        ratings.add(rating2)

        Track trackToRate = new Track(name: "track 2 add", trackNumber: 3, duration: 12)
        User user = new User(name: "name", email: "aaaaa@bbbb.com", password: "abcdefg12345", profilePicture: "photo.jpg", likes: new ArrayList<Like>(), ratings: ratings)

        when: "a rating is added"
        user.rate(trackToRate, 1)

        then: "the track is rated by the user"
        user.getRatings().size() == 3
        for(TrackRating r: user.getRatings()){
            if(r.getTrack() == trackToRate){
                r.getValue() == 1
            }
        }
    }


    def "test remove rating"() {
        given: "an user and a track"
        Track track = new Track(name: "track 1", trackNumber: 1, duration: 12)
        Track track2 = new Track(name: "track 2", trackNumber: 2, duration: 12)
        ArrayList<Rating> ratings = new ArrayList<>()
        TrackRating rating = new TrackRating(track: track, value: 3)
        TrackRating rating2 = new TrackRating(track: track2, value: 5)
        ratings.add(rating)
        ratings.add(rating2)
        User user = new User(name: "name", email: "aaaaa@bbbb.com", password: "abcdefg12345", profilePicture: "photo.jpg", likes: new ArrayList<Like>(), ratings: ratings)

        when: "a rating is deleted"
        user.unRate(track2)

        then: "the track is rated by the user"
        user.getRatings().size() == 1
        !user.getRatings().contains(rating2)
    }

    def "test add like"() {
        given: "an user and a track"
        Track track = new Track(name: "track 1", trackNumber: 1, duration: 12)
        Track track2 = new Track(name: "track 2", trackNumber: 2, duration: 12)
        ArrayList<Like> likes = new ArrayList<>()
        TrackLike like = new TrackLike(track: track)
        TrackLike like2 = new TrackLike(track: track2)
        likes.add(like)
        likes.add(like2)

        Track trackToLike = new Track(name: "track 2 add", trackNumber: 3, duration: 12)
        User user = new User(name: "name", email: "aaaaa@bbbb.com", password: "abcdefg12345", profilePicture: "photo.jpg", likes: likes, ratings: new ArrayList<Rating>())

        when: "a like is added"
        user.like(trackToLike)

        then: "the track is liked by the user"
        user.getLikes().size() == 3
        for(TrackLike l: user.getLikes()){
            if(l.getTrack() == trackToLike){
                true
            }
        }
    }


    def "test remove like"() {
        given: "an user and a track"
        Track track = new Track(name: "track 1", trackNumber: 1, duration: 12)
        Track track2 = new Track(name: "track 2", trackNumber: 2, duration: 12)
        ArrayList<Like> likes = new ArrayList<>()
        TrackLike like = new TrackLike(track: track)
        TrackLike like2 = new TrackLike(track: track2)
        likes.add(like)
        likes.add(like2)

        User user = new User(name: "name", email: "aaaaa@bbbb.com", password: "abcdefg12345", profilePicture: "photo.jpg", likes: likes, ratings: new ArrayList<Rating>())

        when: "a like is added"
        user.unLike(track2)

        then: "the track is liked by the user"
        user.getLikes().size() == 1
        !user.getLikes().contains(like2)
    }
}
