import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrediccionItemComponent } from './prediccion-item.component';

describe('PrediccionItemComponent', () => {
  let component: PrediccionItemComponent;
  let fixture: ComponentFixture<PrediccionItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrediccionItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrediccionItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
