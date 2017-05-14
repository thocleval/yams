import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CoreModule } from './../../core/core.module';
import { RouterTestingModule } from '@angular/router/testing';
import { CommonModule } from '@angular/common';
import { MockComponent } from 'ng2-mock-component';
import { ARTISTS } from './../../mock-artists';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtistListComponent } from './artist-list.component';

describe('ArtistListComponent', () => {
  let component: ArtistListComponent;
  let fixture: ComponentFixture<ArtistListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        ArtistListComponent,
        MockComponent({ selector: 'app-artist-item', inputs: ['artist'] })
      ],
      imports: [
        CommonModule,
        CoreModule,
        NgbModule,
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtistListComponent);
    component = fixture.componentInstance;
    component.artists = ARTISTS;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
