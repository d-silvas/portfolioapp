import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UiModule } from './ui/ui.module';
import { reducers } from './store/reducer';
import { TickersModule } from './tickers/tickers.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    AppRoutingModule,
    BrowserAnimationsModule,
    UiModule,
    StoreModule.forRoot(reducers),
    EffectsModule.forRoot([]),
    TickersModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
