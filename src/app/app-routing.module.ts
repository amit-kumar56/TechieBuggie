import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { AuthGuard } from './auth/auth.guard';
import { JobComponent } from './component/job/job.component';
import { CreateJobComponent } from './component/job/create-job/create-job.component';
import { UpdateJobComponent } from './component/job/update-job/update-job.component';
import { InterviewComponent } from './component/interview/interview.component';
import { TypeInterviewComponent } from './component/interview/type-interview/type-interview.component';
import { CreateUpdateComponent } from './component/interview/create-update/create-update.component';
import { CreateInterviewComponent } from './component/interview/create-interview/create-interview.component';
import { PythonCompilerComponent } from './component/python-compiler/python-compiler.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'compiler', component: PythonCompilerComponent },
  { path: 'interview', component: InterviewComponent },
  { path: 'type-interview/:type', component: TypeInterviewComponent },
  { path: 'create-interview', component: CreateInterviewComponent },
  { path: 'update-interview/:id', component: CreateUpdateComponent },
  { path: 'admin', component: AdminComponent, canActivate:[AuthGuard], data:{roles:['Admin']} },
  { path: 'job', component: JobComponent, canActivate:[AuthGuard], data:{roles:['Admin','User']} },
 
  { path: 'create-job', component: CreateJobComponent, canActivate:[AuthGuard], data:{roles:['Admin']} },
  { path: 'update-job/:id', component: UpdateJobComponent, canActivate:[AuthGuard], data:{roles:['Admin']} },
  { path: 'user', component: UserComponent ,  canActivate:[AuthGuard], data:{roles:['User']} },
  { path: 'login', component: LoginComponent },
  { path: 'forbidden', component: ForbiddenComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}