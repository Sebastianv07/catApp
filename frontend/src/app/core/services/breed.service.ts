import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CatBreed } from '../models/breed.model';
import { environment } from '../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class BreedService {
  private base = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  getAllBreeds(): Observable<CatBreed[]> {
    return this.http.get<CatBreed[]>(`${this.base}/gatos/breeds`);
  }

  getBreedById(id: string): Observable<CatBreed> {
    return this.http.get<CatBreed>(`${this.base}/gatos/breeds/${id}`);
  }

  searchBreeds(q: string): Observable<CatBreed[]> {
    let params = new HttpParams().set('q', q);
    return this.http.get<CatBreed[]>(`${this.base}/gatos/breeds/search`, { params });
  }
}
