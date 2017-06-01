import { Response, Headers, Http, RequestOptions } from '@angular/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class ApiHelperService {
  public API_ROOT = '/api/';
  public headers: Headers;

  constructor(private http: Http) {
    this.headers = new Headers();
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('Access-Control-Allow-Origin', '*');
  }

  public get(url, params = {}): Promise<any> {
    const options = new RequestOptions({
      headers: this.headers,
      params
    });

    return this.http.get(this.API_ROOT + url, options)
      .map(this.extractData)
      .catch(this.handleError)
      .toPromise();
  }

  private extractData(res: Response) {
    const body = res.json();
    return body;
  }

  private handleError(error: Response | any): Promise<any> {
    // In a real world app, you might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    return Promise.reject(errMsg);
  }
}
