import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from './services/app.service';
import { finalize } from "rxjs/operators";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  title = 'diary-project';
  constructor(private appService: AppService, private http: HttpClient, private router: Router) {
    this.appService.authenticate( undefined , undefined);
  }
  logout() {
    this.http.post('logout', {}).pipe(
      finalize(() => {
        this.appService.authenticated = false;
        this.router.navigateByUrl('/login');
    })).subscribe();
  }
}
