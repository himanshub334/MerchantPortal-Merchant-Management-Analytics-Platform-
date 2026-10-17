import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
export interface Merchant { id: number; name: string; email: string; category: string; status: string; createdAt: string; }
@Injectable({ providedIn: 'root' })
export class MerchantService {
  private readonly base = 'http://localhost:8080/api/merchants';
  constructor(private http: HttpClient) {}
  list(): Observable<Merchant[]> { return this.http.get<Merchant[]>(this.base); }
  create(body: {name: string; email: string; category: string}): Observable<Merchant> { return this.http.post<Merchant>(this.base, body); }
  nameAvailable(name: string): Observable<{available: boolean}> { return this.http.get<{available: boolean}>(`${this.base}/name-available`, {params: {name}}); }
  summary(): Observable<Record<string, unknown>> { return this.http.get<Record<string, unknown>>(`${this.base}/summary`); }
}
