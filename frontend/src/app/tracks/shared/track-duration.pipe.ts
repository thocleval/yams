import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'trackDuration'})
export class TrackDurationPipe implements PipeTransform {
  transform(value: number): string {
    return Math.floor(value / 60) + ':' + value % 60;
  }
}
