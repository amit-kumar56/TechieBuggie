import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Job } from 'src/app/model/Job';
import { JobService } from 'src/app/services/job.service';

@Component({
  selector: 'app-create-job',
  templateUrl: './create-job.component.html',
  styleUrls: ['./create-job.component.css']
})
export class CreateJobComponent implements OnInit {
  job: Job  = new Job();
  constructor(private jobService: JobService,
              private router: Router) { }

  ngOnInit(): void {
  }

  saveJob(){
    console.log("amit");
    return this.jobService.addJob(this.job).subscribe(data => {
      console.log(data);
      this.goToJobList();
    },
      (error: any) => console.log(error));
  }
  goToJobList(){
    this.router.navigate(['/job']);
  }

  onSubmit(){
    console.log(this.job);
    this.saveJob();
  }
}
