import { AlbumsModule } from './albums/albums.module';
import { ArtistsModule } from './artists/artists.module';
import { HomeModule } from './home/home.module';
import { ErrorModule } from './errors/errors.module';
import { CoreModule } from './core/core.module';
import { APP_BASE_HREF } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SharedModule } from './shared/shared.module';
import { AuthenticationModule } from './authentication/authentication.module';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { TestBed, async } from '@angular/core/testing';

import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { routes } from './app.routing';

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      imports: [
        BrowserModule,
        HttpModule,
        RouterModule.forRoot(routes),
        NgbModule.forRoot(),
        SharedModule.forRoot(),
        CoreModule,
        AuthenticationModule,
        ErrorModule,
        HomeModule,
        ArtistsModule,
        AlbumsModule,
      ],
      providers: [{
        provide: APP_BASE_HREF,
        useValue: '/'
      }],
    }).compileComponents();
  }));

  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));
});
