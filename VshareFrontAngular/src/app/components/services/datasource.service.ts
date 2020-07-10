
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ResDataModal} from '../modals/resDataModal';

@Injectable({
  providedIn: 'root'
})
export class DatasourceService {
  apiUrl = 'https://localhost:8080/webscrapping';

  constructor(private http: HttpClient) { }

  getData() {
    return this.http.get<any>(this.apiUrl);
  }
}