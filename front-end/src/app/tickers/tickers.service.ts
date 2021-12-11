import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';

import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { PageableResource } from '../api/api-pageable-resource-request';
import { ApiService } from '../api/api.service';
import { Ticker } from './ticker';
import { TickerDto } from './ticker-dto';
import { TickersMapperService } from './tickers-mapper.service';

@Injectable({
  providedIn: 'root',
})
export class TickersService {
  constructor(
    private readonly _http: HttpClient,
    private readonly _tickersMapper: TickersMapperService,
    private readonly _apiService: ApiService
  ) {}

  getTickers(): Observable<Ticker[]> {
    // TODO map from dto
    return this._http.get<Ticker[]>(this._apiService.createApiUrl('tickers'));
  }
}
