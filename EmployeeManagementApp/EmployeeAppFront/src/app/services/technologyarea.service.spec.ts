import { TestBed } from '@angular/core/testing';

import { TechnologyareaService } from './technologyarea.service';

describe('TechnologyareaService', () => {
  let service: TechnologyareaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TechnologyareaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
