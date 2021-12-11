import { ApiRequest } from '../../api/api-request';
import { AppState } from '../../store/state';
import { Ticker } from '../ticker';

export interface TickersRootState extends AppState {
  tickers: TickersState;
}

export interface TickersState {
  tickers: ApiRequest<Ticker[]>;
}

export const albumsInitialState: TickersState = {
  tickers: { data: [], loading: false, error: null },
};
