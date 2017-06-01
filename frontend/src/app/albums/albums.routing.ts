import { AlbumDetailComponent } from './album-detail/album-detail.component';
import { AlbumListComponent } from './album-list/album-list.component';
import { Route } from '@angular/router';

export const AlbumsRoutes: Route[] = [
  {
    path: 'albums',
    component: AlbumListComponent
  },
  {
    path: 'artists/:artistId/albums/:albumId',
    component: AlbumDetailComponent
  },
];
