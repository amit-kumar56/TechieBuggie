import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Interview } from '../model/Interview';

@Injectable({providedIn: 'root'})
export class InterviewService {

  private url = "https://amit-kumar56.github.io/TechieBuggie/interview-service/questions";
  requestHeader = new HttpHeaders({ 'No-Auth': 'True' });
  constructor(private http: HttpClient, private router: Router) {
    //this.url = 'http://companyservice-env.eba-2jpmpvgp.ap-south-1.elasticbeanstalk.com/companies/';

  }

  getInterviews(): Observable<Interview[]> {
    return this.http.get<Interview[]>(this.url , {
      headers: this.requestHeader,
    });
  }
  getInterviewById(id: string): Observable<Interview>{
    return this.http.get<Interview>(`${this.url}/${id}`);
  }
  getInterviewByType(type: string): Observable<Interview[]>{
    return this.http.get<Interview[]>(`${this.url}/type/${type}`,
    {headers: this.requestHeader,});

  }
  addInterview(interview: Interview): Observable<Object>{
    return this.http.post(`${this.url}`, interview);
  }
  updateInterview(id: string, interview:Interview): Observable<Object>{
    return this.http.put(`${this.url}`, interview);
  }

  deleteInterview(id: string): Observable<Object>{
    return this.http.delete(`${this.url}/${id}`);
  }
}

