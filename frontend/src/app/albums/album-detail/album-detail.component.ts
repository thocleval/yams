import { AlbumService } from './../shared/album.service';
import { Album } from './../shared/album';
import { ActivatedRoute, Params } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-album-detail',
  templateUrl: './album-detail.component.html',
  styleUrls: ['./album-detail.component.scss'],
  providers: [AlbumService],
})
export class AlbumDetailComponent implements OnInit {
  private album: Album;

  constructor(
    private route: ActivatedRoute,
    private service: AlbumService,
  ) { }

  ngOnInit() {
    this.route.params
      // (+) converts string 'id' to a number
      .switchMap((params: Params) => this.service.getOneById(params['id']))
      .subscribe((album: Album) => this.album = album);
  }

  onFavClick() {

  }

  onPlayedClick() {
    for (const track of this.album.tracks) {
      track.played = true;
    }
  }
}
