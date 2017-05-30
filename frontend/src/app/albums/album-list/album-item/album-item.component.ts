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
    console.log(this.album);
    this.album.tracks = [];
    this.trackService.getMany({ album: this.album.id })
      .subscribe(tracks => this.album.tracks = tracks);
  }

}
