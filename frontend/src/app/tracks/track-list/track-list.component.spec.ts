import { TRACKS } from './../../mock-tracks';
import { TrackDurationPipe } from './../shared/track-duration.pipe';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CommonModule } from '@angular/common';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackListComponent } from './track-list.component';

describe('TrackListComponent', () => {
  let component: TrackListComponent;
  let fixture: ComponentFixture<TrackListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        TrackListComponent,
        TrackDurationPipe,
      ],
      imports: [
        CommonModule,
        NgbModule.forRoot(),
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackListComponent);
    component = fixture.componentInstance;
    component.tracks = TRACKS;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
