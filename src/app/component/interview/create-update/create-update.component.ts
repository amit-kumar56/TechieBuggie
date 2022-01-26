import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Interview } from 'src/app/model/Interview';
import { InterviewService } from 'src/app/services/interview.service';

@Component({
  selector: 'app-create-update',
  templateUrl: './create-update.component.html',
  styleUrls: ['./create-update.component.css']
})
export class CreateUpdateComponent implements OnInit {

  public id!: any;
  interview:Interview  = new Interview();
  constructor(private interviewService: InterviewService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id']
    this.interviewService.getInterviewById(this.id).subscribe(data => {
      this.interview = data;
    }, (error: any) => console.log(error));
  }
  
  onSubmit(){
    console.log("amit")
    this.interviewService.updateInterview(this.id, this.interview).subscribe( data =>{
        this.goToInterviewList();
      }
      , (error: any) => console.log(error));
  }

  goToInterviewList(){
    this.router.navigate(['/interview']);
  }

}
