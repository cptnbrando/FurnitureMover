import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FurnitureUpdateComponent } from './furniture-update.component';

describe('FurnitureUpdateComponent', () => {
  let component: FurnitureUpdateComponent;
  let fixture: ComponentFixture<FurnitureUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FurnitureUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FurnitureUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
