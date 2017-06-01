import { artistStubService } from './../../artists/shared/artist-stub.service';
import { albumStubService } from './../shared/album-stub.service';
import { trackStubService } from './../../tracks/shared/track-stub.service';
import { TrackService } from './../../tracks/shared/track.service';
import { AlbumService } from './../shared/album.service';
import { ArtistService } from './../../artists/shared/artist.service';
import { Observable } from 'rxjs/Observable';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule, ActivatedRoute } from '@angular/router';
import { TracksModule } from './../../tracks/tracks.module';
import { CoreModule } from './../../core/core.module';
import { CommonModule } from '@angular/common';
import { ComponentFixture, async, TestBed } from '@angular/core/testing';
import 'rxjs/add/observable/of';

import { AlbumDetailComponent } from './album-detail.component';

describe('AlbumDetailComponent', () => {
  let component: AlbumDetailComponent;
  let fixture: ComponentFixture<AlbumDetailComponent>;
  let albumService: AlbumService;
  let artistService: ArtistService;
  let trackService: TrackService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AlbumDetailComponent],
      imports: [
        CommonModule,
        CoreModule,
        TracksModule,
        RouterModule,
        NgbModule,
      ],
      providers: [
        {
          provide: ActivatedRoute,
          useValue: {
            snapshot: {
              params: Observable.of({ id: '5915bc404de7b6ec23a188cf' }),
            },
          },
        },
        ArtistService,
        AlbumService,
        TrackService,
      ],
    })
      .compileComponents();


  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlbumDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();

    albumService = fixture.debugElement.injector.get(AlbumService);
    artistService = fixture.debugElement.injector.get(ArtistService);
    trackService = fixture.debugElement.injector.get(TrackService);

    spyOn(albumService, 'getOneById')
          .and.returnValue(albumStubService.getOneById);

    spyOn(artistService, 'getOneById')
          .and.returnValue(artistStubService.getOneById);

    spyOn(trackService, 'getManyByAlbum')
          .and.returnValue(trackStubService.getManyByAlbum);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
