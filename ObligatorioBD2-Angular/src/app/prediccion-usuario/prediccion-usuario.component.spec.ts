import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrediccionUsuarioComponent } from './prediccion-usuario.component';

describe('PrediccionUsuarioComponent', () => {
  let component: PrediccionUsuarioComponent;
  let fixture: ComponentFixture<PrediccionUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrediccionUsuarioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrediccionUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
