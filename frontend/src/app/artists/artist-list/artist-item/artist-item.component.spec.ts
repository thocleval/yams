import { DummyComponent } from './../../../core/dummy/dummy.component';
import { MOCK_SINGLE_ARTIST } from './../../shared/mock-single-artist';
import { AlbumsModule } from './../../../albums/albums.module';
import { CoreModule } from './../../../core/core.module';
import { ArtistDetailComponent } from './../../artist-detail/artist-detail.component';
import { ArtistsPageComponent } from './../../artists-page/artists-page.component';
import { ArtistsRoutes } from './../../artists.routing';
import { RouterModule } from '@angular/router';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { ArtistItemComponent } from './artist-item.component';

describe('ArtistItemComponent', () => {
  let component: ArtistItemComponent;
  let fixture: ComponentFixture<ArtistItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArtistItemComponent ],
      imports: [
        CoreModule,
        AlbumsModule,
        RouterTestingModule.withRoutes([{
          path: 'artists/:id',
          component: DummyComponent
        }]),
      ],
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtistItemComponent);
    component = fixture.componentInstance;
    component.artist = MOCK_SINGLE_ARTIST;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
