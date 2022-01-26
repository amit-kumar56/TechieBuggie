import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Interview } from 'src/app/model/Interview';
import { InterviewService } from 'src/app/services/interview.service';

@Component({
  selector: 'app-create-interview',
  templateUrl: './create-interview.component.html',
  styleUrls: ['./create-interview.component.css']
})
export class CreateInterviewComponent implements OnInit {
  interview: Interview  = new Interview();
  constructor(private interviewService: InterviewService,
              private router: Router) { }

  ngOnInit(): void {
  }

  saveInterview(){
    console.log("amit");
    return this.interviewService.addInterview(this.interview).subscribe(data => {
      console.log(data);
      this.goToInterviewList();
    },
      (error: any) => console.log(error));
  }
  goToInterviewList(){
    this.router.navigate(['/interview']);
  }

  onSubmit(){
    console.log(this.interview);
    this.saveInterview();
  }
}
