import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class AppService {

  public authenticated = false;

  constructor(private http: HttpClient) { }

  authenticate(credentials: { username: any; password: any; } | undefined, callback: any) {

    const headers = new HttpHeaders(credentials ? {
        authorization : 'Basic ' + Buffer.from(credentials.username + ':' + credentials.password).toString('base64')
    } : {});

    this.http.get('user', {headers: headers}).subscribe((response:any) => {
        if (response['name']) {
            this.authenticated = true;
        } else {
            this.authenticated = false;
        }
        return callback && callback();
    });
  }
}