import { Injectable } from '@angular/core';
import { ServiceModel } from 'app/core/home/service.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable()
export class HomeService {
    private rawHeaders = {
        'Content-Type': 'application/json'
    };
    private headers = new Headers(this.rawHeaders);

    constructor(private http: HttpClient) {}

    getInstances(): Observable<ServiceModel[]> {
        return this.http.get(environment.SERVICE_EXPOSE_URL, { headers: this.headers }).pipe();
    }
}
