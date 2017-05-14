import { AlbumsModule } from './albums/albums.module';
import { ArtistsModule } from './artists/artists.module';
import { HomeModule } from './home/home.module';
import { ErrorModule } from './errors/errors.module';
import { CoreModule } from './core/core.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { APP_BASE_HREF } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';

import { AuthenticationModule } from './authentication/authentication.module';
import { SharedModule } from './shared/shared.module';

import { routes } from './app.routing';


@NgModule({
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
  declarations: [AppComponent],
  providers: [{
    provide: APP_BASE_HREF,
    useValue: '/'
  }],
  bootstrap: [AppComponent]

})

export class AppModule { }
