import { Injectable } from '@angular/core';

import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class ApiService {
  private readonly _url = environment.apiUrl;

  createApiUrl(resource: string): string {
    const resourceWithoutFrontSlash = resource.replace(/^\//, '');
    return `${this._url}/${resourceWithoutFrontSlash}`;
  }
}
