import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatStepperModule } from '@angular/material/stepper';
import { MatCardModule } from '@angular/material/card';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { AppComponent } from './app.component';
@NgModule({
 declarations: [AppComponent],
 imports: [BrowserModule, BrowserAnimationsModule, HttpClientModule, ReactiveFormsModule, MatInputModule, MatButtonModule, MatSelectModule, MatStepperModule, MatCardModule, MatProgressSpinnerModule],
 bootstrap: [AppComponent]
})
export class AppModule {}
