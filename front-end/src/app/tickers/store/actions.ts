import { PageEvent } from '@angular/material/paginator';
import { createAction, props } from '@ngrx/store';

import { PageableResource } from '../../api/api-pageable-resource-request';
import { Ticker } from '../ticker';

export enum TickersActionTypes {
  loadTickers = '[Tickers] Load Albums',
  loadTickersSuccess = '[Tickers] Load Albums Success',
  loadTickersFail = '[Tickers] Load Albums Fail',
  reset = '[Tickers] Reset',
}

export const loadTickers = createAction(TickersActionTypes.loadTickers);

export const loadTickersSuccess = createAction(
  TickersActionTypes.loadTickersSuccess,
  props<{ tickers: PageableResource<Ticker[]> }>()
);

export const loadTickersFail = createAction(
  TickersActionTypes.loadTickersFail,
  props<{ error: any }>()
);

export const reset = createAction(TickersActionTypes.reset);
