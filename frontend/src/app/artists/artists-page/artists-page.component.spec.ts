import { HttpModule } from '@angular/http';
import { artistStubService } from './../shared/artist-stub.service';
import { ArtistService } from './../shared/artist.service';
import { MockComponent } from 'ng2-mock-component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CoreModule } from './../../core/core.module';
import { CommonModule } from '@angular/common';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtistsPageComponent } from './artists-page.component';

describe('ArtistsPageComponent', () => {
  let component: ArtistsPageComponent;
  let fixture: ComponentFixture<ArtistsPageComponent>;
  let artistService: ArtistService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        ArtistsPageComponent,
        MockComponent({ selector: 'app-artist-list', inputs: ['artists'] }),
      ],
      providers: [
        ArtistService,
      ],
      imports: [
        CommonModule,
        CoreModule,
        NgbModule,
        HttpModule,
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtistsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();

    artistService = fixture.debugElement.injector.get(ArtistService);

    spyOn(artistService, 'getMany')
          .and.returnValue(artistStubService.getMany);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
