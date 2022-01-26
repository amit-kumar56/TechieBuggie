import { Component, OnInit } from '@angular/core';
import { Job } from '../model/Job';
import { JobService } from '../services/job.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  jobs: Job[] | undefined;

  constructor(private jobService: JobService ) { }

  ngOnInit(): void {
    console.log("amit");
    this.getJob();
  }

  private getJob(){
    this.jobService.getJobs().subscribe(data => {
      this.jobs = data;
    });
  }

}

