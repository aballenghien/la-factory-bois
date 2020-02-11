import { TestBed } from '@angular/core/testing';

import { IdeeService } from './idee.service';

describe('IdeeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IdeeService = TestBed.get(IdeeService);
    expect(service).toBeTruthy();
  });
});
