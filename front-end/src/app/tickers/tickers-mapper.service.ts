import { Injectable } from '@angular/core';

import { Ticker } from './ticker';
import { TickerDto } from './ticker-dto';

@Injectable({ providedIn: 'root' })
export class TickersMapperService {
  fromDto(albumDto: TickerDto): Ticker {
    return {
      symbol: albumDto.symbol,
      exchange: albumDto.exchange,
      name: albumDto.name,
    };
  }
}
