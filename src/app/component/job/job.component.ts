import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Job } from 'src/app/model/Job';
import { JobService } from 'src/app/services/job.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-job',
  templateUrl: './job.component.html',
  styleUrls: ['./job.component.css']
})
export class JobComponent implements OnInit {

  jobs: Job[] | undefined;

  constructor(public userService:UserService,private jobService: JobService , private router: Router) { }

  ngOnInit(): void {
    this.getJob();
  }

  private getJob(){
    this.jobService.getJobs().subscribe(data => {
      this.jobs = data;
    });
  }

   
  updateJob(id: any){
    this.router.navigate(['update-job', id]);
  }



  deleteJob(id: any){
    this.jobService.deleteJob(id).subscribe( data => {
      console.log(data);
      this.getJob();
    })
  }

}
