package com.ups.yams;

import com.ups.yams.model.music.Artist;
import com.ups.yams.model.music.Album;
import com.ups.yams.model.music.Artist;
import com.ups.yams.model.music.Track;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class GlobalRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.getCorsRegistry()
                .addMapping("/api/**")
                .allowedOrigins("*").allowedMethods("*");
        config.exposeIdsFor(Artist.class);
        config.exposeIdsFor(Album.class);
        config.exposeIdsFor(Track.class);
    }

}