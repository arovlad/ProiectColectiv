import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddregionsComponent } from './addregions.component';

describe('AddregionsComponent', () => {
  let component: AddregionsComponent;
  let fixture: ComponentFixture<AddregionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddregionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddregionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
