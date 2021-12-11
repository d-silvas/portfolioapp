import { createFeatureSelector, createSelector } from '@ngrx/store';

import { TickersState } from './state';

export const getTickersState = createFeatureSelector<TickersState>('albums');

export const getTickers = createSelector(
  getTickersState,
  (state: TickersState) => state.tickers.data
);
