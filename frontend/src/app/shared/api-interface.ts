import { Observable } from 'rxjs/Observable';

export abstract class ApiInterface<T> {
  getOneById: (id: string) => Observable<any>;
  getMany: (params) => Observable<any>;
}
