import { Component, OnInit,Inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Job } from 'src/app/model/Job';
import { JobService } from 'src/app/services/job.service';

@Component({
  selector: 'app-update-job',
  templateUrl: './update-job.component.html',
  styleUrls: ['./update-job.component.css']
})
export class UpdateJobComponent implements OnInit {

  public id!: any;
  job: Job = new Job();
  constructor(private jobService: JobService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id']
    this.jobService.getJobById(this.id).subscribe(data => {
      this.job = data;
    }, (error: any) => console.log(error));
  }
  
  onSubmit(){
    console.log("amit")
    this.jobService.updateJob(this.id, this.job).subscribe( data =>{
        this.goToJobList();
      }
      , (error: any) => console.log(error));
  }

  goToJobList(){
    this.router.navigate(['/job']);
  }

}
