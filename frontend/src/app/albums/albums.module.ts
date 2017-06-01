import { HttpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TracksModule } from './../tracks/tracks.module';
import { CoreModule } from './../core/core.module';
import { RouterModule } from '@angular/router';
import { AlbumItemComponent } from './album-list/album-item/album-item.component';
import { AlbumDetailComponent } from './album-detail/album-detail.component';
import { AlbumListComponent } from './album-list/album-list.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    CoreModule,
    TracksModule,
    NgbModule,
    HttpModule,
  ],
  declarations: [
    AlbumListComponent,
    AlbumDetailComponent,
    AlbumItemComponent,
  ],
  exports: [
    AlbumListComponent,
    AlbumDetailComponent,
    AlbumItemComponent,
  ]
})
export class AlbumsModule { }
