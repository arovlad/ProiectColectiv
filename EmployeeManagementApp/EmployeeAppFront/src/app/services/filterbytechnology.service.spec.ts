import { TestBed } from '@angular/core/testing';

import { FilterbytechnologyService } from './filterbytechnology.service';

describe('FilterbytechnologyService', () => {
  let service: FilterbytechnologyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FilterbytechnologyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
