import { HttpModule } from '@angular/http';
import { CoreModule } from './../core/core.module';
import { RouterModule } from '@angular/router';
import { AlbumsModule } from './../albums/albums.module';
import { ArtistItemComponent } from './artist-list/artist-item/artist-item.component';
import { ArtistListComponent } from './artist-list/artist-list.component';
import { ArtistDetailComponent } from './artist-detail/artist-detail.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ArtistsPageComponent } from './artists-page/artists-page.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    AlbumsModule,
    CoreModule,
    HttpModule,
  ],
  declarations: [
    ArtistDetailComponent,
    ArtistListComponent,
    ArtistItemComponent,
    ArtistsPageComponent,
  ],
  exports: [
    ArtistDetailComponent,
    ArtistsPageComponent,
  ],
})
export class ArtistsModule { }
