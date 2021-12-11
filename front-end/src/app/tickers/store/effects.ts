import { Injectable } from '@angular/core';

import { Actions, createEffect, ofType } from '@ngrx/effects';
import { map, switchMap } from 'rxjs/operators';

import { PageableResource } from '../../api/api-pageable-resource-request';
import { Ticker } from '../ticker';
import * as tickersActions from './actions';
import { TickersService } from '../tickers.service';

@Injectable()
export class AlbumsEffects {
  loadAlbums$ = createEffect(() =>
    this._actions$.pipe(
      ofType(tickersActions.loadTickers),
      switchMap(() =>
        this._tickersService
          .getAlbums()
          .pipe(
            map((tickers: Ticker[]) =>
              tickersActions.loadTickersSuccess({ tickers })
            )
          )
      )
    )
  );

  constructor(
    private readonly _actions$: Actions,
    private readonly _tickersService: TickersService
  ) {}
}
