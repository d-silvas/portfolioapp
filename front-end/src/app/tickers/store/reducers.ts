import { Action, createReducer, on } from '@ngrx/store';

import * as albumsActions from './actions';
import { albumsInitialState, TickersState } from './state';

const reducer = createReducer(
  albumsInitialState,
  on(albumsActions.loadTickers, (state) => ({
    ...state,
    albums: {
      data: null,
      loading: true,
      error: null,
    },
  })),
  on(albumsActions.loadTickersSuccess, (state, { tickers: albums }) => ({
    ...state,
    albums: {
      data: albums,
      loading: false,
      error: null,
    },
  })),
  on(albumsActions.loadTickersFail, (state, { error }) => ({
    ...state,
    albums: {
      data: null,
      loading: false,
      error,
    },
  })),
  on(albumsActions.reset, () => albumsInitialState)
);

export const albumsReducer = (state: TickersState, action: Action) =>
  reducer(state, action);
