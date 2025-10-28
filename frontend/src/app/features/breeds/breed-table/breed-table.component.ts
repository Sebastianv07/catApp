import { Component, OnInit } from '@angular/core';
import { BreedService } from '../../../core/services/breed.service';
import { CatBreed } from '../../../core/models/breed.model';

@Component({
  selector: 'app-breed-table',
  templateUrl: './breed-table.component.html'
})
export class BreedTableComponent implements OnInit {
  breeds: CatBreed[] = [];
  filteredBreeds: CatBreed[] = [];
  searchTerm = '';

  constructor(private breedSrv: BreedService) {}

  ngOnInit(): void {
    this.breedSrv.getAllBreeds().subscribe(b => {
      this.breeds = b;
      this.filteredBreeds = b;
    });
  }

  onSearch(): void {
    const t = this.searchTerm.toLowerCase();
    this.filteredBreeds = this.breeds.filter(b =>
      (b.name || '').toLowerCase().includes(t) ||
      (b.temperament || '').toLowerCase().includes(t) ||
      (b.origin || '').toLowerCase().includes(t)
    );
  }
}
