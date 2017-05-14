import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TrackDurationPipe } from './shared/track-duration.pipe';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TrackListComponent } from './track-list/track-list.component';

@NgModule({
  imports: [
    CommonModule,
    NgbModule,
  ],
  declarations: [
    TrackListComponent,
    TrackDurationPipe,
  ],
  exports: [TrackListComponent],
})
export class TracksModule { }
