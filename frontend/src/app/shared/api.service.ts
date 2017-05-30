import { ApiInterface } from './api-interface';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class ApiService<T> implements ApiInterface<T> {

  private API_ROOT = 'http://localhost:8080/api';
  private headers: Headers;

  constructor(private http: Http, private apiPath: string) {
    this.headers = new Headers();
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('Access-Control-Allow-Origin', '*');
  }

  getOneById(id: string): Observable<T> {
    return this.http.get(this.API_ROOT + this.apiPath + '/' + id)
      .map(this.extractData)
      .catch(this.handleError);
  }


  getMany(params): Observable<any> {
    const requestOptions = new RequestOptions({
      headers: this.headers,
      params
    });

    return this.http.get(this.API_ROOT + this.apiPath)
      .map(this.extractData)
      .catch(this.handleError);
  }

  private extractData(res: Response) {
    let body = res.json();
    console.log(body);
    return body._embedded || body || {};
  }

  private handleError(error: Response | any) {
    // In a real world app, you might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

}
