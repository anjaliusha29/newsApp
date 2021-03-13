import { Component, OnInit } from '@angular/core';
import { User } from '../../user';
import { AuthenticationService } from '../../authentication.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  newUser: User;
  
  constructor(private authService: AuthenticationService, private router: Router, 
    private matSnackBar: MatSnackBar) {
    this.newUser = new User();
  }

  ngOnInit() {
  }
  registerUser() {
    console.log("Register User data:", this.newUser);
    this.authService.registerUser(this.newUser).subscribe(data =>{
      this.matSnackBar.open('Successfully Registered.', '', { duration: 5000 });
      console.log(data);
      this.router.navigate(['/login']);
    },
    error =>{
      this.matSnackBar.open('Field is empty or userid exists', '', { duration: 5000 });
    });
  }
}
