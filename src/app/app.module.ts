import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
import { AuthInterceptor } from './auth/auth.interceptor';
import { UserService } from './services/user.service';
import { JobComponent } from './component/job/job.component';
import { CreateJobComponent } from './component/job/create-job/create-job.component';
import { UpdateJobComponent } from './component/job/update-job/update-job.component';
import { InterviewComponent } from './component/interview/interview.component';
import { CreateInterviewComponent } from './component/interview/create-interview/create-interview.component';
import { CreateUpdateComponent } from './component/interview/create-update/create-update.component';
import { TypeInterviewComponent } from './component/interview/type-interview/type-interview.component';
import { PythonCompilerComponent } from './component/python-compiler/python-compiler.component';
import { FooterComponent } from './component/footer/footer.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AdminComponent,
    UserComponent,
    LoginComponent,
    HeaderComponent,
    ForbiddenComponent,
    JobComponent,
    CreateJobComponent,
    UpdateJobComponent,
    InterviewComponent,
    CreateInterviewComponent,
    CreateUpdateComponent,
    TypeInterviewComponent,
    PythonCompilerComponent,
    FooterComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
    NgbModule
  ],
  providers: [
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    },
    UserService
  ],
  bootstrap: [AppComponent],
})
export class AppModule { }