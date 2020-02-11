import { TestBed } from '@angular/core/testing';

import { StorageSessionServiceService } from './storage-session-service.service';

describe('StorageSessionServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StorageSessionServiceService = TestBed.get(StorageSessionServiceService);
    expect(service).toBeTruthy();
  });
});
