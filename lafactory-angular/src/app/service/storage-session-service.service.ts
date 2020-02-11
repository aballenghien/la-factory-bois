import { Injectable, Inject, InjectionToken } from '@angular/core';

import { SESSION_STORAGE, StorageService } from 'angular-webstorage-service';

export const SERVICE_SESSION_STORAGE =
    new InjectionToken<StorageService>('SERVICE_SESSION_STORAGE');

@Injectable({
  providedIn: 'root'
})
export class StorageSessionServiceService {

  constructor(@Inject(SERVICE_SESSION_STORAGE) private storage: StorageService) { }

  public get(key:string) : any{
    return this.storage.get(key);
  }

  public set(key:string, object:any) : void{
    this.storage.set(key, object);
  }
}



