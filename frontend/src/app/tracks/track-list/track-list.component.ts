import { Track } from './../shared/track';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-track-list',
  templateUrl: './track-list.component.html',
  styleUrls: ['./track-list.component.scss']
})
export class TrackListComponent implements OnInit {

  @Input() tracks: Track[];

  constructor() { }

  ngOnInit() {
  }

  onPlayedClick(track) {
    this.togglePlayed(track);
  }

  togglePlayed(track) {
    track.played = !track.played;
  }
}
