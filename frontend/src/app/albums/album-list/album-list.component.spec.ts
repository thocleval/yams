import { DummyComponent } from './../../core/dummy/dummy.component';
import { AlbumDetailComponent } from './../album-detail/album-detail.component';
import { AlbumsRoutes } from './../albums.routing';
import { RouterTestingModule } from '@angular/router/testing';
import { ALBUMS } from './../../mock-albums';
import { AlbumItemComponent } from './album-item/album-item.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TracksModule } from './../../tracks/tracks.module';
import { CoreModule } from './../../core/core.module';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { MockComponent } from 'ng2-mock-component';


import { AlbumListComponent } from './album-list.component';

describe('AlbumListComponent', () => {
  let component: AlbumListComponent;
  let fixture: ComponentFixture<AlbumListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AlbumListComponent,
        MockComponent({ selector: 'app-album-item', inputs: ['album'] })
      ],
      imports: [
        CommonModule,
        RouterTestingModule.withRoutes([{
          path: 'albums/:id',
          component: DummyComponent
        }]),
        CoreModule,
        TracksModule,
        NgbModule,
      ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlbumListComponent);
    component = fixture.componentInstance;
    component.albums = ALBUMS;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
