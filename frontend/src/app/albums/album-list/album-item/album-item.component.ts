import { TrackService } from './../../../tracks/shared/track.service';
import { Album } from './../../shared/album';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-album-item',
  templateUrl: './album-item.component.html',
  styleUrls: ['./album-item.component.scss'],
  providers: [
    TrackService
  ]
})
export class AlbumItemComponent implements OnInit {

  @Input() album: Album;

  constructor(private trackService: TrackService) { }

  ngOnInit() {
    this.album.tracks = [];
    this.trackService.getManyByAlbum( this.album.id )
      .then(tracks => this.album.tracks = tracks);
  }

}
