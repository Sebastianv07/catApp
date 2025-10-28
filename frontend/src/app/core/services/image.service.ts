import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private apiUrl = 'http://localhost:8080/api/imagenes';

  constructor(private http: HttpClient) {}

  getImagesByBreedId(breedId: string, limit: number = 5): Observable<any> {
    return this.http.get(`${this.apiUrl}/imagesbybreedid?breedId=${breedId}&limit=${limit}`);
  }
}
