import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Interview } from 'src/app/model/Interview';
import { InterviewService } from 'src/app/services/interview.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-type-interview',
  templateUrl: './type-interview.component.html',
  styleUrls: ['./type-interview.component.css']
})
export class TypeInterviewComponent implements OnInit {
  public type!: any;
  interview: Interview[] | undefined;
  message: string | undefined;
  constructor(public userService:UserService,private interviewService: InterviewService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.type=this.route.snapshot.params['type'];
    this.interviewService.getInterviewByType(this.type).subscribe(data => {
      this.interview = data;
      console.log(this.interview);
      console.log(this.interview[0]);
      if(this.interview[0].type=="2")
      {
        this.message="C++";
      }else if (this.interview[0].type=="1") {
        this.message="Java";
      } else {
        this.message="Python";
      }
    }, (error: any) => console.log(error));
  }
   
  updateInterview(id: any){
    this.router.navigate(['update-interview', id]);
  }


  deleteInterview(id: any){
    this.interviewService.deleteInterview(id).subscribe( data => {
      console.log(data);
    })
  }
}
