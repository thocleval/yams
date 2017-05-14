import { CoreModule } from './../../core/core.module';
import { AlbumsModule } from './../../albums/albums.module';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs/Observable';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtistDetailComponent } from './artist-detail.component';

describe('ArtistDetailComponent', () => {
  let component: ArtistDetailComponent;
  let fixture: ComponentFixture<ArtistDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ArtistDetailComponent],
      providers: [
        {
          provide: ActivatedRoute,
          useValue: {
            params: Observable.of({ id: '59146247225c3ca77f8e868c' }),
          },
        },
      ],
      imports: [
        CommonModule,
        RouterModule,
        AlbumsModule,
        CoreModule,
      ],
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtistDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
