import { AlbumsRoutes } from './../albums/albums.routing';
import { ArtistsPageComponent } from './artists-page/artists-page.component';
import { ArtistDetailComponent } from './artist-detail/artist-detail.component';
import { ArtistListComponent } from './artist-list/artist-list.component';
import { Route } from '@angular/router';

export const ArtistsRoutes: Route[] = [
  {
    path: 'artists',
    component: ArtistsPageComponent
  },
  {
    path: 'artists/:artistId',
    component: ArtistDetailComponent
  },
  {
    path: '',
    redirectTo: '/artists',
    pathMatch: 'full'
  }
];
