import { MockComponent } from 'ng2-mock-component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CoreModule } from './../../core/core.module';
import { CommonModule } from '@angular/common';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtistsPageComponent } from './artists-page.component';

describe('ArtistsPageComponent', () => {
  let component: ArtistsPageComponent;
  let fixture: ComponentFixture<ArtistsPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        ArtistsPageComponent,
        MockComponent({ selector: 'app-artist-list', inputs: ['artists'] }),
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
    fixture = TestBed.createComponent(ArtistsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
