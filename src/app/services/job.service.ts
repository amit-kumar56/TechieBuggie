import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Job } from '../model/Job';

@Injectable({providedIn: 'root'})
export class JobService {

  private url = "https://amit-kumar56.github.io/TechieBuggie/job-service/jobs";
  requestHeader = new HttpHeaders({ 'No-Auth': 'True' });
  constructor(private http: HttpClient, private router: Router) {
    //this.url = 'http://companyservice-env.eba-2jpmpvgp.ap-south-1.elasticbeanstalk.com/companies/';

  }

  getJobs(): Observable<Job[]> {
    console.log("amit kumar");
    return this.http.get<Job[]>(this.url , {
      headers: this.requestHeader,
    });
  }
  getJobById(id: number): Observable<Job>{
    return this.http.get<Job>(`${this.url}/${id}`);
  }

  addJob(job: Job): Observable<Object>{
    return this.http.post(`${this.url}`, job);
  }
  updateJob(id: number, job:Job): Observable<Object>{
    return this.http.put(`${this.url}`, job);
  }

  deleteJob(id: number): Observable<Object>{
    return this.http.delete(`${this.url}/${id}`);
  }
}

