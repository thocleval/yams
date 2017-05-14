import { DummyComponent } from './../../../core/dummy/dummy.component';
import { MOCK_SINGLE_ALBUM } from './../../shared/mock-single-album';
import { AlbumDetailComponent } from './../../album-detail/album-detail.component';
import { AlbumListComponent } from './../album-list.component';
import { AlbumsRoutes } from './../../albums.routing';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpModule } from '@angular/http';
import { TracksModule } from './../../../tracks/tracks.module';
import { CoreModule } from './../../../core/core.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbumItemComponent } from './album-item.component';

describe('AlbumItemComponent', () => {
  let component: AlbumItemComponent;
  let fixture: ComponentFixture<AlbumItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlbumItemComponent ],
      imports: [
        CommonModule,
        CoreModule,
        TracksModule,
        NgbModule,
        HttpModule,
        RouterTestingModule.withRoutes([{
          path: 'albums/:id',
          component: DummyComponent
        }]),
      ],
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlbumItemComponent);
    component = fixture.componentInstance;
    component.album = MOCK_SINGLE_ALBUM;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
