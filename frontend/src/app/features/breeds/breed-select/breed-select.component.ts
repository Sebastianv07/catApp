import { Component, OnInit } from '@angular/core';
import { ImageService } from '../../../core/services/image.service';
import { CatBreed } from '../../../core/models/breed.model';
import { CatImage } from '../../../core/models/image.model';
import { BreedService } from 'src/app/core/services/breed.service';

@Component({
  selector: 'app-breed-select',
  templateUrl: './breed-select.component.html'
})
export class BreedSelectComponent implements OnInit {
  breeds: CatBreed[] = [];
  selectedBreed = '';
  breedInfo?: CatBreed;
  breedImages: CatImage[] = [];
  loading = false;

  constructor(private breedSrv: BreedService, private imgSrv: ImageService) {}

  ngOnInit(): void {
    this.breedSrv.getAllBreeds().subscribe(b => this.breeds = b);
  }

  onSelectBreed(): void {
    if (!this.selectedBreed) return;
    this.loading = true;
    this.breedSrv.getBreedById(this.selectedBreed).subscribe(b => {
      this.breedInfo = b;
      this.imgSrv.getImagesByBreedId(this.selectedBreed).subscribe(imgs => {
        this.breedImages = imgs;
        this.loading = false;
      }, _ => this.loading = false);
    }, _ => this.loading = false);
  }
}
