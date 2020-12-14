import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudTechnologyAreaComponent } from './crud-technology-area.component';

describe('CrudTechnologyAreaComponent', () => {
  let component: CrudTechnologyAreaComponent;
  let fixture: ComponentFixture<CrudTechnologyAreaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrudTechnologyAreaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrudTechnologyAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
