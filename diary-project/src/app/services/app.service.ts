import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable()
export class AppService {

  public authenticated = false;

  constructor(private http: HttpClient) { }

  register( userDetails: {username: string, email: string, handle: string,password: string} ) {
    
    const headers = {
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    }
    console.log(userDetails)
    return this.http.post(environment.backend + '/spring/user/register', userDetails, { headers:headers })
  }

  authenticate(credentials: { username: string; password: string; } | undefined, callback: any) {

    const headers = new HttpHeaders(credentials ? {
        authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.http.get(environment.backend + '/spring/user/userDetails', {headers: headers}).subscribe((response:any) => {
        if (response['name']) {
            this.authenticated = true;
        } else {
            this.authenticated = false;
        }
        return callback && callback();
    });
  }
}