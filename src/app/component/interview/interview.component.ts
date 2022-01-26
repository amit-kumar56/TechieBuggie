import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Interview } from 'src/app/model/Interview';
import { InterviewService } from 'src/app/services/interview.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-interview',
  templateUrl: './interview.component.html',
  styleUrls: ['./interview.component.css']
})
export class InterviewComponent implements OnInit {

  interview: Interview[] | undefined;

  constructor(public userService:UserService,private interviewService: InterviewService , private router: Router) { }

  ngOnInit(): void {
    this.getInterview();
  }

  private getInterview(){
    this.interviewService.getInterviews().subscribe(data => {
      this.interview = data;
    });
  }

  gotoFull(type: any){
    console.log("goto fun")
    this.router.navigate(['type-interview', type]);
  }


}
