import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TickersComponent } from './tickers.component';

@NgModule({
  declarations: [TickersComponent],
  imports: [CommonModule],
  exports: [TickersComponent],
})
export class TickersModule {}
