import { Component, OnDestroy, OnInit } from '@angular/core';
import { AppService } from 'src/app/services/app.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit, OnDestroy {

  constructor(private appService: AppService) { }
  

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
  }
}
