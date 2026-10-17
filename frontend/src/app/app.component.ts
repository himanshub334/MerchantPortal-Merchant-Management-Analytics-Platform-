import { Component, OnInit } from '@angular/core';
import { AbstractControl, AsyncValidatorFn, FormBuilder, Validators } from '@angular/forms';
import { catchError, map, of, switchMap, timer } from 'rxjs';
import { Merchant, MerchantService } from './merchant.service';

@Component({
 selector: 'app-root',
 templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {
  merchants: Merchant[] = [];
  summary: Record<string, any> = {};
  busy = false;
  notice = '';
  error = '';
  readonly form = this.fb.group({
    name: ['', [Validators.required, Validators.maxLength(120)], [this.uniqueNameValidator()]],
    email: ['', [Validators.required, Validators.email]],
    category: ['', Validators.required]
  });
  constructor(private fb: FormBuilder, private api: MerchantService) {}
  ngOnInit(): void { this.refresh(); }
  uniqueNameValidator(): AsyncValidatorFn {
    return (control: AbstractControl) => {
      if (!control.value || control.invalid) return of(null);
      return timer(350).pipe(switchMap(() => this.api.nameAvailable(String(control.value)).pipe(
        map(result => result.available ? null : {nameTaken: true}),
        catchError(() => of(null))
      )));
    };
  }
  refresh(): void {
    this.api.list().subscribe({next: rows => this.merchants = rows, error: () => this.error = 'Could not load merchants. Is the API running?'});
    this.api.summary().subscribe({next: data => this.summary = data, error: () => this.summary = {}});
  }
  submit(): void {
    this.notice = ''; this.error = '';
    if (this.form.invalid) { this.form.markAllAsTouched(); return; }
    this.busy = true;
    const value = this.form.getRawValue();
    this.api.create({name: value.name!, email: value.email!, category: value.category!}).subscribe({
      next: merchant => { this.merchants = [merchant, ...this.merchants]; this.notice = 'Merchant submitted successfully.'; this.form.reset(); this.busy = false; this.refresh(); },
      error: err => { this.error = err?.error?.message || 'Unable to create merchant.'; this.busy = false; }
    });
  }
}
