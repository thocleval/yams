import { Artist } from './../../shared/artist';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-artist-item',
  templateUrl: './artist-item.component.html',
  styleUrls: ['./artist-item.component.scss']
})
export class ArtistItemComponent implements OnInit {
  @Input() artist: Artist;
  constructor() { }

  ngOnInit() {
  }

}
