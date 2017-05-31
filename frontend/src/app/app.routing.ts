import { ArtistsRoutes } from './artists/artists.routing';
import { AlbumsRoutes } from './albums/albums.routing';
import { AuthenticationRoutes } from './authentication/authentication.routing';
import { ErrorsRoutes } from './errors/errors.routing';
import { Routes } from '@angular/router';

export const routes: Routes = [
  ...AuthenticationRoutes,
  ...ErrorsRoutes,
  ...AlbumsRoutes,
  ...ArtistsRoutes,
];
